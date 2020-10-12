package rest.onlinednd.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name="group_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer groupID;

    @ManyToMany(mappedBy = "groups")
    Set<User> users;

    public Group() {
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
