package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.agents.FacilitadorMessage;
import jade.domain.introspection.ACLMessage;
import jade.wrapper.gateway.JadeGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Clase principal de la aplicación, contiene métodos de controlador para mostrar información.
 */

@Controller
public class MainController {
    String mensaje = "Bienvenido a Spring";

    /**
     * Método "principal" del controlador inicial de la aplicación, para cuando se inicia la aplicación
     * @param modelMap
     * @return String
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMessage(ModelMap modelMap){
        return "chateador";
    }

    @RequestMapping(value = "/api/facilitador", method = RequestMethod.POST)
    @ResponseBody
    public FacilitadorMessage apiFacilitador(@RequestParam("mensaje") String mensaje){
        FacilitadorMessage message = new FacilitadorMessage();
        return message;
    }

    /**
     * Constructor del controlador, adicionalmente inicializa los agentes
     */
    public MainController(){
        //super();
        JadeGateway.init("agents.FacilitadorGatewayAgent", null);
    }
}
