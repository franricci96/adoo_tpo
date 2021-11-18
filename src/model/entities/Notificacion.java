package src.model.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Notificacion {
    private Usuario remitente;
    private String titulo;
    private String cuerpo;
}
