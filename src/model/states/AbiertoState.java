package src.model.states;

import src.model.entities.OfertaLaboral;

import java.time.LocalDateTime;

public class AbiertoState extends OfertaLaboralState {

    LocalDateTime fechaLimite;

    AbiertoState(OfertaLaboral ofertaLaboral) {
        super(ofertaLaboral);
        ofertaLaboral.setEstado(this);
    }

    @Override
    public void postularse() {

    }

    @Override
    public void abrir() {

    }

    @Override
    public void cerrar() {
        ofertaLaboral.setEstado(new CerradoState(ofertaLaboral));
    }
}