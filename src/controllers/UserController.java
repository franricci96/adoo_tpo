package src.controllers;

import src.model.entities.Empresa;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;
import src.model.entities.Usuario;

/**
 *
 */
public class UserController {
    public UserController() {
    }

    public Usuario login(String user, String password) {
        if (user.equals("postulante"))
            return Postulante
                    .builder()
                    .cuil("uncuil")
                    .build();
        return Empresa.builder().cuit("cuit").build();
    }

    public void logout(Usuario user) {

    }

    public boolean register(String nombre, String password, String codigo) {
        return true;
    }

    public void agregarFavoritos(Postulante user, OfertaLaboral ofertaLaboral) {

    }

    public void seleccionarTareas() {

    }

}