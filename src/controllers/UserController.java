package src.controllers;

import src.model.entities.Empresa;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;
import src.model.entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class UserController {
    private List<Usuario> usuarios = new ArrayList<>();

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

    public boolean register(Usuario usuario) {
        this.usuarios.add(usuario);
        return true;
    }

    public void agregarFavoritos(Postulante user, OfertaLaboral ofertaLaboral) {

    }

    public void seleccionarTareas() {

    }

    public List<Postulante> obtenerPostulantes() {
        List<Postulante> list = new ArrayList<>();
        for (Usuario user : this.usuarios) {
            if (user.getClass().isInstance(Postulante.class)) {
                list.add((Postulante) user);
            }
        }
        return list;
    }

}