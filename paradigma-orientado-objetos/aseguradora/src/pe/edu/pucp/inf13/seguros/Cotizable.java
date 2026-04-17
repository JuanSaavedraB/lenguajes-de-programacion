package pe.edu.pucp.inf13.seguros;

import pe.edu.pucp.inf13.dominio.Vehiculo;

public interface Cotizable {

    Vehiculo vehiculo();

    String descripcion();

    double calcularCosto();
}

