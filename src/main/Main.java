package src.main;

import src.controllers.OfertaLaboralController;
import src.controllers.ReporteController;
import src.controllers.UserController;
import src.model.ExportarImagenEnJpgEstrategia;
import src.model.entities.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //Controllers
        UserController uc = UserController.getInstance();
        OfertaLaboralController olc = OfertaLaboralController.getInstance();
        ReporteController rc = new ReporteController();

        Categoria sistemas = new Categoria("Sistemas");
        Categoria rrhh = new Categoria("RRHH");
        Categoria contable = new Categoria("Contable");

        Habilidad req1 = new Habilidad("Node");
        Habilidad req2 = new Habilidad("MySQL");
        Habilidad req3 = new Habilidad("Java");

        Empresa creador = Empresa
                .builder()
                .email("empresa@gmail.com")
                .cuit("asdasdads")
                .build();

        OfertaLaboral ofl1 = OfertaLaboral
                .builder()
                .titulo("BackEnd Developer Senior")
                .descripcion("Desarollador backend senior para empresa multinacional")
                .modalidadDeContrato(ModalidadDeContrato.partTime)
                .tipoDeTrabajo(TipoDeTrabajo.remoto)
                .lugar("")
                .tareas(List.of("unatarea", "dostarea", "unatarea", "dostarea"))
                .categoria(sistemas)
                .requisitos(List.of(req1, req2, req3))
                .sueldo(250000)
                .creador(creador)
                .build();

        OfertaLaboral ofl2 = OfertaLaboral
                .builder()
                .titulo("BackEnd Developer Senior CERRADA")
                .descripcion("Desarollador backend senior para empresa multinacional")
                .modalidadDeContrato(ModalidadDeContrato.fullTime)
                .tipoDeTrabajo(TipoDeTrabajo.remoto)
                .lugar("")
                .categoria(rrhh)
                .tareas(List.of("unasolatarea"))
                .requisitos(List.of(req1, req2, req3))
                .sueldo(250000)
                .creador(creador)
                .build();

        Idioma espanol = Idioma.builder().nombre("espanol").build();
        Idioma ingles = Idioma.builder().nombre("ingles").build();

        Postulante postulante = Postulante
                .builder()
                .email("postulante@gmail.com")
                .nombre("Gonzalo Esperidioni")
                .fechaNacimiento(LocalDateTime.of(1995, 12, 5, 0, 0))
                .nacionalidad("argentina")
                .idiomas(List.of(espanol, ingles))
                .intereses(List.of(sistemas))
                .habilidades(List.of(req1, req2, req3))
                .build();


        Postulante postulanteSinRequsitos = Postulante
                .builder()
                .email("postulanteSinReq@gmail.com")
                .nombre("Blabla tito")
                .fechaNacimiento(LocalDateTime.of(1996, 1, 12, 0, 0))
                .nacionalidad("argentina")
                .idiomas(List.of(espanol, ingles))
                .intereses(List.of(sistemas))
                .habilidades(List.of(req1))
                .build();

        uc.register(creador);
        uc.register(postulanteSinRequsitos);
        uc.register(postulante);

        olc.agregarOfertaLaboral(ofl1);
        olc.agregarOfertaLaboral(ofl2);
        olc.abrirPublicacion(ofl1, 5);
        olc.postularse(postulante, ofl1, 123123, "UN CV STRING");

        olc.postularse(postulanteSinRequsitos, ofl1, 1111, "UN CV STRING");

        System.out.println(String.format("LISTA DE POSTULADOS A %s", ofl1.getTitulo()));

        for (Postulacion postulacion : olc.verPostulaciones(ofl1)) {
            System.out.println(String.format("Postulado %s, Fecha de postulacion %s, remuneracion: %d, cv: %s",
                    postulacion.getPostulante().getEmail(), postulacion.getFechaPostulacion().toString(), postulacion.getRemuneracion(), postulacion.getCv()));
        }

        System.out.println(String.format("Generando imagen"));
        System.out.println(olc.generarImagenOfertaLaboral(ofl1));

        System.out.println(String.format("Obteniendo ofertas cerradas"));
        olc.obtenerOfertasCerradas().stream().forEach(o -> System.out.println(o.getTitulo()));

        System.out.println(String.format("Obteniendo oferta laboral con mas postulantes en un mes"));
        OfertaLaboral ofertaLaboralConMasPostualntes = rc.ofertaLaboralMasPostulantes(LocalDateTime.of(2021, 11, 18, 0, 0, 0));
        System.out.println(String.format("Oferta es: %s con %d postulantes", ofertaLaboralConMasPostualntes.getTitulo(), ofertaLaboralConMasPostualntes.getPostulaciones().size()));

        System.out.println(String.format("Obteniendo las categorias mas seleccionadas"));
        System.out.println(String.format("Categorias mas seleccionadas: %s", rc.categoriasMasSeleccionadas(2).toString()));

        System.out.println(String.format("Obteniendo la oferta mas exigente"));
        System.out.println(String.format("La oferta es: %s", rc.ofertaMasExigente().getTitulo()));

        System.out.println(String.format("Obteniendo la oferta mas accessible"));
        System.out.println(String.format("La oferta es: %s", rc.trabajoMasAccesible().getTitulo()));

        System.out.println(String.format("exportar imagen de oferta laboral"));
        System.out.println(olc.exportar(new ExportarImagenEnJpgEstrategia(), ofertaLaboralConMasPostualntes));
    }

}
