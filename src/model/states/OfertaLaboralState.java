package src.model.states;

import src.model.entities.OfertaLaboral;

public abstract class OfertaLaboralState {
    public abstract void postularse(OfertaLaboral ofertaLaboral);
    public abstract void abrir(OfertaLaboral ofertaLaboral);
    public abstract void cerrar(OfertaLaboral ofertaLaboral);
}
