package src.model;

import lombok.Data;
import src.model.entities.Notificacion;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;

@Data
public class NotificacionListener implements OfertaLaboralObserver {

    private EnviarNotificacion enviarNotificacion = new EnviarNotificacion();

    @Override
    public void nuevoPostulante(OfertaLaboral oferta, Postulante postulante) {
        enviarNotificacion.enviarNotificacion(
                Notificacion
                        .builder()
                        .titulo(String.format("Nuevo postulante %s en oferta %s", postulante.getEmail(), oferta.getTitulo()))
                        .cuerpo("Un cuerpo vacio")
                        .remitente(oferta.getCreador()).build());
    }

}
