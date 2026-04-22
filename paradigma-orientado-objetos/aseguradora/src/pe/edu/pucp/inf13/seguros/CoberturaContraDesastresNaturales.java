package pe.edu.pucp.inf13.seguros;

public class CoberturaContraDesastresNaturales extends SeguroDecorador {

    public CoberturaContraDesastresNaturales(Cotizable seguro) {
        super(seguro);
    }

    @Override
    public double calcularCosto() {
        return this.seguro.calcularCosto() + 300.00;
    }

    @Override
    public String descripcion() {
        return this.seguro.descripcion() + ", cobertura contra desastres naturales";
    }
}

