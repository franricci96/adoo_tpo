package src.model.states;

import src.model.OfertaLaboralObserver;
import src.model.entities.Habilidad;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;

import java.time.LocalDateTime;
import java.util.List;

public class AbiertoState extends OfertaLaboralState {

    LocalDateTime fechaLimite;

    AbiertoState(OfertaLaboral ofertaLaboral) {
        super(ofertaLaboral);
        ofertaLaboral.setActiva(true);
    }

    @Override
    public Postulacion postularse(Postulante postulante, int remuneracion, String cv) {
        if (this.ofertaLaboral.getFechaFin().isBefore(LocalDateTime.now())) {
            System.out.println("La oferta caduco su periodo de vigencia, se procedera a cerrar");
            this.cerrar();
            return null;
        }
        if (this.verificarRequisitos(postulante)) {
            Postulacion postulacion = Postulacion
                    .builder()
                    .fechaPostulacion(LocalDateTime.now())
                    .postulante(postulante)
                    .remuneracion(remuneracion)
                    .cv(cv)
                    .build();
            this.ofertaLaboral.getPostulaciones().add(postulacion);
            postulante.getPostulaciones().add(postulacion);

            for (OfertaLaboralObserver olb : this.ofertaLaboral.observers) {
                olb.nuevoPostulante(this.ofertaLaboral, postulante);
            }

            return postulacion;
        } else {
            System.out.println("Usted no cumple con los requisitos solicitados");
            return null;
        }
    }

    @Override
    public void abrir(int diasDeVigencia) {
        throw new RuntimeException("Ya oferta ya se encuentra abierta");
    }

    @Override
    public void cerrar() {
        this.ofertaLaboral.setEstado(new CerradoState(ofertaLaboral));
    }

    private boolean verificarRequisitos(Postulante postulante) {
        List<Habilidad> requisitos = this.ofertaLaboral.getRequisitos();
        List<Habilidad> habilidades = postulante.getHabilidades();
        return habilidades.containsAll(requisitos);
    }
}