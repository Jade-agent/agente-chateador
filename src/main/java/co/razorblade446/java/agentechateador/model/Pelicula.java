package co.razorblade446.java.agentechateador.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Clase de Persistencia para la tabla "pelicula" de la Base de Datos.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p"),
        @NamedQuery(name="Pelicula.findAllWithCast", query="SELECT p FROM Pelicula p WHERE p.personajes IS NOT EMPTY"),
		@NamedQuery(name="Pelicula.findOne", query="SELECT p FROM Pelicula p WHERE peliculaId = :peliculaId")
})
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int peliculaId;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	@Lob
	@Column(columnDefinition = "mediumtext")
	private String trama;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="generoId")
	private Genero genero;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="pelicula",fetch = FetchType.EAGER)
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="pelicula", fetch = FetchType.EAGER)
	private List<Personaje> personajes;

	public Pelicula() {
	}

	public int getPeliculaId() {
		return this.peliculaId;
	}

	public void setPeliculaId(int peliculaId) {
		this.peliculaId = peliculaId;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTrama() {
		return this.trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setPelicula(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setPelicula(null);

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
		personaje.setPelicula(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setPelicula(null);

		return personaje;
	}

}