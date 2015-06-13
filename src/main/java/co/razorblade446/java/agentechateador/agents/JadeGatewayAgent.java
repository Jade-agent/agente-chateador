package co.razorblade446.java.agentechateador.agents;

import co.razorblade446.java.agentechateador.message.RestMessage;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.gateway.GatewayAgent;

import java.util.UUID;

/**
 * Agente "Gateway" se encarga de interconectar JADE y Spring
 *
 * Se encarga de procesar los mensjes desde el Servlet Spring MVC(WEB)
 */

public class JadeGatewayAgent extends GatewayAgent {

    private AID agenteID;
    private RestMessage comando;

    @Override
    protected void setup() {
        super.setup();
        this.addBehaviour(new ResponderFacilitacion());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    @Override
    protected void processCommand(Object command) {
        if(command instanceof RestMessage){

            // Leer el mensaje que se debe procesar.
            comando = (RestMessage) command;

            String mensaje = comando.getMensaje();
            String chatId = comando.getChatId();

            if(chatId.equals(""))
                chatId = String.valueOf(UUID.randomUUID());

            ACLMessage message = new ACLMessage(ACLMessage.INFORM);
            message.setContent(mensaje);
            message.addReceiver(new AID("Facilitador",AID.ISLOCALNAME));
            message.addReplyTo(getAID());
            message.setConversationId(chatId);
            send(message);
        }
    }

    /**
     * Declaración del comportamiento "Responder facilitación" que básicamente expone que si hay un mensaje de caracter
     * "PROPUESTA - ACLMessage.PROPOSE" nos da a entender que ya tiene algo que decir al usuario.
     */
    public class ResponderFacilitacion extends CyclicBehaviour{

        private MessageTemplate filtroMensaje;

        public ResponderFacilitacion(){
            filtroMensaje = MessageTemplate.and(
                    MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
                    MessageTemplate.MatchReceiver(new AID[]{myAgent.getAID()}));
        }

        @Override
        public void action() {
            ACLMessage respuesta = myAgent.receive(filtroMensaje);

            if(respuesta != null){

                if(comando == null)
                    comando = new RestMessage();

                comando.setMensaje(respuesta.getContent());
                System.out.print("Behaviour ejecutado " + respuesta.getContent());
                releaseCommand(comando);

            }

            block(2000);
        }
    }

    /**
     * Declaración del comportamiento "Responder facilitación" que básicamente expone que si hay un mensaje de caracter
     * "PROPUESTA - ACLMessage.PROPOSE" nos da a entender que ya tiene algo que decir al usuario.
     */

    class AnalizarMensaje extends CyclicBehaviour{

        private MessageTemplate filtroMensaje;

        public AnalizarMensaje(){
            // Filtro de mensaje que responde a una "Petición siempre" que el gateway hace
            filtroMensaje = MessageTemplate.MatchPerformative(ACLMessage.REQUEST_WHENEVER);

        }

        @Override
        public void action() {

        }
    }

}
