package src.model.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Idioma {
    private String nombre;
    private String codigo;
    private String nivel;
}
