package rest.onlinednd.Entities;

import javax.persistence.*;

@Entity(name="group_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer groupID;

    public Group() {
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
