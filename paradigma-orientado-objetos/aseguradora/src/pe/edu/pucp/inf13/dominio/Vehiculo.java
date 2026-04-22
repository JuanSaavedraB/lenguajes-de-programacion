package pe.edu.pucp.inf13.dominio;

public class Vehiculo {

    private final String placa;
    private Marca marca;
    private int antiguedad;

    public Vehiculo(String placa, Marca marca, int antiguedad) {
        this.placa = placa;
        this.marca = marca;
        this.antiguedad = antiguedad;
    }

    public String getPlaca() {
        return placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}

