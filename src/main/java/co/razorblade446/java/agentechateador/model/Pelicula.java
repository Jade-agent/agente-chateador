package co.razorblade446.java.agentechateador.model;

import javax.persistence.*;

import java.sql.Date;

/**
 * Modelo de Entidad "pelicula"
 */

@Entity(name = "pelicula")
public class Pelicula {

    @Id
    @Column(insertable=true, updatable=true)
    private int peliculaId;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, columnDefinition = "DATE")
    private Date fecha;

    @Column
    private short generoId;

    @Lob
    @Column(columnDefinition = "mediumtext")
    private String trama;

    public long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public short getGeneroId() {
        return generoId;
    }

    public void setGeneroId(short generoId) {
        this.generoId = generoId;
    }
}