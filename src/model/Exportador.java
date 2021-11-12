package src.model;

import src.model.entities.OfertaLaboral;

/**
 * 
 */
public interface Exportador {

    /**
     * @param oferta 
     * @return
     */
    public String exportar(OfertaLaboral oferta);

}