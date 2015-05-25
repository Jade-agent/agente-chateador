package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.agents.Usuario;
import jade.wrapper.gateway.JadeGateway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    String mensaje = "Bienvenido a Spring";

    @RequestMapping("/main")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Mundo") String name){
        System.out.println("En controlador");

        ModelAndView mv = new ModelAndView("main");
        mv.addObject("message", mensaje);
        mv.addObject("name", name);
        return mv;
    }

    @RequestMapping(value ="/validar", method = RequestMethod.POST)
    public ModelAndView validateLogin(
            @RequestParam(value = "user", required = true) String user,
            @RequestParam(value = "password", required = true) String password){

        Usuario usuario = new Usuario();
        usuario.setUsuario(user);
        usuario.setContrasena(password);

        try{
            JadeGateway.execute(usuario);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("main_usuario");
        mv.addObject("respuesta", usuario.getMensaje());
        return mv;

    }
}
