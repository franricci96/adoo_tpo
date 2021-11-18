package src.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


import java.time.LocalDateTime;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class Postulante extends Usuario {
    private String nombre;
    private LocalDateTime fechaNacimiento;
    private String cuil;
    private String nacionalidad;
    @Builder.Default
    private List<Postulacion> postulaciones = new ArrayList<>();
    private List<OfertaLaboral> favoritos;
    private List<Habilidad> habilidades;
    private List<Categoria> intereses;
    private List<Idioma> idiomas;
}