package test.src.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import src.controllers.OfertaLaboralController;
import src.controllers.ReporteController;
import src.model.entities.Categoria;
import src.model.entities.OfertaLaboral;
import src.model.entities.Postulacion;
import src.model.entities.Postulante;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ReporteControllerTest {

    ReporteController rc;

    @BeforeEach
    void setUp() {
        Categoria c1 = new Categoria("it");
        Categoria c2 = new Categoria("rrhh");
        Categoria c3 = new Categoria("legales");
        Categoria c4 = new Categoria("marketing");
        OfertaLaboralController olc = new OfertaLaboralController();
        this.rc = new ReporteController(olc);
        Postulante p1 = Postulante.builder().cuil("1231321").build();
        Postulante p2 = Postulante.builder().cuil("312321").build();
        Postulante p3 = Postulante.builder().cuil("31231").build();
        Postulacion postulacion1 = Postulacion.builder().postulante(p1).remuneracion(1233).build();
        Postulacion postulacion2 = Postulacion.builder().postulante(p2).remuneracion(1233).build();
        Postulacion postulacion3 = Postulacion.builder().postulante(p3).remuneracion(1233).build();
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta CON MAS POSTULANTES")
                .categorias(Arrays.asList(c1, c2, c3, c4))
                .postulaciones(List.of(postulacion1, postulacion2, postulacion3))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 2")
                .categorias(Arrays.asList(c2, c4))
                .postulaciones(List.of(postulacion1))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 3")
                .categorias(Arrays.asList(c2, c3))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 4")
                .categorias(List.of(c2, c3))
                .build()
        );
    }

    @org.junit.jupiter.api.Test
    void categoriasMasSeleccionadas() {
        Assertions.assertEquals("rrhh", this.rc.categoriasMasSeleccionadas(3).get(0).getNombre());
        Assertions.assertEquals("legales", this.rc.categoriasMasSeleccionadas(3).get(1).getNombre());
        Assertions.assertEquals("marketing", this.rc.categoriasMasSeleccionadas(3).get(2).getNombre());
    }

    @org.junit.jupiter.api.Test
    void ofertaLaboralMasPostulantes() {
        Assertions.assertEquals("Titulo de oferta CON MAS POSTULANTES",
                this.rc.ofertaLaboralMasPostulantes(LocalDateTime.now()).getTitulo());

    }

}