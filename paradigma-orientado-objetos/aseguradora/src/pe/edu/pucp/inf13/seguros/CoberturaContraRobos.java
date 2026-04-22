package pe.edu.pucp.inf13.seguros;

import pe.edu.pucp.inf13.dominio.Marca;

public class CoberturaContraRobos extends SeguroDecorador {

    public CoberturaContraRobos(Cotizable seguro) {
        super(seguro);
    }

    @Override
    public double calcularCosto() {
        double costo = 100.00;

        if (this.seguro.vehiculo().getMarca() == Marca.Toyota) {
            costo += 100.00;
        }

        return this.seguro.calcularCosto() + costo;
    }

    @Override
    public String descripcion() {
        return this.seguro.descripcion() + ", cobertura contra robos";
    }
}

