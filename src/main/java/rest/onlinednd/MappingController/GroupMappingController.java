package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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



    //_____________________________________________________________

    // CREATE A GROUP WITH A USER

    @CrossOrigin
    @PostMapping(
            path ="/createGroup",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody String
    postCreateGroup(@RequestBody GroupViewModel groupViewModel, @PathVariable int userid) {
        Group group = new Group();

        User user = userRepository.findUserByID(userid);
        group.setName(groupViewModel.getName());
        //_________________________________________

//        Set<Group> groupSet = new HashSet<Group>();
        Set<Group> groupSet = user.getGroups();
        groupSet.add(group);

        user.setGroups(groupSet);
        groupRepository.save(group);
        userRepository.save(user);


        return "Gruppe wurde angelegt";
    }

    // ADD USER TO GROUP

    @CrossOrigin
    @PostMapping(
            path = "/{groupid}/addToGroup",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
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

    // REMOVE USER FROM GROUP

    @DeleteMapping("/{groupid}/removeFromGroup")
    public @ResponseBody String
    deleteRemoveFromGroup(@PathVariable int userid, @PathVariable int groupid) {
        User user = userRepository.findUserByID(userid);
        Group group = groupRepository.findGroupByID(groupid);

        user.removeFromGroup(group);

        userRepository.save(user);
        groupRepository.save(group);


        return "User " +user.getName()+" has been removed from Group " +group.getName();

    }

    // DELETE WHOLE GROUP

    @DeleteMapping("/{groupid}/deleteGroup")
    public  @ResponseBody
    String deleteGroup(@PathVariable int groupid, @PathVariable int userid){
        User user = userRepository.findUserByID(userid);
        Group group = groupRepository.findGroupByID(groupid);

        Set<User> userSet = group.getUsers();

        for (User u : userSet){
            u.removeFromGroup(group); }

        group.deleteGroups(user);

        userRepository.save(user);
        groupRepository.delete(group);

        return "Group has been deleted";
    }







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
