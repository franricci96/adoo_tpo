package src.controllers;

import src.model.Exportador;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;
import src.strategies.EstrategiaDeGeneracion;

import java.lang.reflect.Array;
import java.util.*;

public class OfertaLaboralController {

    private EstrategiaDeGeneracion estrategiaDeGeneraciondeImagen;
    private Exportador exportador;
    private List<OfertaLaboral> ofertas = new ArrayList();

    public OfertaLaboralController() {
    }

    public Postulacion postularse(Postulante postulante, OfertaLaboral ofertaLaboral, Double remuneracion) {
        return ofertaLaboral.postularse(postulante, remuneracion);
    }

    public void agregarOfertaLaboral(OfertaLaboral ofertaLaboral) {
        this.ofertas.add(ofertaLaboral);
    }

    public List<Postulacion> verPostulaciones(OfertaLaboral ofertaLaboral) {
        return ofertaLaboral.getPostulaciones();
    }

    public byte[] generarImagenOfertaLaboral(OfertaLaboral ofertaLaboral) {
        // Logica para generar imagen encodeada en base64;
        return Base64
                .getDecoder()
                .decode("asda");
    }

    //TODO: filtros?
    public List<OfertaLaboral> obtenerOfertas(OfertaLaboral filtros) {
        return this.ofertas;
    }

    public boolean eliminarPublicacion(OfertaLaboral oferta) {
        return this.ofertas.remove(oferta);
    }

    //TODO: Implementar state
    public void abrirPublicacion(OfertaLaboral oferta) {
        oferta.abrir();
    }

    public void cambiarEstrategiaGeneracionImagen(EstrategiaDeGeneracion nuevaEstrategia) {
        this.estrategiaDeGeneraciondeImagen = nuevaEstrategia;
    }

    public String exportar(OfertaLaboral oferta) {
        return this.exportador.exportar(oferta);
    }
}