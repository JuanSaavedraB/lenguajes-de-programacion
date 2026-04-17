package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioPolizas;
import pe.edu.pucp.inf13.dominio.Poliza;

import java.time.LocalDate;
import java.util.UUID;

public class GuardarPolizaCommand implements Comando {

    private final RepositorioPolizas repositorioPolizas;
    private final ContextoProceso contexto;

    public GuardarPolizaCommand(RepositorioPolizas repositorioPolizas, ContextoProceso contexto) {
        this.repositorioPolizas = repositorioPolizas;
        this.contexto = contexto;
    }

    @Override
    public void ejecutar() {
        if (!contexto.getResultadoAprobacion().isAprobada()) {
            System.out.println("La solicitud no fue aprobada. No se emite poliza.");
            return;
        }

        String numeroPoliza = "POL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Poliza poliza = new Poliza(
                numeroPoliza,
                contexto.getSolicitud().getId(),
                contexto.getSolicitud().getCliente(),
                contexto.getCotizacion().getMonto(),
                contexto.getCotizacion().getDescripcion(),
                contexto.getPuntajeRiesgo(),
                contexto.getResultadoAprobacion().getNivel(),
                LocalDate.now());

        repositorioPolizas.guardar(poliza);
        contexto.setPolizaEmitida(poliza);
        System.out.printf("Poliza emitida y guardada: %s%n", poliza.getNumeroPoliza());
    }

    @Override
    public String nombre() {
        return "GuardarPolizaCommand";
    }
}

