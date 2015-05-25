package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.agents.Usuario;
import jade.wrapper.gateway.JadeGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    String mensaje = "Bienvenido a Spring";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMessage(ModelMap modelMap){
        return "chateador";
    }

    @RequestMapping(value = "/usuario/prueba", method = RequestMethod.GET)
    public String showUsuarioAgentePrueba(ModelMap modelMap){
        return "usuario_prueba";
    }

    @RequestMapping(value ="/usuario/validar", method = RequestMethod.POST)
    public String validateLogin(ModelMap model,
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

        model.addAttribute("respuesta", usuario.getMensaje());
        return "usuario_validar";

    }
}
