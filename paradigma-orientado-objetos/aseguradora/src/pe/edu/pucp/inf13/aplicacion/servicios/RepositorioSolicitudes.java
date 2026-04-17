package pe.edu.pucp.inf13.aplicacion.servicios;

import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;

import java.util.List;

public interface RepositorioSolicitudes {

    List<SolicitudCotizacion> leerTodo();
}

