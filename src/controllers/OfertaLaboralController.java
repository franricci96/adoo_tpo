package src.controllers;

import src.model.Exportador;
import src.model.ExportadorImagen;
import src.model.entities.Empresa;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;
import src.model.states.CerradoState;
import src.strategies.EstrategiaDeGeneracion;

import java.util.*;
import java.util.stream.Collectors;

public class OfertaLaboralController {

    private EstrategiaDeGeneracion estrategiaDeGeneraciondeImagen;
    private Exportador exportador = new ExportadorImagen();
    private List<OfertaLaboral> ofertas = new ArrayList();
    private UserController uc;

    public OfertaLaboralController(UserController uc) {
        this.uc = uc;
    }

    public Postulacion postularse(Postulante postulante, OfertaLaboral ofertaLaboral, int remuneracion, String cv) {
        return ofertaLaboral.postularse(postulante, remuneracion, cv);
    }

    public void agregarOfertaLaboral(OfertaLaboral ofertaLaboral) {
        ofertaLaboral.validarDatos();
        if (ofertaLaboral.getTitulo().isEmpty()) {
            this.generarTituloParaOferta(ofertaLaboral);
        }
        ofertaLaboral.setEstado(new CerradoState(ofertaLaboral));
        this.ofertas.add(ofertaLaboral);
        this.notificarNuevaOferta(ofertaLaboral);
    }

    public List<Postulacion> verPostulaciones(OfertaLaboral ofertaLaboral) {
        return ofertaLaboral.getPostulaciones();
    }

    public String generarImagenOfertaLaboral(OfertaLaboral ofertaLaboral) {
        return this.exportador.exportar(ofertaLaboral);
    }

    public List<OfertaLaboral> obtenerOfertas() {
        return this.ofertas;
    }

    public boolean eliminarPublicacion(OfertaLaboral oferta) {
        return this.ofertas.remove(oferta);
    }

    public void abrirPublicacion(OfertaLaboral oferta, int diasDeVigencia) {
        oferta.getEstado().abrir(diasDeVigencia);
    }

    public void cambiarEstrategiaGeneracionImagen(EstrategiaDeGeneracion nuevaEstrategia) {
        this.estrategiaDeGeneraciondeImagen = nuevaEstrategia;
    }

    public String exportar(Exportador estrategiaParaExportar, OfertaLaboral oferta) {
        return estrategiaParaExportar.exportar(oferta);
    }

    public void agregarFavoritos(OfertaLaboral ofertaLaboral, Postulante postulante) {
        postulante.getFavoritos().add(ofertaLaboral);
    }

    public List<OfertaLaboral> obtenerOfertasCerradas() {
        return this.ofertas
                .stream()
                .filter(of -> !of.getActiva()).
                collect(Collectors.toList());
    }

    private void generarTituloParaOferta(OfertaLaboral oferta) {
        String titulo = String.format("AutoGenTitulo: %s - %s ", oferta.getCategoria().toString(), oferta.getTipoDeTrabajo());
        titulo += oferta.getLugar();
        oferta.setTitulo(titulo);
    }

    private void notificarNuevaOferta(OfertaLaboral oferta) {
        List<Postulante> postulantes = this.uc.obtenerPostulantes();
        //TODO no llegamos.
    }


}