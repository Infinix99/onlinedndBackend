package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;
import rest.onlinednd.Repositories.GroupRepository;

import javax.websocket.server.PathParam;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/User/{userid}/Group")
public class GroupMappingController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CharactersheetRepository charactersheetRepository;

    @GetMapping ("/{groupid}")
    public @ResponseBody
    Group getGroup (@PathVariable int groupid , @PathVariable int userid) {
        return groupRepository.findGroupByID(groupid);
    }

    @GetMapping ("/{groupid}/AllCharactersheets")
    public @ResponseBody
    Set<Charactersheet> getGroupSheets (@PathVariable int groupid , @PathVariable int userid) {
        Group group = groupRepository.findGroupByID(groupid);

        return group.getCharactersheets();

    }
    //_____________________________________________________________

    @PostMapping("/Charactersheet/{charid}/addto/{groupid}")
    public @ResponseBody String
    postCharactersheetToGroup(@PathVariable int charid, @PathVariable int groupid) {
        /*
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(charid);
        Group group = groupRepository.findGroupByID(groupid);

        group.setCharactersheets(charactersheet);

        charactersheet.setGroupID(groupid);
        charactersheetRepository.save(charactersheet);
        groupRepository.save(group);


         */
        return "Charactersheet added to Group";


    }



    @PostMapping(
            path = "/register"
            //consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    //@ResponseStatus(HttpStatus.OK)
    public @ResponseBody String postUser(@RequestBody Group group) {
        if(group!= null)
            groupRepository.save(group);

        return "Gruppe " + group.getName() + " wurde angelegt";
    }

}
