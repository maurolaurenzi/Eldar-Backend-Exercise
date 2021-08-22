package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.repositories.RepositorioMarcaTarjetas;
import webapp.repositories.RepositorioTarjetas;

@Controller
public class HomeController {
    private final RepositorioTarjetas repositorioTarjetas;
    private final RepositorioMarcaTarjetas repositorioMarcaTarjetas;

    public HomeController(RepositorioTarjetas repositorioTarjetas,
                          RepositorioMarcaTarjetas repositorioMarcaTarjetas) {
        this.repositorioTarjetas = repositorioTarjetas;
        this.repositorioMarcaTarjetas = repositorioMarcaTarjetas;
    }

    @RequestMapping("")
    //en la pagina de inicio se mostrara un listado de todas las tarjetas y marcas existentes
    public String getIndex(Model model){
        model.addAttribute("tarjetas",repositorioTarjetas.findAll());
        model.addAttribute("marcasTarjetas",repositorioMarcaTarjetas.findAll());
        return "index";
    }
}
