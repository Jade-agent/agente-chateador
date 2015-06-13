package co.razorblade446.java.agentechateador.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

public class FacilitadorAgent extends Agent {

    private AID responderA;
    protected static Pattern PatronSaludo = Pattern.compile("hola|(buenos\\s?(dias|tardes|noches))?", Pattern.CASE_INSENSITIVE);

    protected static Pattern PatronPelicula = Pattern.compile("(qu[eé] pel[ií]cula (protagoniz[oó]|hizo)\\s(.*)$)", Pattern.CASE_INSENSITIVE);

    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new ProcesarEntradaUsuario());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    /**
     * Comportamiento ciclico que debe validar la entrada del usuario por un formato específico y decidir que hacer.
     */
    public class ProcesarEntradaUsuario extends CyclicBehaviour{

        private MessageTemplate filtroMensaje;

        public ProcesarEntradaUsuario(){
            filtroMensaje = MessageTemplate.and(
                    MessageTemplate.MatchPerformative(ACLMessage.INFORM),
                    MessageTemplate.MatchReceiver(new AID[]{getAID()})
            );
        }

        @Override
        public void action() {

            ACLMessage mensaje = myAgent.receive(filtroMensaje);

            if(mensaje != null){
                System.out.println("Mensaje del Usuario: " + mensaje.getContent());

                Iterator tempIter = mensaje.getAllReplyTo();

                while(tempIter.hasNext()) {
                    responderA = (AID) tempIter.next();
                    break;
                }

                ACLMessage mensajeRespuesta = new ACLMessage(ACLMessage.INFORM);

                String mensajeUsuario = mensaje.getContent();

                HashMap<Integer, String> mapaIngreso = validarEntradaUsuario(mensajeUsuario);

                if(mapaIngreso.containsKey(0)){

                    String tipo = mapaIngreso.get(0);

                    switch(tipo){
                        case "saludo":
                            mensajeRespuesta.setPerformative(ACLMessage.PROPOSE);
                            mensajeRespuesta.addReceiver(responderA);
                            mensajeRespuesta.setContent(saludoAzar());
                            break;

                        case "pelicula":
                            mensajeRespuesta.setPerformative(ACLMessage.REQUEST);
                            mensajeRespuesta.addReceiver(new AID("Peliculas", AID.ISLOCALNAME));
                            mensajeRespuesta.setContent(mensaje.getContent());
                            break;
                    }



                }else{
                    mensajeRespuesta.addReceiver(responderA);
                    mensajeRespuesta.setPerformative(ACLMessage.PROPOSE);
                    mensajeRespuesta.setContent("Lo siento pero no te entiendo...");
                }

                myAgent.send(mensajeRespuesta);

            }

            block(2000);

        }

        /**
         * Método que evalua si el patron de entrada del usuario coincide con alguno válido y entendíble
         * @param entrada
         * @return
         */
        private HashMap<Integer,String> validarEntradaUsuario(String entrada){
            HashMap<Integer,String > respuesta = new HashMap<Integer, String>();

            // Validar Saludos
            if(PatronSaludo.matcher(entrada).matches()){
                respuesta.put(0, "saludo");
            }else if(PatronPelicula.matcher(entrada).matches()){
                respuesta.put(0, "pelicula");
            }

            return respuesta;
        }

        /**
         * Devuelve un saludo al azar
         * @return
         */
        private String saludoAzar(){

            String[] saludos = new String[]{
                    "Hola!",
                    "Saludos terrícola",
                    "Oye que bien me escribes",
                    "Ay estaba tan solo!"
            };

            Random azar = new Random();

            return saludos[azar.nextInt(saludos.length)];

        }

    }
}
