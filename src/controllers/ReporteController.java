package src.controllers;

import src.model.entities.Categoria;
import src.model.entities.OfertaLaboral;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class ReporteController {

    private OfertaLaboralController ofertaLaboralController;

    public ReporteController(OfertaLaboralController ofertaLaboralController) {
        this.ofertaLaboralController = ofertaLaboralController;
    }

    public List<Categoria> categoriasMasSeleccionadas(int cantidad) {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas(null);
        Map<String, List<Categoria>> categoriasMap = ofertasLaborales.stream()
                .map(OfertaLaboral::getCategorias)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Categoria::getNombre));

//        return
//                categoriasMap.values().stream().sorted(Comparator.comparingInt(List::size)).collect(Collectors.toList()).get(   0);
        return Arrays.asList(
                new Categoria("it"),
                new Categoria("rrhh"),
                new Categoria("marketing"));
    }

    public OfertaLaboral ofertaLaboralMasPostulantes(int fecha) {
        // TODO implement here
        return null;
    }

    public String trabajoMasAccesible() {
        // TODO implement here
        return "";
    }

    public OfertaLaboral ofertaMasExigente() {
        // TODO implement here
        return null;
    }

}