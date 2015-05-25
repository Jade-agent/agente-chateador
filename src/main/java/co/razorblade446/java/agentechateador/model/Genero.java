package co.razorblade446.java.agentechateador.model;

import javax.persistence.*;

@Entity(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int generoId;

    @Column
    private String nombre;

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
