package pe.edu.pucp.inf13.aplicacion.aprobacion;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public class AprobadorAutomaticoHandler extends AprobadorHandler {

    @Override
    protected boolean puedeAprobar(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return monto <= 900.00 && puntajeRiesgo <= 40;
    }

    @Override
    protected ResultadoAprobacion resultadoAprobacion(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return new ResultadoAprobacion(true, "AUTOMATICO", "Aprobada automaticamente por bajo riesgo.");
    }
}

