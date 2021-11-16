package src.main;

import src.controllers.OfertaLaboralController;
import src.controllers.ReporteController;
import src.controllers.UserController;
import src.model.entities.OfertaLaboral;

public class Main {


    public static void main(String[]args) {

        //Controllers
        OfertaLaboralController olc = new OfertaLaboralController();
        ReporteController rc = new ReporteController(olc);
        UserController uc = new UserController();


    }

}
