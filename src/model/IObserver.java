package src.model;

import src.model.entities.OfertaLaboral;

public interface IObserver {
    public void notificar(OfertaLaboral ofertaLaboral);
}