package co.razorblade446.java.agentechateador.controller;

import co.razorblade446.java.agentechateador.message.RestMessage;
import jade.core.AID;
import jade.core.Profile;
import jade.core.ProfileException;
import jade.core.ProfileImpl;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Properties;
import jade.wrapper.ControllerException;
import jade.wrapper.gateway.JadeGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Clase principal de la aplicación, contiene métodos de controlador para mostrar información.
 */

@Controller
public class MainController {
    String mensaje = "Bienvenido a Spring";

    /**
     * Método "principal" del controlador inicial de la aplicación, para cuando se inicia la aplicación
     * @return String
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMessage(){
        return "chateador";
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage apiFacilitador(@RequestParam("mensaje") String mensajeChat, @RequestParam("chatId") String chatId) {

        // Procesar el Mensaje
        RestMessage mensaje = new RestMessage();
        mensaje.setMensaje(mensajeChat);
        mensaje.setChatId(chatId);

        try {
            JadeGateway.execute(mensaje);
        } catch (ControllerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mensaje;
    }

    /**
     * Constructor del controlador, adicionalmente inicializa los agentes
     */
    public MainController(){

        try {
            Properties properties = new Properties();
            properties.load("src/main/resources/jade-agent.properties");
            JadeGateway.init("co.razorblade446.java.agentechateador.agents.JadeGatewayAgent", properties);
            //JadeGateway.init(null, properties);
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
