package src.model.entities;

import lombok.Data;
import lombok.Builder;
import src.model.states.AbiertoState;
import src.model.states.CerradoState;
import src.model.states.OfertaLaboralState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Builder
@Data
public class OfertaLaboral {

    private OfertaLaboralState estado;
    private Empresa creador;
    private String titulo;
    private LocalDateTime fechaFin;
    private String descripcion;
    private String modalidad;
    private String tipo;
    private Double sueldo;
    private String lugar;
    private List<String> requisitos;
    private LocalDateTime fechaCreacion;
    private String trabajo;
    private List<String> tareas;
    private List<Categoria> categorias;
    private List<Postulacion> postulaciones;

    public Postulacion postularse(Postulante postulante, int remuneracion) {
        Postulacion postulacion = Postulacion
                .builder()
                .fechaPostulacion(LocalDateTime.now())
                .postulante(postulante)
                .remuneracion(remuneracion)
                .build();
        this.postulaciones.add(postulacion);
        postulante.getPostulaciones().add(postulacion);

        return postulacion;
    }

    public void abrir() {
        this.estado.abrir();
    }

    public void cerrar() {
        this.estado.cerrar();
    }
}