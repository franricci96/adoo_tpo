package src.model;

import lombok.Data;
import src.model.entities.Categoria;
import src.model.entities.Notificacion;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class NotificationManager {

    private EnviarNotificacion enviarNotificacion = new EnviarNotificacion();

    //TODO ver este caso de postulantes, de donde los levanto
    private List<Postulante> postulantes = List.of();

    public void notificarNuevaOferta(OfertaLaboral ofertaLaboral) {
        for (Postulante post : postulantes) {
            List<Categoria> categoriasEnFavoritos = post.getFavoritos().stream().map(OfertaLaboral::getCategoria).collect(Collectors.toList());
            if (categoriasEnFavoritos.contains(ofertaLaboral.getCategoria())) {
                enviarNotificacion.enviarNotificacion(
                        Notificacion.builder()
                                .titulo("Nueva oferta laboral")
                                .cuerpo("Se cargo una oferta laboral que coincide con tus gustos")
                                .remitente(post)
                                .build()
                );
            }
        }

//        enviarNotificacion.enviarNotificacion(
//                Notificacion.builder()
//                        .titulo("Nueva oferta laboral")
//                        .cuerpo("Se cargo una oferta laboral que coincide con tus gustos")
//                        .remitente(Postulante.builder().nombre("gon").email("algo@sd.com").build())
//                        .build()
//        );
    }

}
