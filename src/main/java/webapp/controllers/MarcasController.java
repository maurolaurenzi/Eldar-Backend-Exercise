package webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webapp.domain.MarcaTarjeta;
import webapp.domain.NombreMarca;
import webapp.domain.Operacion;
import webapp.repositories.RepositorioMarcaTarjetas;

import java.time.LocalDate;

@Controller
public class MarcasController {
    private final RepositorioMarcaTarjetas repositorioMarcaTarjetas;

    public MarcasController(RepositorioMarcaTarjetas repositorioMarcaTarjetas) {
        this.repositorioMarcaTarjetas = repositorioMarcaTarjetas;
    }
    //buscamos la marca segun el nombre -> deberia implementarse metodo en Repositorio -> findByName()
    @RequestMapping("tasas/valor")
    public String getTasa(Model model, @RequestParam(name = "marca") NombreMarca nombre,
                          @RequestParam(name = "monto") Double monto){
        Double valor = -1.00;
        for(MarcaTarjeta marcaTarjeta: repositorioMarcaTarjetas.findAll()){
            if(marcaTarjeta.getNombre().equals(nombre)) {
                MarcaTarjeta marca = marcaTarjeta;
                valor = Operacion.calcularTasa(marca,monto,LocalDate.now());
                break;
            }
        }
        model.addAttribute("nombreMarca",nombre);
        model.addAttribute("monto",monto);
        model.addAttribute("resultado",valor);

        return "valor";
    }

    @RequestMapping("tasas")
    public String getIndex(Model model){ //el model lo provee Spring
        model.addAttribute("marcasTarjetas",repositorioMarcaTarjetas.findAll());
        return "tasa";
    }
}
