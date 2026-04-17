package pe.edu.pucp.inf13.aplicacion.factory;

import pe.edu.pucp.inf13.aplicacion.servicios.CotizadorService;
import pe.edu.pucp.inf13.aplicacion.servicios.EvaluadorRiesgo;
import pe.edu.pucp.inf13.aplicacion.servicios.NotificadorService;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioPolizas;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioSolicitudes;

public interface ServicioFactory {

    CotizadorService crearCotizador();

    RepositorioSolicitudes crearRepositorioSolicitudes();

    RepositorioPolizas crearRepositorioPolizas();

    NotificadorService crearNotificador();

    EvaluadorRiesgo crearEvaluadorRiesgo();
}

