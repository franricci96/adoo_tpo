package src.model;

import src.model.entities.OfertaLaboral;

public class ExportarImagenEnJpgEstrategia implements Exportador {
    @Override
    public String exportar(OfertaLaboral oferta) {
        return "IMAGEN EN JPG";
    }
}
