package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Plantilla de datos para tmpdb.org (genre/{x})
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreMessage {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreMessage() {
    }
}
