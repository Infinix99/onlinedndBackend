package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;
import rest.onlinednd.Repositories.Charactersheet.NotesRepository;
import rest.onlinednd.Repositories.GroupRepository;
import rest.onlinednd.Repositories.UserRepository;
import rest.onlinednd.ViewModels.CharactersheetViewModel;
import rest.onlinednd.ViewModels.NotesViewModel;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/User/{userid}/Group/{groupid}/Charactersheet")
public class CharactersheetMappingController {


    @Autowired
    CharactersheetRepository charactersheetRepository;
    @Autowired
    NotesRepository notesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;


    //Charactersheet Methoden______________________________________________

    @GetMapping("/{characterid}")
    public @ResponseBody Charactersheet
    getCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid) {
        if(characterid != 0)
            return charactersheetRepository.findCharactersheetByID(characterid);
        else
            return null;
    }

    @GetMapping ("/GroupCharactersheets")
    public @ResponseBody
    Set<Charactersheet> getGroupCharactersheets (@PathVariable int groupid) {
    Set<Charactersheet> chars = charactersheetRepository.findAllCharsFromGroup(groupid);
            return chars;

    }

    @PostMapping
    public @ResponseBody String
    postCharactersheet(@RequestBody CharactersheetViewModel charactersheetViewModel, @PathVariable int userid, @PathVariable int groupid) {
        Charactersheet charactersheet = new Charactersheet();

        String returnString;
        if(charactersheetViewModel != null) {
            charactersheet.setLevel(charactersheetViewModel.getLevel());
            charactersheet.setArmorClass(charactersheetViewModel.getArmorClass());
            charactersheet.setCharacterName(charactersheetViewModel.getCharacterName());
            charactersheet.setInitiative(charactersheetViewModel.getInitiative());
            charactersheet.setPassivePerception(charactersheetViewModel.getPassivePerception());
            charactersheet.setProficiencyBonus(charactersheetViewModel.getProficiencyBonus());
            charactersheet.setSpeed(charactersheetViewModel.getSpeed());
            charactersheet.setSheetIsVisible(charactersheetViewModel.isSheetIsVisible());
            charactersheet.setRace(charactersheetViewModel.getRace());
            charactersheet.setCombatClass(charactersheetViewModel.getCombatClass());
            charactersheet.setStats(charactersheetViewModel.getStats());
            charactersheet.setSkills(charactersheetViewModel.getSkills());
            charactersheet.setLife(charactersheetViewModel.getLife());
            charactersheet.setTreasure(charactersheetViewModel.getTreasure());
            charactersheet.setCharacterDescription(charactersheetViewModel.getCharacterDescription());
            charactersheet.setArmorProficiencies(charactersheetViewModel.getArmorProficiencies());
            charactersheet.setLanguageProficiencies(charactersheetViewModel.getLanguageProficiencies());
            charactersheet.setToolProficiencies(charactersheetViewModel.getToolProficiencies());
            charactersheet.setWeaponProficiencies(charactersheetViewModel.getWeaponProficiencies());
            charactersheet.setSavingThrows(charactersheetViewModel.getSavingThrows());
            charactersheet.setNotes(charactersheetViewModel.getNotes());


            charactersheet.setGroupID(1);


            User user = userRepository.findUserByID(userid);
            charactersheet.setUser(user);

            charactersheetRepository.save(charactersheet);

            returnString ="Charakterbogen erstellt";
        }

        else {
            returnString = "Nichts gespeichert!"; }

        return returnString;
    }

    // ADD CHARACTERSHEET TO A GROUP VIA GROUP ID
    @PutMapping("/{characterid}/addToGroup")
    public @ResponseBody String
    putCharacterSheetToGroup(@PathVariable int characterid, @PathVariable int groupid) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setGroupID(groupid);

        Group group = groupRepository.findGroupByID(groupid);

        charactersheetRepository.save(charactersheet);

        return "Charactersheet "+charactersheet.getCharacterName()+" has been added to Group " +group.getName();

    }
/*
    @PutMapping("/{characterid}/addToGroup")
    public @ResponseBody String
    postCharactersheetToGroup(@PathVariable int characterid, @PathVariable int groupid) {

        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        Group group = groupRepository.findGroupByID(groupid);

        Set<Charactersheet> charactersheetSet = new HashSet<Charactersheet>();
        charactersheetSet.add(charactersheet);
        group.setCharactersheets(charactersheetSet);

        Set<Group> groupSet = new HashSet<Group>();


        charactersheet.setGroupID(groupid);

        charactersheetRepository.save(charactersheet);
        groupRepository.save(group);


        return "Charactersheet " + charactersheet.getCharacterName()+ " added to Group" + group.getName();



    }

 */


/*
    //PUT Methoden__________________________________________________

    //PUT ON DIFFRENT ENDPOINTS

    @PutMapping(
            path = "/{characterid}/stats",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putStats(@PathVariable int charid, @RequestBody int strength) {


    }


    @PutMapping(
            path = "/{characterid}/skills",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSkills(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/CharacterDescription",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putCharacterDescription(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/Equipment",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putEquipment(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/Savingthrows",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSavingThrows(@PathVariable int charid) {

    }


    @PutMapping(
            path = "/{characterid}/Treasure",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putTreasure(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/FeaturesAndTraits",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putFeaturesAndTraits(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/Life",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLife(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}/Groups",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putGroups(@PathVariable int charid) {

    }

    */



/*
    //PUT ON characterid ENDPOINT_________________________________________________

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInitiative(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putDefenses(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInspiration(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLevel(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putDeathSaves(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{characterid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putVisibility(@PathVariable int charid) {

    }


 */

    //__________Notes___________\\

    @GetMapping("/{characterid}/notes/all")
    public @ResponseBody Set<Notes>
    getNotesfromCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid){

        return notesRepository.findAllNotesFromSheet(characterid);
    }

    @GetMapping("/notes/{notesid}")
    public @ResponseBody Optional<Notes>
    getANoteFromCharactersheet(@PathVariable int notesid){

        return notesRepository.findById(notesid);
    }


    @PostMapping(
            path = "/{characterid}/notes"
    )
    public @ResponseBody String
    postNote(@RequestBody NotesViewModel notesViewModel, @PathVariable int characterid){
        String returnString = "Test";
        if(notesViewModel != null || characterid != 0) {
            Notes notes = new Notes();
            notes.setNote(notesViewModel.getNote());
            notes.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            notesRepository.save(notes);
            returnString = "Note was saved.";
        }
        else
            returnString = "No note to save.";
        return returnString;
    }

    @PutMapping(
            path = "/{characterid}/notes/{notesid}"
    )
    public void
    putNote(@RequestBody NotesViewModel notesViewModel, @PathVariable int characterid, @PathVariable int notesid){
        Notes notes = notesRepository.findNoteByIds(characterid, notesid);
        notes.setNote(notesViewModel.getNote());
        notesRepository.save(notes);
    }

    @DeleteMapping(
            path = "/{characterid}/notes/{notesid}/delete"
    )
    public @ResponseBody String
    deleteNote(@PathVariable int characterid, @PathVariable int notesid){
        Notes notes = notesRepository.findNoteByIds(characterid, notesid);
        notes.setCharactersheet(null);
        notesRepository.delete(notes);
        return "Note was deleted";
    }

}
