package pe.edu.pucp.inf13.aplicacion.factory;

import pe.edu.pucp.inf13.aplicacion.servicios.CotizadorService;
import pe.edu.pucp.inf13.aplicacion.servicios.EvaluadorRiesgo;
import pe.edu.pucp.inf13.aplicacion.servicios.NotificadorService;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioPolizas;
import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioSolicitudes;
import pe.edu.pucp.inf13.infraestructura.cotizacion.CotizadorVehicular;
import pe.edu.pucp.inf13.infraestructura.csv.RepositorioPolizasCsv;
import pe.edu.pucp.inf13.infraestructura.csv.RepositorioSolicitudesCsv;
import pe.edu.pucp.inf13.infraestructura.notificacion.NotificadorConsola;
import pe.edu.pucp.inf13.infraestructura.riesgo.EvaluadorRiesgoAdapter;
import pe.edu.pucp.inf13.infraestructura.riesgo.ServicioRiesgoLegacy;

public class ServicioFactoryImpl implements ServicioFactory {

    private final String rutaSolicitudes;
    private final String rutaPolizas;

    public ServicioFactoryImpl(String rutaSolicitudes, String rutaPolizas) {
        this.rutaSolicitudes = rutaSolicitudes;
        this.rutaPolizas = rutaPolizas;
    }

    @Override
    public CotizadorService crearCotizador() {
        return new CotizadorVehicular();
    }

    @Override
    public RepositorioSolicitudes crearRepositorioSolicitudes() {
        return new RepositorioSolicitudesCsv(rutaSolicitudes);
    }

    @Override
    public RepositorioPolizas crearRepositorioPolizas() {
        return new RepositorioPolizasCsv(rutaPolizas);
    }

    @Override
    public NotificadorService crearNotificador() {
        return new NotificadorConsola();
    }

    @Override
    public EvaluadorRiesgo crearEvaluadorRiesgo() {
        return new EvaluadorRiesgoAdapter(new ServicioRiesgoLegacy());
    }
}

