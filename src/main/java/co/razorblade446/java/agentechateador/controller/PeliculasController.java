package co.razorblade446.java.agentechateador.controller;

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
    private SessionFactory sessionFactory;

    private Session currentSession;

    @RequestMapping(value = "/peliculas", method = RequestMethod.GET)
    public ModelAndView getListaPeliculas(ModelMap modelo){
        ModelAndView mv = new ModelAndView("peliculas_listado");
        return mv;
    }

    public PeliculasController() {
        super();
        JadeGateway.init("agents.UsuarioGateway", null);
    }
}
