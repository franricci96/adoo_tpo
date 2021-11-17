package src.controllers;

import src.model.entities.Categoria;
import src.model.entities.OfertaLaboral;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
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

        return ofertasLaborales.stream()
                .flatMap(i -> i.getCategorias().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(cantidad)
                .collect(Collectors.toList());
//
    }

    public OfertaLaboral ofertaLaboralMasPostulantes(LocalDateTime fecha) {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas(null);

        return ofertasLaborales
                .stream()
                .filter(of -> of.getPostulaciones() != null)
                .max(Comparator.comparingInt(a -> a.getPostulaciones().size()))
                .orElseThrow(() -> new IllegalStateException("No existen ofertas laborales"));
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