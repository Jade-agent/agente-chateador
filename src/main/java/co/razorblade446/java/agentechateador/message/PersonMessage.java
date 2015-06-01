package co.razorblade446.java.agentechateador.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonMessage {

    private Date birthday;

    private String name;

    private Collection<String> also_known_as;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        try {
            this.birthday = formatter.parse(birthday);
        } catch (Exception e) {
            this.birthday = new Date();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(Collection<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    public PersonMessage() {
    }
}
