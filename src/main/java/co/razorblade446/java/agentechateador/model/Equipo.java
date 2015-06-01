package co.razorblade446.java.agentechateador.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de Persistencia para la tabla "equipo" de la Base de Datos.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=true, updatable=true)
	private int equipoId;

	private String tipo;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="peliculaId")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="personaId")
	private Persona persona;

	public Equipo() {
	}

	public int getEquipoId() {
		return this.equipoId;
	}

	public void setEquipoId(int equipoId) {
		this.equipoId = equipoId;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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