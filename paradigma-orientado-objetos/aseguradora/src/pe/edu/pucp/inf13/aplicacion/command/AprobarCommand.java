package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.aprobacion.CadenaAprobacionSingleton;
import pe.edu.pucp.inf13.aplicacion.aprobacion.ResultadoAprobacion;
import pe.edu.pucp.inf13.aplicacion.servicios.EvaluadorRiesgo;

public class AprobarCommand implements Comando {

    private final EvaluadorRiesgo evaluadorRiesgo;
    private final ContextoProceso contexto;

    public AprobarCommand(EvaluadorRiesgo evaluadorRiesgo, ContextoProceso contexto) {
        this.evaluadorRiesgo = evaluadorRiesgo;
        this.contexto = contexto;
    }

    @Override
    public void ejecutar() {
        int puntaje = evaluadorRiesgo.obtenerPuntaje(contexto.getSolicitud());
        contexto.setPuntajeRiesgo(puntaje);

        ResultadoAprobacion resultado = CadenaAprobacionSingleton.instancia().aprobar(
                contexto.getSolicitud(),
                contexto.getCotizacion().getMonto(),
                puntaje);

        contexto.setResultadoAprobacion(resultado);
        System.out.println(resultado);
    }

    @Override
    public String nombre() {
        return "AprobarCommand";
    }
}

