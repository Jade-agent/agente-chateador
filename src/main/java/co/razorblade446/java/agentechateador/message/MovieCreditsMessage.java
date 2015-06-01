package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieCreditsMessage {

    private Collection<CastMessage> cast;

    private Collection<CrewMessage> crew;

    public Collection<CastMessage> getCast() {
        return cast;
    }

    public void setCast(Collection<CastMessage> cast) {
        this.cast = cast;
    }

    public Collection<CrewMessage> getCrew() {
        return crew;
    }

    public void setCrew(Collection<CrewMessage> crew) {
        this.crew = crew;
    }

    public MovieCreditsMessage() {
    }
}
