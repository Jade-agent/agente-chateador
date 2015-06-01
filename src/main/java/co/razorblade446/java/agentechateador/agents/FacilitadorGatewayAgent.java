package co.razorblade446.java.agentechateador.agents;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.wrapper.gateway.GatewayAgent;

/**
 * Agente "Facilitador"
 */

public class FacilitadorGatewayAgent extends GatewayAgent {

    Behaviour procesarMensajeUsuario;

    @Override
    protected void setup() {
        super.setup();

        procesarMensajeUsuario = new ProcesarMensajeUsuarioBehaviour();

        this.addBehaviour(procesarMensajeUsuario);

    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    @Override
    protected void processCommand(Object command) {
        super.processCommand(command);
    }

    private class ProcesarMensajeUsuarioBehaviour extends CyclicBehaviour{

        @Override
        public void action() {
            System.out.println("Comportamiento '" + getBehaviourName() + "' en ejecución...");
        }
    }

}
