package rest.onlinednd.ViewModels;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;

import javax.persistence.*;
import java.util.Set;


public class UserViewModel {



    private String name;

    private String email;

    private Set<Charactersheet> charactersheets;

    public UserViewModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Charactersheet> getCharactersheets() {
        return charactersheets;
    }

    public void setCharactersheets(Set<Charactersheet> charactersheets) {
        this.charactersheets = charactersheets;
    }
}
