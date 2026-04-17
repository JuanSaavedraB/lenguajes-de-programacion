package pe.edu.pucp.inf13.seguros;

import pe.edu.pucp.inf13.dominio.Vehiculo;

public class SeguroDecorador implements Cotizable {

    protected Cotizable seguro;

    public SeguroDecorador(Cotizable seguro) {
        this.seguro = seguro;
    }

    @Override
    public double calcularCosto() {
        return this.seguro.calcularCosto();
    }

    @Override
    public String descripcion() {
        return this.seguro.descripcion();
    }

    @Override
    public Vehiculo vehiculo() {
        return this.seguro.vehiculo();
    }

    @Override
    public String toString() {
        return String.format("Precio: %.2f, Descripcion: %s", this.calcularCosto(), this.descripcion());
    }
}

