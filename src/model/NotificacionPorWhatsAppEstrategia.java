package src.model;

import src.model.entities.Notificacion;

/**
 *
 */
public class NotificacionPorWhatsAppEstrategia implements EstrategiaDeNotificacion {

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println(String.format("Enviando whatsapp a usuario: %s", notificacion.getRemitente()));
        System.out.println(String.format("Titulo: %s", notificacion.getTitulo()));
        System.out.println(String.format("Cuerpo: %s", notificacion.getCuerpo()));
        System.out.println("--------------------------------------------------------------------");
    }

}

