package src.model.entities;

import lombok.Builder;
import lombok.Data;
import src.model.states.AbiertoState;
import src.model.states.CerradoState;
import src.model.states.OfertaLaboralState;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class OfertaLaboral {

    private OfertaLaboralState estado;
    private String titulo;
    private LocalDateTime fechaFin;
    private String descripcion;
    private String modalidad;
    private String tipo;
    private Double sueldo;
    private String lugar;
    private String requisitos;
    private LocalDateTime fechaCreacion;
    private String trabajo;
    private List<Categoria> categorias;

    private List<Postulacion> postulaciones;

    public Postulacion postularse(Postulante postulante, Double remuneracion) {
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

    public void abrir(){
        this.estado = new AbiertoState();
    }

    public void cerrar(){
        this.estado = new CerradoState();
    }
}