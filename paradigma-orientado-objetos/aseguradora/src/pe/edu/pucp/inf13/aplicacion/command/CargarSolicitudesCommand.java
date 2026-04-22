package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioSolicitudes;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

import java.util.List;

public class CargarSolicitudesCommand implements Comando {

    private final RepositorioSolicitudes repositorioSolicitudes;
    private List<SolicitudCotizacion> salida;

    public CargarSolicitudesCommand(RepositorioSolicitudes repositorioSolicitudes) {
        this.repositorioSolicitudes = repositorioSolicitudes;
    }

    @Override
    public void ejecutar() {
        salida = repositorioSolicitudes.leerTodo();
        System.out.printf("Solicitudes cargadas desde CSV: %d%n", salida.size());
    }

    @Override
    public String nombre() {
        return "CargarSolicitudesCommand";
    }

    public List<SolicitudCotizacion> getSalida() {
        return salida;
    }
}

