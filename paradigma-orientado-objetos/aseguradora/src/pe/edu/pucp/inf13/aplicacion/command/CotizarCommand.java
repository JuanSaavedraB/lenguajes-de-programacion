package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.servicios.CotizadorService;

public class CotizarCommand implements Comando {

    private final CotizadorService cotizadorService;
    private final ContextoProceso contexto;

    public CotizarCommand(CotizadorService cotizadorService, ContextoProceso contexto) {
        this.cotizadorService = cotizadorService;
        this.contexto = contexto;
    }

    @Override
    public void ejecutar() {
        contexto.setCotizacion(cotizadorService.cotizar(contexto.getSolicitud()));
        System.out.println(contexto.getCotizacion());
    }

    @Override
    public String nombre() {
        return "CotizarCommand";
    }
}

