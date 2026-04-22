package pe.edu.pucp.inf13.infraestructura.riesgo;

public class ServicioRiesgoLegacy {

    public String calcularNivel(String placa, int antiguedad, String marca) {
        if (antiguedad > 12) {
            return "CRITICO";
        }

        if ("BMW".equalsIgnoreCase(marca) || "AUDI".equalsIgnoreCase(marca)) {
            return "ALTO";
        }

        if (placa != null && placa.startsWith("X")) {
            return "ALTO";
        }

        if (antiguedad > 6) {
            return "MEDIO";
        }

        return "BAJO";
    }
}

