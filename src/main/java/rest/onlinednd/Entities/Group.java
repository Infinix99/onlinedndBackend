package rest.onlinednd.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;

import javax.persistence.*;
import java.util.Set;

@Entity(name="group_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer groupID;

    @ManyToMany(mappedBy = "groups")
    Set<User> users;

    @ManyToMany(mappedBy = "group_chars")
    Set<Charactersheet> charactersheets;


    private String name;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Set<Charactersheet> getCharactersheets() {
        return charactersheets;
    }

    public void setCharactersheets(Set<Charactersheet> charactersheets) {
        this.charactersheets = charactersheets;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
