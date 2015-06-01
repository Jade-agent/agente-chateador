package co.razorblade446.java.agentechateador.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de Persistencia para la tabla "personaje" de la Base de Datos.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p"),
        @NamedQuery(name="Personaje.findOne", query="SELECT p FROM Personaje p WHERE p.personajeId = :personajeId")
})
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=true, updatable=true)
	private int personajeId;

	private String nombre;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="peliculaId")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="personaId")
	private Persona persona;

	public Personaje() {
	}

	public int getPersonajeId() {
		return this.personajeId;
	}

	public void setPersonajeId(int personajeId) {
		this.personajeId = personajeId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}