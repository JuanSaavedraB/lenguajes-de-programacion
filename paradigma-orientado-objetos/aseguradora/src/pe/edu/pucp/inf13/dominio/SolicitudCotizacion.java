package pe.edu.pucp.inf13.dominio;

public class SolicitudCotizacion {

    private final int id;
    private final String cliente;
    private final String correo;
    private final Vehiculo vehiculo;
    private final boolean coberturaRobos;
    private final boolean coberturaAsistenciaVial;
    private final boolean coberturaDesastresNaturales;

    private SolicitudCotizacion(Builder builder) {
        this.id = builder.id;
        this.cliente = builder.cliente;
        this.correo = builder.correo;
        this.vehiculo = builder.vehiculo;
        this.coberturaRobos = builder.coberturaRobos;
        this.coberturaAsistenciaVial = builder.coberturaAsistenciaVial;
        this.coberturaDesastresNaturales = builder.coberturaDesastresNaturales;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public boolean isCoberturaRobos() {
        return coberturaRobos;
    }

    public boolean isCoberturaAsistenciaVial() {
        return coberturaAsistenciaVial;
    }

    public boolean isCoberturaDesastresNaturales() {
        return coberturaDesastresNaturales;
    }

    public static class Builder {
        private final int id;
        private final String cliente;
        private final Vehiculo vehiculo;
        private String correo = "";
        private boolean coberturaRobos;
        private boolean coberturaAsistenciaVial;
        private boolean coberturaDesastresNaturales;

        public Builder(int id, String cliente, Vehiculo vehiculo) {
            this.id = id;
            this.cliente = cliente;
            this.vehiculo = vehiculo;
        }

        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder coberturaRobos(boolean coberturaRobos) {
            this.coberturaRobos = coberturaRobos;
            return this;
        }

        public Builder coberturaAsistenciaVial(boolean coberturaAsistenciaVial) {
            this.coberturaAsistenciaVial = coberturaAsistenciaVial;
            return this;
        }

        public Builder coberturaDesastresNaturales(boolean coberturaDesastresNaturales) {
            this.coberturaDesastresNaturales = coberturaDesastresNaturales;
            return this;
        }

        public SolicitudCotizacion build() {
            return new SolicitudCotizacion(this);
        }
    }
}

