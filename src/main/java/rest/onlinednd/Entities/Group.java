package rest.onlinednd.Entities;

import rest.onlinednd.Entities.Charactersheet.Charactersheet;

import javax.persistence.*;
import java.util.Set;

@Entity(name="group_table")
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
}
