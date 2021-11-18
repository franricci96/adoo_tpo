package src.model.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Builder
@Data
public class Postulacion {
    private LocalDateTime fechaPostulacion;
    private Postulante postulante;
    private String cv;
    private int remuneracion;
}
