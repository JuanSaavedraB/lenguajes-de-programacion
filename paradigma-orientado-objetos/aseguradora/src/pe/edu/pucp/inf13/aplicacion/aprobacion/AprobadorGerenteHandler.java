package pe.edu.pucp.inf13.aplicacion.aprobacion;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public class AprobadorGerenteHandler extends AprobadorHandler {

    @Override
    protected boolean puedeAprobar(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return monto <= 2200.00 && puntajeRiesgo <= 90;
    }

    @Override
    protected ResultadoAprobacion resultadoAprobacion(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return new ResultadoAprobacion(true, "GERENTE", "Aprobada por gerente por monto alto o riesgo elevado.");
    }
}

