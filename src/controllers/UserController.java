package src.controllers;

import src.model.entities.Empresa;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulante;
import src.model.entities.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public final class UserController {
    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

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
        return this.usuarios
                .stream()
                .filter(u -> u instanceof Postulante)
                .map(u -> (Postulante) u)
                .collect(Collectors.toList());
    }

}