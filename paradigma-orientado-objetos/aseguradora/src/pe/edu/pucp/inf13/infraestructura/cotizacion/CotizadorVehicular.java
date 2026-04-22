package pe.edu.pucp.inf13.infraestructura.cotizacion;

import pe.edu.pucp.inf13.aplicacion.servicios.CotizacionResultado;
import pe.edu.pucp.inf13.aplicacion.servicios.CotizadorService;
import pe.edu.pucp.inf13.dominio.SolicitudCotizacion;
import pe.edu.pucp.inf13.seguros.CoberturaAsistenciaVial;
import pe.edu.pucp.inf13.seguros.CoberturaContraDesastresNaturales;
import pe.edu.pucp.inf13.seguros.CoberturaContraRobos;
import pe.edu.pucp.inf13.seguros.Cotizable;
import pe.edu.pucp.inf13.seguros.SeguroBasico;

public class CotizadorVehicular implements CotizadorService {

    @Override
    public CotizacionResultado cotizar(SolicitudCotizacion solicitud) {
        Cotizable seguro = new SeguroBasico(solicitud.getVehiculo());

        if (solicitud.isCoberturaRobos()) {
            seguro = new CoberturaContraRobos(seguro);
        }

        if (solicitud.isCoberturaAsistenciaVial()) {
            seguro = new CoberturaAsistenciaVial(seguro);
        }

        if (solicitud.isCoberturaDesastresNaturales()) {
            seguro = new CoberturaContraDesastresNaturales(seguro);
        }

        return new CotizacionResultado(seguro.calcularCosto(), seguro.descripcion());
    }
}

