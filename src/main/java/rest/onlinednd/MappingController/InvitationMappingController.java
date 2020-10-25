package rest.onlinednd.MappingController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Invitation;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.GroupRepository;
import rest.onlinednd.Repositories.InvitationRepository;
import rest.onlinednd.Repositories.UserRepository;
import rest.onlinednd.ViewModels.GroupViewModel;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/api/v1.0/User/{userid}/Group/{groupid}/Invitations")
public class InvitationMappingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private InvitationRepository invitationRepository;


    @CrossOrigin
    @PostMapping(
            path ="/create/{userName}"

    )
    public @ResponseBody
    String
    postCreateInvitation(@PathVariable int userid,@PathVariable int groupid, @PathVariable String userName) {

        Invitation invitation = new Invitation();


        User invitedUser = userRepository.findUserByName(userName);
        Group invitingGroup = groupRepository.findGroupByID(groupid);




        invitation.setInvitedUser(invitedUser);
        invitation.setInvitedUsername(invitedUser.getName());

        invitation.setInvitingGroup(invitingGroup);
        invitation.setInvitingGroupname(invitingGroup.getName());

        invitation.setGroupID(groupid);



        Set<Invitation> invited = invitedUser.getInvitedInList();
        invited.add(invitation);

        Set<Invitation> inv = invitingGroup.getInvitationsGroup();
        inv.add(invitation);


        invitationRepository.save(invitation);

        userRepository.save(invitedUser);
        groupRepository.save(invitingGroup);

        return "Eine Einladung wurde gesendet an " +invitedUser.getName();



    }

    @CrossOrigin
    @DeleteMapping("/{invid}/delete")
    public @ResponseBody String
    deleteInvitation(@PathVariable int invid) {

        Invitation invitation = invitationRepository.findInvByID(invid);


        User invitedUser = invitation.getInvitedUser();
        Group invitingGroup = invitation.getInvitingGroup();

        invitedUser.removeInvitedIn(invitation);
        invitingGroup.removeInviting(invitation);

        invitation.setInvitedUser(null);

        invitation.setInvitingGroup(null);


        userRepository.save(invitedUser);
        groupRepository.save(invitingGroup);
        invitationRepository.delete(invitation);


        return "Invitation has been deleted";

    }

    @GetMapping("/{invid}")
    public @ResponseBody Invitation
    getAllInvitation(@PathVariable int invid) {
        if (invid != 0 )
            return invitationRepository.findInvByID(invid);
        else
            return null;
    }


}
