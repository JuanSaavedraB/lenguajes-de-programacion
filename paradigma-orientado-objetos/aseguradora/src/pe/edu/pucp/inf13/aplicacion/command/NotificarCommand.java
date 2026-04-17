package pe.edu.pucp.inf13.aplicacion.command;

import pe.edu.pucp.inf13.aplicacion.servicios.NotificadorService;

public class NotificarCommand implements Comando {

    private final NotificadorService notificadorService;
    private final ContextoProceso contexto;

    public NotificarCommand(NotificadorService notificadorService, ContextoProceso contexto) {
        this.notificadorService = notificadorService;
        this.contexto = contexto;
    }

    @Override
    public void ejecutar() {
        String correo = contexto.getSolicitud().getCorreo();

        if (contexto.getPolizaEmitida() != null) {
            String mensaje = String.format(
                    "Su poliza %s fue emitida por %.2f.",
                    contexto.getPolizaEmitida().getNumeroPoliza(),
                    contexto.getPolizaEmitida().getMonto());
            notificadorService.notificar(correo, mensaje);
            return;
        }

        String mensaje = "Su solicitud no pudo ser aprobada en este momento.";
        notificadorService.notificar(correo, mensaje);
    }

    @Override
    public String nombre() {
        return "NotificarCommand";
    }
}

