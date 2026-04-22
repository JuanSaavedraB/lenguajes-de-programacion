package pe.edu.pucp.inf13.aplicacion.servicios;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

public interface EvaluadorRiesgo {

    int obtenerPuntaje(SolicitudCotizacion solicitud);
}

