package src.model;

import src.model.entities.OfertaLaboral;

/**
 * 
 */
public interface IObserver {


    /**
     * @param ofertaLaboral
     */
    public void notificar(OfertaLaboral ofertaLaboral);

}