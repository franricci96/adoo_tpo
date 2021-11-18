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
    @Builder.Default
    private List<OfertaLaboral> favoritos = new ArrayList<>();
    @Builder.Default
    private List<Habilidad> habilidades = new ArrayList<>();
    @Builder.Default
    private List<Categoria> intereses = new ArrayList<>();
    @Builder.Default
    private List<Idioma> idiomas = new ArrayList<>();
}