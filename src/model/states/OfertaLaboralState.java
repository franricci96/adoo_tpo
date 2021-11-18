package src.model.states;

import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;

public abstract class OfertaLaboralState {

    OfertaLaboral ofertaLaboral;
    OfertaLaboralState(OfertaLaboral ofertaLaboral){
        this.ofertaLaboral = ofertaLaboral;
    }

    public abstract Postulacion postularse(Postulante postulante, int remuneracion, String cv);
    public abstract void abrir(int diasDeVigencia);
    public abstract void cerrar();
}
