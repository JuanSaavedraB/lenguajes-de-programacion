package pe.edu.pucp.inf13.dominio;

import java.time.LocalDate;

public class Poliza {

    private final String numeroPoliza;
    private final int idSolicitud;
    private final String cliente;
    private final double monto;
    private final String descripcion;
    private final int puntajeRiesgo;
    private final String estadoAprobacion;
    private final LocalDate fechaEmision;

    public Poliza(String numeroPoliza,
                  int idSolicitud,
                  String cliente,
                  double monto,
                  String descripcion,
                  int puntajeRiesgo,
                  String estadoAprobacion,
                  LocalDate fechaEmision) {
        this.numeroPoliza = numeroPoliza;
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.monto = monto;
        this.descripcion = descripcion;
        this.puntajeRiesgo = puntajeRiesgo;
        this.estadoAprobacion = estadoAprobacion;
        this.fechaEmision = fechaEmision;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntajeRiesgo() {
        return puntajeRiesgo;
    }

    public String getEstadoAprobacion() {
        return estadoAprobacion;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    @Override
    public String toString() {
        return String.format("Poliza %s | Solicitud %d | Cliente: %s | Monto: %.2f | Riesgo: %d | Estado: %s | Fecha: %s",
                numeroPoliza, idSolicitud, cliente, monto, puntajeRiesgo, estadoAprobacion, fechaEmision);
    }
}

