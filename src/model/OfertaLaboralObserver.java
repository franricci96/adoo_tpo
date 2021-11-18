package src.model;

import src.model.entities.Empresa;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;

public interface OfertaLaboralObserver {
    void nuevoPostulante(OfertaLaboral oferta, Postulante postulante);
}
