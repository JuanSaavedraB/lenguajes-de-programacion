package pe.edu.pucp.inf13.aplicacion.servicios;

import pe.edu.pucp.inf13.dominio.Poliza;

import java.util.List;

public interface RepositorioPolizas {

    void guardar(Poliza poliza);

    List<Poliza> leerTodo();
}

