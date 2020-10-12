package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.GroupRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/User/{userid}/Group")
public class GroupMappingController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping ("/{groupid}")
    public @ResponseBody
    Group getGroup (@PathVariable int groupid , @PathVariable int userid) {
        return groupRepository.findGroupByID(groupid);
    }







    //_____________________________________________________________
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
