package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Plantilla de datos para tmpdb.org (/movie/{x})
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesMessage{

    private int id;

    private String overview;

    private Date release_date;

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        try {
            this.release_date = formatter.parse(release_date);
        } catch (Exception e) {
            this.release_date = new Date();
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MoviesMessage() {
    }

}