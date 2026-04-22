package pe.edu.pucp.inf13.infraestructura.riesgo;

import pe.edu.pucp.inf13.aplicacion.servicios.EvaluadorRiesgo;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public class EvaluadorRiesgoAdapter implements EvaluadorRiesgo {

    private final ServicioRiesgoLegacy servicioRiesgoLegacy;

    public EvaluadorRiesgoAdapter(ServicioRiesgoLegacy servicioRiesgoLegacy) {
        this.servicioRiesgoLegacy = servicioRiesgoLegacy;
    }

    @Override
    public int obtenerPuntaje(SolicitudCotizacion solicitud) {
        String nivel = servicioRiesgoLegacy.calcularNivel(
                solicitud.getVehiculo().getPlaca(),
                solicitud.getVehiculo().getAntiguedad(),
                solicitud.getVehiculo().getMarca().name());

        if ("BAJO".equalsIgnoreCase(nivel)) {
            return 20;
        }

        if ("MEDIO".equalsIgnoreCase(nivel)) {
            return 55;
        }

        if ("ALTO".equalsIgnoreCase(nivel)) {
            return 80;
        }

        return 95;
    }
}

