package pe.edu.pucp.inf13.infraestructura.csv;

import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioPolizas;
import pe.edu.pucp.inf13.dominio.Poliza;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPolizasCsv implements RepositorioPolizas {

    private final String rutaArchivo;

    public RepositorioPolizasCsv(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardar(Poliza poliza) {
        File archivo = new File(rutaArchivo);
        boolean escribirCabecera = !archivo.exists() || archivo.length() == 0;

        try {
            File carpeta = archivo.getParentFile();
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                if (escribirCabecera) {
                    writer.write("numeroPoliza,idSolicitud,cliente,monto,descripcion,estadoAprobacion,puntajeRiesgo,fechaEmision");
                    writer.newLine();
                }

                writer.write(String.format("%s,%d,%s,%.2f,%s,%s,%d,%s",
                        poliza.getNumeroPoliza(),
                        poliza.getIdSolicitud(),
                        limpiar(poliza.getCliente()),
                        poliza.getMonto(),
                        limpiar(poliza.getDescripcion()),
                        poliza.getEstadoAprobacion(),
                        poliza.getPuntajeRiesgo(),
                        poliza.getFechaEmision()));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error guardando poliza CSV: " + rutaArchivo, e);
        }
    }

    @Override
    public List<Poliza> leerTodo() {
        List<Poliza> polizas = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return polizas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primera = true;

            while ((linea = reader.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }

                if (primera) {
                    primera = false;
                    if (linea.toLowerCase().contains("numeropoliza,")) {
                        continue;
                    }
                }

                String[] partes = linea.split(",");
                if (partes.length < 8) {
                    continue;
                }

                Poliza poliza = new Poliza(
                        partes[0].trim(),
                        Integer.parseInt(partes[1].trim()),
                        partes[2].trim(),
                        Double.parseDouble(partes[3].trim()),
                        partes[4].trim(),
                        Integer.parseInt(partes[6].trim()),
                        partes[5].trim(),
                        LocalDate.parse(partes[7].trim()));
                polizas.add(poliza);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo polizas CSV: " + rutaArchivo, e);
        }

        return polizas;
    }

    private String limpiar(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replace(',', ';');
    }
}

