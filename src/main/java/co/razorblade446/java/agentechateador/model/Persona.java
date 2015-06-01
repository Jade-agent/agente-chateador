package co.razorblade446.java.agentechateador.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Clase de Persistencia para la tabla "persona" de la Base de Datos.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
        @NamedQuery(name="Persona.findOne", query="SELECT p FROM Persona p WHERE personaId = :personaId")
})
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=true, updatable=true)
	private int personaId;

	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	@Column(name="url_foto")
	private String urlFoto;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="persona")
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="persona")
	private List<Personaje> personajes;

	public Persona() {
	}

	public int getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setPersona(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setPersona(null);

		return equipo;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje addPersonaje(Personaje personaje) {
		getPersonajes().add(personaje);
		personaje.setPersona(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setPersona(null);

		return personaje;
	}

}