package co.razorblade446.java.agentechateador.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Agente "Peliculas" que realiza las peticiones que se hacen para películas y realiza la consulta correcta al agente
 * "BaseDatos"
 */
public class PeliculasAgent extends Agent {
    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new AnalizarSolicitud());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    /**
     * Comportamiento que analiza las solicitudes (ACLMessage.REQUEST)y realizan las peticiones necesarias para
     */
    public class AnalizarSolicitud extends CyclicBehaviour{

        private MessageTemplate filtroMensaje;

        public AnalizarSolicitud(){

            this.filtroMensaje = MessageTemplate.and(
                    MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
                    MessageTemplate.MatchReceiver(new AID[]{getAID()})
            );

        }

        @Override
        public void action() {

            ACLMessage mensaje = myAgent.receive(filtroMensaje);

            if(mensaje != null){

            }

            block();

        }
    }
}
