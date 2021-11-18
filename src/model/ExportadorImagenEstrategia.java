package src.model;

import src.model.entities.OfertaLaboral;

public class ExportadorImagenEstrategia implements Exportador {
    private AdapterImagen adapterImagen = new AdapterImagen();

    @Override
    public String exportar(OfertaLaboral oferta) {
        return this.adapterImagen.exportar(oferta);
    }
}