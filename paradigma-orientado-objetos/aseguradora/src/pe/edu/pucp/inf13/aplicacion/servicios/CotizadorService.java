package pe.edu.pucp.inf13.aplicacion.servicios;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public interface CotizadorService {

    CotizacionResultado cotizar(SolicitudCotizacion solicitud);
}

