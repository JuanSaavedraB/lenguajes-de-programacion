package pe.edu.pucp.inf13.aplicacion.command;

import java.util.ArrayList;
import java.util.List;

public class InvocadorComandos {

    private final List<String> historial = new ArrayList<>();

    public void ejecutar(Comando comando) {
        comando.ejecutar();
        historial.add(comando.nombre());
    }

    public List<String> historial() {
        return new ArrayList<>(historial);
    }
}

