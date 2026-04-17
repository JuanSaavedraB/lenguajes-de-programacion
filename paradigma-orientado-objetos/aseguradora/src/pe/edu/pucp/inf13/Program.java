package pe.edu.pucp.inf13;

import pe.edu.pucp.inf13.aplicacion.command.AprobarCommand;
import pe.edu.pucp.inf13.aplicacion.command.CargarSolicitudesCommand;
import pe.edu.pucp.inf13.aplicacion.command.ContextoProceso;
import pe.edu.pucp.inf13.aplicacion.command.CotizarCommand;
import pe.edu.pucp.inf13.aplicacion.command.GuardarPolizaCommand;
import pe.edu.pucp.inf13.aplicacion.command.InvocadorComandos;
import pe.edu.pucp.inf13.aplicacion.command.NotificarCommand;
import pe.edu.pucp.inf13.aplicacion.factory.ServicioFactory;
import pe.edu.pucp.inf13.aplicacion.factory.ServicioFactoryImpl;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioPolizas;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioSolicitudes;
import pe.edu.pucp.inf13.dominio.Poliza;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        String rutaSolicitudes = "data/solicitudes.csv";
        String rutaPolizas = "data/polizas.csv";

        ServicioFactory factory = new ServicioFactoryImpl(rutaSolicitudes, rutaPolizas);
        RepositorioSolicitudes repositorioSolicitudes = factory.crearRepositorioSolicitudes();
        RepositorioPolizas repositorioPolizas = factory.crearRepositorioPolizas();

        InvocadorComandos invocador = new InvocadorComandos();

        CargarSolicitudesCommand cargaInicial = new CargarSolicitudesCommand(repositorioSolicitudes);
        invocador.ejecutar(cargaInicial);

        List<SolicitudCotizacion> solicitudes = new ArrayList<>(cargaInicial.getSalida());

        ejecutarMenu(factory, repositorioSolicitudes, repositorioPolizas, invocador, solicitudes);
    }

    private static void ejecutarMenu(ServicioFactory factory,
                                     RepositorioSolicitudes repositorioSolicitudes,
                                     RepositorioPolizas repositorioPolizas,
                                     InvocadorComandos invocador,
                                     List<SolicitudCotizacion> solicitudes) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n===== ASEGURADORA VEHICULAR (Consola) =====");
                System.out.println("1. Listar solicitudes cargadas");
                System.out.println("2. Recargar solicitudes desde CSV");
                System.out.println("3. Cotizar y procesar solicitud");
                System.out.println("4. Ver polizas emitidas (CSV)");
                System.out.println("0. Salir");
                System.out.print("Seleccione opcion: ");

                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1" -> listarSolicitudes(solicitudes);
                    case "2" -> {
                        CargarSolicitudesCommand recarga = new CargarSolicitudesCommand(repositorioSolicitudes);
                        invocador.ejecutar(recarga);
                        solicitudes.clear();
                        solicitudes.addAll(recarga.getSalida());
                    }
                    case "3" -> procesarSolicitud(scanner, solicitudes, factory, repositorioPolizas, invocador);
                    case "4" -> listarPolizas(repositorioPolizas.leerTodo());
                    case "0" -> continuar = false;
                    default -> System.out.println("Opcion invalida.");
                }
            }
        }
    }

    private static void listarSolicitudes(List<SolicitudCotizacion> solicitudes) {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes cargadas.");
            return;
        }

        String separador = "+----+----------------------+----------------------+------------+-----+-----+-----+";
        System.out.println(separador);
        System.out.printf("| %-2s | %-20s | %-20s | %-10s | %-3s | %-3s | %-3s |%n",
                "Id", "Cliente", "Vehiculo", "Antiguedad", "Rob", "Asi", "Des");
        System.out.println(separador);

        for (SolicitudCotizacion solicitud : solicitudes) {
            String vehiculo = solicitud.getVehiculo().getMarca() + " " + solicitud.getVehiculo().getPlaca();
            System.out.printf("| %2d | %-20.20s | %-20.20s | %10d | %-3s | %-3s | %-3s |%n",
                    solicitud.getId(),
                    solicitud.getCliente(),
                    vehiculo,
                    solicitud.getVehiculo().getAntiguedad(),
                    solicitud.isCoberturaRobos() ? "Si" : "No",
                    solicitud.isCoberturaAsistenciaVial() ? "Si" : "No",
                    solicitud.isCoberturaDesastresNaturales() ? "Si" : "No");
        }

        System.out.println(separador);
    }

    private static void procesarSolicitud(Scanner scanner,
                                          List<SolicitudCotizacion> solicitudes,
                                          ServicioFactory factory,
                                          RepositorioPolizas repositorioPolizas,
                                          InvocadorComandos invocador) {

        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes para procesar.");
            return;
        }

        System.out.print("Ingrese Id de solicitud: ");
        String entrada = scanner.nextLine();

        int id;
        try {
            id = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Id invalido.");
            return;
        }

        Optional<SolicitudCotizacion> solicitudOpt = solicitudes.stream()
                .filter(s -> s.getId() == id)
                .findFirst();

        if (solicitudOpt.isEmpty()) {
            System.out.println("No existe solicitud con ese Id.");
            return;
        }

        ContextoProceso contexto = new ContextoProceso(solicitudOpt.get());

        invocador.ejecutar(new CotizarCommand(factory.crearCotizador(), contexto));
        invocador.ejecutar(new AprobarCommand(factory.crearEvaluadorRiesgo(), contexto));
        invocador.ejecutar(new GuardarPolizaCommand(repositorioPolizas, contexto));
        invocador.ejecutar(new NotificarCommand(factory.crearNotificador(), contexto));
    }

    private static void listarPolizas(List<Poliza> polizas) {
        if (polizas.isEmpty()) {
            System.out.println("No hay polizas emitidas.");
            return;
        }

        for (Poliza poliza : polizas) {
            System.out.println(poliza);
        }
    }
}

