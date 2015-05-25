package co.razorblade446.java.agentechateador.agents;

import jade.wrapper.gateway.GatewayAgent;

public class UsuarioGateway extends GatewayAgent{

    private Usuario usuario;

    @Override
    protected void processCommand(Object command) {

        if(command instanceof Usuario){
            usuario = (Usuario) command;

            if(usuario.getUsuario().equals("root") && usuario.getContrasena().equals("root")){
                usuario.setMensaje("Válido");
            }else{
                usuario.setMensaje("Inválido");
            }

            releaseCommand(usuario);
        }

    }

    @Override
    protected void setup() {
        super.setup();
    }

}
