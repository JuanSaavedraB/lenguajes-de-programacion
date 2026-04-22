package pe.edu.pucp.inf13.aplicacion.servicios;

public class CotizacionResultado {

    private final double monto;
    private final String descripcion;

    public CotizacionResultado(double monto, String descripcion) {
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return String.format("Cotizacion => Monto: %.2f, Descripcion: %s", monto, descripcion);
    }
}

