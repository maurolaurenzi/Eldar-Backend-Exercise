package webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TasaController {
    @RequestMapping("/tasas")
    public String getIndex(Model model){ //el model lo provee Spring
        return "/tasa";
    }
}
