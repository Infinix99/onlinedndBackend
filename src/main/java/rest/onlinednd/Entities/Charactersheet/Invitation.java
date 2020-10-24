package rest.onlinednd.Entities.Charactersheet;


import com.fasterxml.jackson.annotation.JsonBackReference;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;

import javax.persistence.*;

@Entity(name="invitation")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invID;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private User invitedUser;

    private String invitedUsername;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private User invitingUser;

    private String invitingUsername;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private Group invitingGroup;

    private String invitingGroupname;

    private int GroupID;






    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public String getInvitedUsername() {
        return invitedUsername;
    }

    public void setInvitedUsername(String invitedUsername) {
        this.invitedUsername = invitedUsername;
    }

    public String getInvitingUsername() {
        return invitingUsername;
    }

    public void setInvitingUsername(String invitingUsername) {
        this.invitingUsername = invitingUsername;
    }

    public String getInvitingGroupname() {
        return invitingGroupname;
    }

    public void setInvitingGroupname(String invitingGroupname) {
        this.invitingGroupname = invitingGroupname;
    }

    public Integer getInvID() {
        return invID;
    }

    public void setInvID(Integer invID) {
        this.invID = invID;
    }

    public User getInvitedUser() {
        return invitedUser;
    }

    public void setInvitedUser(User invitedUser) {
        this.invitedUser = invitedUser;
    }

    public User getInvitingUser() {
        return invitingUser;
    }

    public void setInvitingUser(User invitingUser) {
        this.invitingUser = invitingUser;
    }

    public Group getInvitingGroup() {
        return invitingGroup;
    }

    public void setInvitingGroup(Group invitingGroup) {
        this.invitingGroup = invitingGroup;
    }
}
