package pe.edu.pucp.inf13.aplicacion.aprobacion;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public abstract class AprobadorHandler {

    protected AprobadorHandler siguiente;

    public AprobadorHandler siguiente(AprobadorHandler siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public ResultadoAprobacion aprobar(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        if (puedeAprobar(solicitud, monto, puntajeRiesgo)) {
            return resultadoAprobacion(solicitud, monto, puntajeRiesgo);
        }

        if (siguiente != null) {
            return siguiente.aprobar(solicitud, monto, puntajeRiesgo);
        }

        return new ResultadoAprobacion(false, "SIN_APROBADOR", "No existe un nivel que pueda aprobar este riesgo.");
    }

    protected abstract boolean puedeAprobar(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo);

    protected abstract ResultadoAprobacion resultadoAprobacion(SolicitudCotizacion solicitud, double monto, int puntajeRiesgo);
}

