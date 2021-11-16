package src.model.entities;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public class Postulacion {

    private LocalDateTime fechaPostulacion;
    private Postulante postulante;
    private Double remuneracion;

}
