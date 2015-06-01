package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Plantilla de datos para api de tmpdb.org (/genre/list)
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreListMessage {

    private Collection<GenreMessage> genres;

    public Collection<GenreMessage> getGenres() {
        return genres;
    }

    public void setGenres(Collection<GenreMessage> genres) {
        this.genres = genres;
    }

    public GenreListMessage(Collection<GenreMessage> genres) {
        this.genres = genres;
    }
}
