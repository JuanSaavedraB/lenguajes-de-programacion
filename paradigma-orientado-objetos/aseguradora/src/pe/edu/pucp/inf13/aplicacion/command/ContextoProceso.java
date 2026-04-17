package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.aprobacion.ResultadoAprobacion;
import pe.edu.pucp.inf13.aplicacion.servicios.CotizacionResultado;
import pe.edu.pucp.inf13.dominio.Poliza;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public class ContextoProceso {

    private final SolicitudCotizacion solicitud;
    private CotizacionResultado cotizacion;
    private int puntajeRiesgo;
    private ResultadoAprobacion resultadoAprobacion;
    private Poliza polizaEmitida;

    public ContextoProceso(SolicitudCotizacion solicitud) {
        this.solicitud = solicitud;
    }

    public SolicitudCotizacion getSolicitud() {
        return solicitud;
    }

    public CotizacionResultado getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionResultado cotizacion) {
        this.cotizacion = cotizacion;
    }

    public int getPuntajeRiesgo() {
        return puntajeRiesgo;
    }

    public void setPuntajeRiesgo(int puntajeRiesgo) {
        this.puntajeRiesgo = puntajeRiesgo;
    }

    public ResultadoAprobacion getResultadoAprobacion() {
        return resultadoAprobacion;
    }

    public void setResultadoAprobacion(ResultadoAprobacion resultadoAprobacion) {
        this.resultadoAprobacion = resultadoAprobacion;
    }

    public Poliza getPolizaEmitida() {
        return polizaEmitida;
    }

    public void setPolizaEmitida(Poliza polizaEmitida) {
        this.polizaEmitida = polizaEmitida;
    }
}

