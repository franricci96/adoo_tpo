package src.model.entities;

import lombok.Builder;
import lombok.Data;
import src.model.NotificacionListener;
import src.model.OfertaLaboralObserver;
import src.model.states.OfertaLaboralState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@Data
public class OfertaLaboral {

    @Builder.Default
    public List<OfertaLaboralObserver> observers = List.of(new NotificacionListener());
    private OfertaLaboralState estado;
    private Empresa creador;
    private String titulo;
    private LocalDateTime fechaFin;
    private String descripcion;
    private ModalidadDeContrato modalidadDeContrato;
    private int sueldo;
    private String lugar;
    private List<Habilidad> requisitos;
    private List<String> tareas;
    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private TipoDeTrabajo tipoDeTrabajo;
    private Categoria categoria;
    @Builder.Default
    private List<Postulacion> postulaciones = new ArrayList<>();
    private Boolean activa;

    public Postulacion postularse(Postulante postulante, int remuneracion, String cv) {
        return this.getEstado().postularse(postulante, remuneracion, cv);
    }

    public void validarDatos() {
        if (this.getTipoDeTrabajo() == TipoDeTrabajo.presencial && this.getLugar().isEmpty()) {
            throw new RuntimeException("Si la oferta es presencial, indicar el lugar es requerido");
        }
    }

}