package src.model;

import src.model.entities.OfertaLaboral;

/**
 * 
 */
public abstract class OfertaLaboralState {

    /**
     * Default constructor
     */
    public OfertaLaboralState() {
    }

    /**
     * @param ofertaLaboral 
     * @return
     */
    public void postularse(OfertaLaboral ofertaLaboral) {
        // TODO implement here
        return null;
    }

    /**
     * @param estado
     */
    private void cambiarEstado(void estado) {
        // TODO implement here
    }

    /**
     * @param ofertaLaboral 
     * @return
     */
    public void reabrir(OfertaLaboral ofertaLaboral) {
        // TODO implement here
        return null;
    }

    /**
     * @param ofertaLaboral 
     * @return
     */
    public void cerrar(OfertaLaboral ofertaLaboral) {
        // TODO implement here
        return null;
    }

}