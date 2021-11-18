package src.model;

import src.model.entities.Notificacion;

public class EnviarNotificacion {

    private EstrategiaDeNotificacion estrategia = new NotificacionPorMailEstrategia();

    public void enviarNotificacion(Notificacion notificacion) {
        this.estrategia.enviar(notificacion);
    }

    public void setEstrategiaDeNotificacion(EstrategiaDeNotificacion estrategia){
        this.estrategia = estrategia;
    }

}
