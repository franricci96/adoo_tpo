package src.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Postulante extends Usuario {
    private String nombre;
    private Date fechaNacimiento;
    private String cuil;
    private String nacionalidad;
    private List<Postulacion> postulaciones;
    private List<OfertaLaboral> favs;
    private List<Habilidad> habilidades;
    private List<Idioma> idiomas;
}