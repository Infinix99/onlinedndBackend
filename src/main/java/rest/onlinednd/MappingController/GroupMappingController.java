package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;
import rest.onlinednd.Repositories.GroupRepository;
import rest.onlinednd.Repositories.UserRepository;
import rest.onlinednd.ViewModels.GroupViewModel;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/User/{userid}/Group")
public class GroupMappingController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CharactersheetRepository charactersheetRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping ("/{groupid}")
    public @ResponseBody
    Group getGroup (@PathVariable int groupid , @PathVariable int userid) {
        Group group = groupRepository.findGroupByID(groupid);
        return group;
    }

    @GetMapping ("/{groupid}/AllCharactersheets")
    public @ResponseBody
    Set<Charactersheet> getGroupSheets (@PathVariable int groupid , @PathVariable int userid) {
        Group group = groupRepository.findGroupByID(groupid);


        return group.getCharactersheets();

    }
    //_____________________________________________________________

    @PostMapping("/CreateGroup")
    public @ResponseBody String
    postCreateGroup(@RequestBody GroupViewModel groupViewModel, @PathVariable int userid) {
        Group group = new Group();
        group.setName(groupViewModel.getName());
        //_________________________________________

        Set<Group> groupSet = new HashSet<Group>();
        groupSet.add(group);

        User user = userRepository.findUserByID(userid);

        user.setGroups(groupSet);
        groupRepository.save(group);
        userRepository.save(user);


        return "Gruppe wurde angelegt";
    }

    @PostMapping("/{groupid}/addToGroup")
    public @ResponseBody String
    postaddToGroup(@PathVariable int userid, @PathVariable int groupid) {
        User user = userRepository.findUserByID(userid);
        Group group = groupRepository.findGroupByID(groupid);

        Set<Group> groupSet = user.getGroups();
        groupSet.add(group);
        //_________________________________________
        Set<User> userSet = group.getUsers();
        userSet.add(user);

        groupRepository.save(group);
        userRepository.save(user);


        return "User "+user.getName()+" ist der Gruppe "+group.getName()+" beigetreten";
    }

    // TODO:
    // USER REMOVE FROM GROUP
    // DELETE GROUP
    // Charactersheets - Group oneToMany ändern
    // --> Post etc.


        /*
    @PostMapping
            path = "/register"
            //consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    //@ResponseStatus(HttpStatus.OK)
    public @ResponseBody String postUser(@RequestBody Group group) {
        if(group!= null)
            groupRepository.save(group);

        return "Gruppe " + group.getName() + " wurde angelegt";
    }


         */
}
