package src.controllers;

import src.model.entities.*;

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

    public List<Habilidad> categoriasMasSeleccionadas(int cantidad) {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas();

        return ofertasLaborales.stream()
                .flatMap(i -> i.getRequisitos().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(cantidad)
                .collect(Collectors.toList());
//
    }

    public OfertaLaboral ofertaLaboralMasPostulantes(LocalDateTime fecha) {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas();

        return ofertasLaborales
                .stream()
                .filter(of -> of.getPostulaciones() != null)
                .filter(o -> o.getFechaCreacion().getMonthValue() == fecha.getMonthValue() && o.getFechaCreacion().getYear() == fecha.getYear())
                .max(Comparator.comparingInt(a -> a.getPostulaciones().size()))
                .orElseThrow(() -> new IllegalStateException("No existen ofertas laborales"));
    }

    public OfertaLaboral trabajoMasAccesible() {

        List<OfertaLaboral> trabajosMasAccesibles = new ArrayList<>();

        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas();

        for (OfertaLaboral of : ofertasLaborales) {
            if (of.getModalidadDeContrato() == ModalidadDeContrato.partTime
                    && of.getTipoDeTrabajo() == TipoDeTrabajo.remoto) {
                trabajosMasAccesibles.add(of);
            }
        }

        OfertaLaboral aux = trabajosMasAccesibles.get(0);
        for (OfertaLaboral trabajoMasAccesible : trabajosMasAccesibles) {
            if (aux.getTareas().size() <= trabajoMasAccesible.getTareas().size() && aux.getRequisitos().size() <= trabajoMasAccesible.getRequisitos().size()) {
                aux = trabajoMasAccesible;
            }
        }
        return aux;
    }

    public OfertaLaboral ofertaMasExigente() {
        List<OfertaLaboral> ofertasLaborales = this.ofertaLaboralController.obtenerOfertas();

        return ofertasLaborales
                .stream()
                .filter(of -> of.getRequisitos() != null)
                .max(Comparator.comparingInt(a -> a.getRequisitos().size()))
                .orElseThrow(() -> new IllegalStateException("No existen ofertas laborales"));
    }

}