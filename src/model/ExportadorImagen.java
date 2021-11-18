package src.model;

import src.model.entities.OfertaLaboral;

import java.util.Base64;

/**
 *
 */
public class ExportadorImagen implements Exportador {
    @Override
    public String exportar(OfertaLaboral oferta) {
        return String.format("EXPORTANDO: Imagen de %s", oferta.getTitulo());
    }
}