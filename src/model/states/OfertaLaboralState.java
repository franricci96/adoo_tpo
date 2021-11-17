package src.model.states;

import src.model.entities.OfertaLaboral;

public abstract class OfertaLaboralState {

    OfertaLaboral ofertaLaboral;
    OfertaLaboralState(OfertaLaboral ofertaLaboral){
        this.ofertaLaboral = ofertaLaboral;
    }

    public abstract void postularse();
    public abstract void abrir();
    public abstract void cerrar();
}
