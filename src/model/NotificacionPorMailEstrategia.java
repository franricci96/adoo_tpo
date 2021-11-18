package src.model;

import src.model.entities.Notificacion;

public class NotificacionPorMailEstrategia implements EstrategiaDeNotificacion {
    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println(String.format("Enviando email a usuario: %s", notificacion.getRemitente()));
        System.out.println(String.format("Titulo: %s", notificacion.getTitulo()));
        System.out.println(String.format("Cuerpo: %s", notificacion.getCuerpo()));
        System.out.println("--------------------------------------------------------------------");
    }
}
