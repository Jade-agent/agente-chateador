package co.razorblade446.java.agentechateador.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de Persistencia para la tabla "genero" de la Base de Datos.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g"),
        @NamedQuery(name="Genero.findOne", query="SELECT g FROM Genero g WHERE generoId = :generoId")
})
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=true, updatable=true)
	private short generoId;

	private String nombre;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="genero")
	private List<Pelicula> peliculas;

	public Genero() {
	}

	public short getGeneroId() {
		return this.generoId;
	}

	public void setGeneroId(short generoId) {
		this.generoId = generoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setGenero(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setGenero(null);

		return pelicula;
	}

}