package co.razorblade446.java.agentechateador.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table
public class Pelicula {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column
    private long peliculaId;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private int generoId;

    @Column(nullable = false)
    private int anio;

    @Column
    private String trama;

    public Pelicula(){

    }

    public long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }
}