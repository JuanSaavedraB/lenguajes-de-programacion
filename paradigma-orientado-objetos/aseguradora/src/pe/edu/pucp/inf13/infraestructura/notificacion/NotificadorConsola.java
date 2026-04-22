package pe.edu.pucp.inf13.infraestructura.notificacion;

import pe.edu.pucp.inf13.aplicacion.servicios.NotificadorService;

public class NotificadorConsola implements NotificadorService {

    @Override
    public void notificar(String destino, String mensaje) {
        String canal = destino == null || destino.isBlank() ? "consola" : destino;
        System.out.printf("[Notificacion a %s] %s%n", canal, mensaje);
    }
}

