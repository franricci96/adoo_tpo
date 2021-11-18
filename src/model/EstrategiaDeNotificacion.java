package src.model;

import src.model.entities.Notificacion;

/**
 * 
 */
public interface EstrategiaDeNotificacion {
    void enviar(Notificacion notificacion);
}