package pe.edu.pucp.inf13.infraestructura.csv;

import pe.edu.pucp.inf13.aplicacion.servicios.RepositorioSolicitudes;
import pe.edu.pucp.inf13.dominio.Marca;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;
import pe.edu.pucp.inf13.dominio.Vehiculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSolicitudesCsv implements RepositorioSolicitudes {

    private final String rutaArchivo;

    public RepositorioSolicitudesCsv(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<SolicitudCotizacion> leerTodo() {
        List<SolicitudCotizacion> solicitudes = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            return solicitudes;
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
                    if (linea.toLowerCase().contains("id,")) {
                        continue;
                    }
                }

                String[] partes = linea.split(",");
                if (partes.length < 9) {
                    continue;
                }

                int id = Integer.parseInt(partes[0].trim());
                String cliente = partes[1].trim();
                String correo = partes[2].trim();
                String placa = partes[3].trim();
                Marca marca = Marca.valueOf(partes[4].trim());
                int antiguedad = Integer.parseInt(partes[5].trim());
                boolean robos = Boolean.parseBoolean(partes[6].trim());
                boolean asistencia = Boolean.parseBoolean(partes[7].trim());
                boolean desastres = Boolean.parseBoolean(partes[8].trim());

                Vehiculo vehiculo = new Vehiculo(placa, marca, antiguedad);
                SolicitudCotizacion solicitud = new SolicitudCotizacion.Builder(id, cliente, vehiculo)
                        .correo(correo)
                        .coberturaRobos(robos)
                        .coberturaAsistenciaVial(asistencia)
                        .coberturaDesastresNaturales(desastres)
                        .build();

                solicitudes.add(solicitud);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo solicitudes CSV: " + rutaArchivo, e);
        }

        return solicitudes;
    }
}

