package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Plantilla de datos para tmpdb.org (/genre/{x}/movies)
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreMoviesMessage {

    private int page;

    private int total_pages;

    private Collection<MoviesMessage> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public Collection<MoviesMessage> getResults() {
        return results;
    }

    public void setResults(Collection<MoviesMessage> results) {
        this.results = results;
    }

    public GenreMoviesMessage() {
    }

}
