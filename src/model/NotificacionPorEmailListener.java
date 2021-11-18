package src.model;

import lombok.Data;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;

@Data
public class NotificacionPorEmailListener implements OfertaLaboralObserver {

    @Override
    public void nuevoPostulante(OfertaLaboral oferta, Postulante postulante) {
        System.out.println(String.format("NOTIFICANDO A EMPRESA POR MAIL %s", oferta.getCreador().getEmail()));
        System.out.println(String.format("Nuevo postulante %s en oferta %s", postulante.getEmail(), oferta.getTitulo()));
        System.out.println("------------------------------------------------------------------------");
    }

    @Override
    public void nuevaOfertaLaboral(OfertaLaboral oferta, Postulante postulante) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("NOTIFICANDO A USUARIO POR MAIL %s", oferta.getCreador().getEmail()));
        System.out.println(String.format("Nueva oferta creada %s", oferta.getTitulo()));
        System.out.println("------------------------------------------------------------------------");
    }
}
