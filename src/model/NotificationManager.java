package src.model;

import lombok.Data;
import src.controllers.UserController;
import src.model.entities.Categoria;
import src.model.entities.Notificacion;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class NotificationManager {

    private EnviarNotificacion enviarNotificacion = new EnviarNotificacion();
    private UserController userController = UserController.getInstance();

    public void notificarNuevaOferta(OfertaLaboral ofertaLaboral) {

        for (Postulante post : userController.obtenerPostulantes()) {
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
