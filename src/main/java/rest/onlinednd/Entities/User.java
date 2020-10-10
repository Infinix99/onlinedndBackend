package rest.onlinednd.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserID;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Charactersheet> charactersheets;



    //---------------Getter Setter---------------------------------------------------

    public Set<Charactersheet> getCharactersheets() {
        return charactersheets;
    }

    public void setCharactersheets(Set<Charactersheet> charactersheets) {
        this.charactersheets = charactersheets;
    }

    public Integer getId() {
        return UserID;
    }

    public void setId(Integer id) {
        this.UserID = id;
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
}
