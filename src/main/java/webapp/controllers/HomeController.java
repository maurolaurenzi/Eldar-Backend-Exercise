package webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.repositories.RepositorioTarjetas;

@Controller
public class HomeController {
    private final RepositorioTarjetas repositorioTarjetas;

    public HomeController(RepositorioTarjetas repositorioTarjetas) {
        this.repositorioTarjetas = repositorioTarjetas;
    }

    @RequestMapping("")
    public String getTarjetas(Model model){ //el model lo provee Spring
        model.addAttribute("tarjetas",repositorioTarjetas.findAll());
        return "/home";
    }
}
