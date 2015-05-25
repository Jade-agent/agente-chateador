package co.razorblade446.java.agentechateador.agents;

public class Usuario implements java.io.Serializable{

    private String usuario = new String("");
    private String contrasena = new String("");
    private String mensaje = new String("");

    public Usuario(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
