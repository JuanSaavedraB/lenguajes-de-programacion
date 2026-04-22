package pe.edu.pucp.inf13.aplicacion.aprobacion;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public class AprobadorSupervisorHandler extends AprobadorHandler {

    @Override
    protected boolean puedeAprobar(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return monto <= 1400.00 && puntajeRiesgo <= 70;
    }

    @Override
    protected ResultadoAprobacion resultadoAprobacion(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return new ResultadoAprobacion(true, "SUPERVISOR", "Aprobada por supervisor por riesgo medio.");
    }
}

