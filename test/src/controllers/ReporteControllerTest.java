package test.src.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import src.controllers.OfertaLaboralController;
import src.controllers.ReporteController;
import src.model.entities.Categoria;
import src.model.entities.OfertaLaboral;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class ReporteControllerTest {

    ReporteController rc;
    @BeforeEach
    void setUp() {
        Categoria c1 = new Categoria("it");
        Categoria c2 = new Categoria("rrhh");
        Categoria c3 = new Categoria("legales");
        Categoria c4 = new Categoria("marketing");
        OfertaLaboralController olc = new OfertaLaboralController();
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta")
                .categorias(Arrays.asList(c1,c2,c3,c4))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 2")
                .categorias(Arrays.asList(c2,c4))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 3")
                .categorias(Arrays.asList(c2,c3))
                .build()
        );
        olc.agregarOfertaLaboral(OfertaLaboral
                .builder()
                .titulo("Titulo de oferta 4")
                .categorias(List.of(c2,c3))
                .build()
        );
        this.rc = new ReporteController(olc);
    }

    @org.junit.jupiter.api.Test
    void categoriasMasSeleccionadas() {
        Assert.assertEquals( "rrhh", this.rc.categoriasMasSeleccionadas(3).get(0).getNombre());
        Assert.assertEquals( "legales", this.rc.categoriasMasSeleccionadas(3).get(1).getNombre());
        Assert.assertEquals( "marketing", this.rc.categoriasMasSeleccionadas(3).get(2).getNombre());
    }

    @org.junit.jupiter.api.Test
    void ofertaLaboralMasPostulantes(){

        this.rc.ofertaLaboralMasPostulantes(LocalDateTime.now());
    }
}