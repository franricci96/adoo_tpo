package src.model.states;

import src.model.entities.OfertaLaboral;

public class CerradoState extends OfertaLaboralState {
    CerradoState(OfertaLaboral ofertaLaboral) {
        super(ofertaLaboral);
        ofertaLaboral.setEstado(this);
    }

    @Override
    public void postularse() {

    }

    @Override
    public void abrir() {
        ofertaLaboral.setEstado(new AbiertoState(ofertaLaboral));
    }

    @Override
    public void cerrar() {

    }
}