package src.model;

import src.model.entities.OfertaLaboral;

/**
 *
 */
public class AdapterImagen {

    public AdapterImagen() {
    }

    public String exportar(OfertaLaboral oferta) {
        return String.format("EXPORTANDO: Imagen de %s", oferta.getTitulo());
    }

}