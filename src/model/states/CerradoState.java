package src.model.states;

import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;

import java.time.LocalDateTime;

public class CerradoState extends OfertaLaboralState {
    public CerradoState(OfertaLaboral ofertaLaboral) {
        super(ofertaLaboral);
        ofertaLaboral.setActiva(false);
    }

    @Override
    public Postulacion postularse(Postulante postulante, int remuneracion, String cv) {
        throw new RuntimeException("No se puede postular en ofertas cerradas");
    }

    @Override
    public void abrir(int diasDeVigencia) {
        if (this.ofertaLaboral.getFechaFin() != null && !(this.ofertaLaboral.getFechaFin().isAfter(LocalDateTime.now()) && this.ofertaLaboral.getPostulaciones().size() == 0)) {
            throw new RuntimeException("Esta oferta ya fue abierta, venció y tiene postulacines.");
        }
        this.ofertaLaboral.setFechaFin(LocalDateTime.now().plusDays(diasDeVigencia));
        this.ofertaLaboral.setEstado(new AbiertoState(ofertaLaboral));
    }

    @Override
    public void cerrar() {
        throw new RuntimeException("Esta oferta ya se encuentra cerrada");
    }
}