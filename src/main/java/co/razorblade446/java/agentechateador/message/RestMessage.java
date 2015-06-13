package co.razorblade446.java.agentechateador.message;

import java.io.Serializable;

/**
 * Mensaje que se ptransporta entre el frontend del usuario, y el JadeGatewayAgent
 */
public class RestMessage implements Serializable {

    private String mensaje;

    private String chatId;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
