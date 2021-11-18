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

    public ReporteController() {

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
        List<OfertaLaboral> trabajosMasAccesibles = new ArrayList<OfertaLaboral>();
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas(null);
        for (int i = 0; i<ofertasLaborales.size(); i++) {
            OfertaLaboral of = ofertasLaborales.get(i);
            if(of.getTipo() == "part time" && of.getModalidad() == "remoto"){
                trabajosMasAccesibles.add(of);
            }
        }

        OfertaLaboral aux = trabajosMasAccesibles.get(0);
        for (OfertaLaboral  trabajoMasAccesible : trabajosMasAccesibles){
            if(aux.getTareas().size() <= trabajoMasAccesible.getTareas().size() && aux.getRequisitos().size() <= trabajoMasAccesible.getRequisitos().size()){
                aux = trabajoMasAccesible;
            }
        }
        return aux.getTrabajo();
    }

    public OfertaLaboral ofertaMasExigente() {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas(null);

        return ofertasLaborales
                .stream()
                .filter(of -> of.getRequisitos() != null)
                .max(Comparator.comparingInt(a -> a.getRequisitos().size()))
                .orElseThrow(() -> new IllegalStateException("No existen ofertas laborales"));
    }
}

}