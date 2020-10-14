package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;
import rest.onlinednd.Repositories.UserRepository;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/User")
public class UserMappingController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired
    private CharactersheetRepository charactersheetRepository;


    @GetMapping("/{id}")
    public @ResponseBody
    Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

/*
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the useCharactersheetsrRepository.findAll();
    }

 */

//CHARACTERSHEET USER GETS (GRUPPENUNABHÄNGIG)____________________________________________
    @GetMapping("/{userid}/Charactersheets/all")
    public @ResponseBody
    Set<Charactersheet> getAllCharactersheets(@PathVariable int userid ) {
        if(userid != 0)
            return charactersheetRepository.findAllCharactersheets(userid);
        else
            return null;
    }

    @GetMapping("/{userid}/Charactersheets/{characterid}")
    public @ResponseBody
    Charactersheet getAllCharactersheets(@PathVariable int userid , @PathVariable int characterid) {
        if(userid != 0 && characterid != 0 )
            return charactersheetRepository.findCharactersheetByID(characterid);
        else
            return null;
    }

//________________________________________________________________________________________

    //TODO:
    // CREATE USER
    // DELETE USER
    // MANAGE USER

    @PostMapping(
            path = "/register"
            //consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    //@ResponseStatus(HttpStatus.OK)
    public @ResponseBody String postUser(@RequestBody User user) {
        if(user != null)
            userRepository.save(user);

        return "Account " + user.getName() + " wurde angelegt";
    }



//    @PostMapping(
//            path = "/login",
//            consumes = {MediaType.APPLICATION_JSON_VALUE}
//    )
//    @ResponseStatus(HttpStatus.OK)
//    public int loginUser() {
//        int localID = 0;
//
//
//        return localID;
//    }
//
//    @PutMapping(
//            path = "/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE}
//    )
//    @ResponseStatus(HttpStatus.OK)
//    public String updateUserEmail(@PathVariable int id) {
//
//        return "Account Email wurde geändert.";
//    }
//
//    @PutMapping(
//            path = "/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE}
//    )
//    @ResponseStatus(HttpStatus.OK)
//    public String updateUserPassword(@PathVariable int id) {
//
//        return "Account Passwort wurde geändert.";
//    }
//
//    @DeleteMapping(
//            path = ("/{id}")
//    )
//    public String deleteUser(@PathVariable int id) {
//        return "Account wurde gelöscht";
//    }
}