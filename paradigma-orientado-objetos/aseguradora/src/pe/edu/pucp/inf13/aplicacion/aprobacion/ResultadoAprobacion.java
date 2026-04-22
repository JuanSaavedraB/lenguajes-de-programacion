package pe.edu.pucp.inf13.aplicacion.aprobacion;

public class ResultadoAprobacion {

    private final boolean aprobada;
    private final String nivel;
    private final String mensaje;

    public ResultadoAprobacion(boolean aprobada, String nivel, String mensaje) {
        this.aprobada = aprobada;
        this.nivel = nivel;
        this.mensaje = mensaje;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public String getNivel() {
        return nivel;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return String.format("Aprobacion => %s | Nivel: %s | %s",
                aprobada ? "APROBADA" : "RECHAZADA", nivel, mensaje);
    }
}

