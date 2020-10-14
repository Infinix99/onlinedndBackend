package rest.onlinednd.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "groups"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserID;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Charactersheet> charactersheets;

    @ManyToMany
    Set<Group> groups;



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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Group> deleteGroups(Group group) {
        this.groups.remove(group);
        group.getUsers().remove(this);

        return groups;
    }

    public void removeFromGroup(Group group) {
        this.getGroups().remove(group);


    }

}
