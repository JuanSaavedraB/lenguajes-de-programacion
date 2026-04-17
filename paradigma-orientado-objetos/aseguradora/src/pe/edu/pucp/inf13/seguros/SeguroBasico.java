package pe.edu.pucp.inf13.seguros;

import pe.edu.pucp.inf13.dominio.Marca;
import pe.edu.pucp.inf13.dominio.Vehiculo;

public class SeguroBasico implements Cotizable {

    protected Vehiculo vehiculo;

    public SeguroBasico(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public double calcularCosto() {
        double costo = 500.00;

        if (this.vehiculo.getAntiguedad() > 10) {
            costo += 200.00;
        } else if (this.vehiculo.getAntiguedad() > 5) {
            costo += 100.00;
        }

        if (this.vehiculo.getMarca() == Marca.BMW
                || this.vehiculo.getMarca() == Marca.Audi
                || this.vehiculo.getMarca() == Marca.Mercedez) {
            costo += 120.00;
        }

        return costo;
    }

    @Override
    public Vehiculo vehiculo() {
        return this.vehiculo;
    }

    @Override
    public String descripcion() {
        return "Seguro basico vehicular";
    }

    @Override
    public String toString() {
        return String.format("Precio: %.2f, Descripcion: %s", this.calcularCosto(), this.descripcion());
    }
}

