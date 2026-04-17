package pe.edu.pucp.inf13.aplicacion.aprobacion;

public class CadenaAprobacionSingleton {

    private static CadenaAprobacionSingleton instancia;

    private final AprobadorHandler primerHandler;

    private CadenaAprobacionSingleton() {
        AprobadorAutomaticoHandler automatico = new AprobadorAutomaticoHandler();
        AprobadorSupervisorHandler supervisor = new AprobadorSupervisorHandler();
        AprobadorGerenteHandler gerente = new AprobadorGerenteHandler();

        automatico.siguiente(supervisor).siguiente(gerente);
        this.primerHandler = automatico;
    }

    public synchronized static CadenaAprobacionSingleton instancia() {
        if (instancia == null) {
            instancia = new CadenaAprobacionSingleton();
        }
        return instancia;
    }

    public ResultadoAprobacion aprobar(pe.edu.pucp.inf13.dominio.SolicitudCotizacion solicitud, double monto, int puntajeRiesgo) {
        return primerHandler.aprobar(solicitud, monto, puntajeRiesgo);
    }
}
