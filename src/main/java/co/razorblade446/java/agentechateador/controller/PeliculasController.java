package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.model.Pelicula;
import co.razorblade446.java.agentechateador.model.PeliculaRepository;
import jade.wrapper.gateway.JadeGateway;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PeliculasController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @RequestMapping(value = "/peliculas", method = RequestMethod.GET)
    public String getListaPeliculas(ModelMap model){
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "peliculas_lista";
    }

    public PeliculasController() {
        super();
        JadeGateway.init("agents.UsuarioGateway", null);
    }
}
