package pe.edu.pucp.inf13.seguros;

public class CoberturaAsistenciaVial extends SeguroDecorador {

    public CoberturaAsistenciaVial(Cotizable seguro) {
        super(seguro);
    }

    @Override
    public double calcularCosto() {
        return this.seguro.calcularCosto() + 100.00;
    }

    @Override
    public String descripcion() {
        return this.seguro.descripcion() + ", asistencia vial";
    }
}

