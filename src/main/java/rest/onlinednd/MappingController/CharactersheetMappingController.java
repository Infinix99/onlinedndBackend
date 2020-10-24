package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.*;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;
import rest.onlinednd.Repositories.Charactersheet.*;
import rest.onlinednd.Repositories.GroupRepository;
import rest.onlinednd.Repositories.UserRepository;
import rest.onlinednd.ViewModels.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    EquippableRepository equippableRepository;
    @Autowired
    WearableRepository wearableRepository;
    @Autowired
    CarryableRepository carryableRepository;
    @Autowired
    StatsRepository statsRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    CharacterDescriptionRepository characterDescriptionRepository;
    @Autowired
    SavingThrowsRepository savingThrowsRepository;
    @Autowired
    TreasureRepository treasureRepository;
    @Autowired
    LifeRepository lifeRepository;
    @Autowired
    ArmorProficienciesRepository armorProficienciesRepository;
    @Autowired
    LanguageProficienciesRepository languageProficienciesRepository;
    @Autowired
    ToolProficienciesRepository toolProficienciesRepository;
    @Autowired
    WeaponProficienciesRepository weaponProficienciesRepository;


    //Charactersheet Methoden______________________________________________

    @CrossOrigin//(origins = "http://localhost:8080/")
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



    // POST CHARSHEET
    @CrossOrigin
    @PostMapping
    public @ResponseBody int
    postCharactersheet(@RequestBody CharactersheetViewModel charactersheetViewModel, @PathVariable int userid, @PathVariable int groupid) {
        Charactersheet charactersheet = new Charactersheet();

        int returnInt;
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

            Group group = groupRepository.findGroupByID(groupid);
            charactersheet.setGroup(group);




            User user = userRepository.findUserByID(userid);
            charactersheet.setUser(user);

            charactersheetRepository.save(charactersheet);

            returnInt = charactersheet.getCharactersheetID();
        }

        else {
            returnInt = -1; }

        return returnInt;
    }

    // PUT CHARSHEET
    @CrossOrigin
    @PutMapping(
            path = "{characterid}/update",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody int
    putCharactersheet(@RequestBody CharactersheetViewModel charactersheetViewModel, @PathVariable int userid, @PathVariable int characterid, @PathVariable int groupid) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        int returnInt;
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

            Group group = groupRepository.findGroupByID(groupid);
            charactersheet.setGroup(group);


            charactersheetRepository.save(charactersheet);

            returnInt = charactersheet.getCharactersheetID();
        }
        else {
            returnInt = -1;
        }

        return returnInt;
    }

    // ADD CHARACTERSHEET TO A GROUP VIA GROUP ID
    @PutMapping("/{characterid}/addToGroup")
    public @ResponseBody String
    putCharacterSheetToGroup(@PathVariable int characterid, @PathVariable int groupid) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        Group group = groupRepository.findGroupByID(groupid);
        charactersheet.setGroup(group);


        charactersheetRepository.save(charactersheet);

        return "Charactersheet "+charactersheet.getCharacterName()+" has been added to Group " +group.getName();

    }

    // REMOVE FROM GROUP
    @PutMapping("/{characterid}/removeFromGroup")
    public @ResponseBody String
    removeCharFromGroup(@PathVariable int characterid, @PathVariable int groupid) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        Group group = groupRepository.findGroupByID(1);
        charactersheet.setGroup(group);
        charactersheetRepository.save(charactersheet);

        return "Charactersheet " +charactersheet.getCharacterName()+" has been removed from the Group";
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



    //PUT Methoden__________________________________________________

    //PUT ON DIFFRENT ENDPOINTS

    @PutMapping(
            path = "/{characterid}/stats",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putStats(@PathVariable int characterid, @RequestBody Stats stats) {
        if(stats != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            Stats originalStats = charactersheet.getStats();
            charactersheet.setStats(stats);
            charactersheetRepository.save(charactersheet);
            statsRepository.delete(originalStats);
        }
    }


    @PutMapping(
            path = "/{characterid}/skills",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSkills(@PathVariable int characterid, @RequestBody Skills skills) {
        if(skills != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            Skills originalSkills = charactersheet.getSkills();
            charactersheet.setSkills(skills);
            charactersheetRepository.save(charactersheet);
            skillsRepository.delete(originalSkills);
        }
    }


    @PutMapping(
            path = "/{characterid}/characterdescription",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putCharacterDescription(@PathVariable int characterid, @RequestBody CharacterDescription characterDescription) {
        if(characterDescription != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            CharacterDescription original = charactersheet.getCharacterDescription();
            charactersheet.setCharacterDescription(characterDescription);
            charactersheetRepository.save(charactersheet);
            characterDescriptionRepository.delete(original);
        }
    }



    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/savingthrows",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSavingThrows(@PathVariable int characterid, @RequestBody SavingThrows savingThrows) {
        if(savingThrows != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            SavingThrows original = charactersheet.getSavingThrows();
            charactersheet.setSavingThrows(savingThrows);
            charactersheetRepository.save(charactersheet);
            savingThrowsRepository.delete(original);
        }
    }


    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/treasure",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putTreasure(@PathVariable int characterid, @RequestBody Treasure treasure){
        if(treasure != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            Treasure original = charactersheet.getTreasure();
            charactersheet.setTreasure(treasure);
            charactersheetRepository.save(charactersheet);
            treasureRepository.delete(original);
        }
    }

    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/life",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLife(@PathVariable int characterid, @RequestBody Life life) {
        if(life != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            Life original = charactersheet.getLife();
            charactersheet.setLife(life);
            charactersheetRepository.save(charactersheet);
            lifeRepository.delete(original);
        }
    }

    @PutMapping(
            path = "/{characterid}/armorproficiencies",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putArmorProf(@PathVariable int characterid, @RequestBody ArmorProficiencies armorProficiencies){
        if(armorProficiencies != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            ArmorProficiencies original = charactersheet.getArmorProficiencies();
            charactersheet.setArmorProficiencies(armorProficiencies);
            charactersheetRepository.save(charactersheet);
            armorProficienciesRepository.delete(original);
        }
    }

    @PutMapping(
            path = "/{characterid}/languageproficiencies",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLanguageProf(@PathVariable int characterid, @RequestBody LanguageProficiencies languageProficiencies){
        if(languageProficiencies != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            LanguageProficiencies original = charactersheet.getLanguageProficiencies();
            charactersheet.setLanguageProficiencies(languageProficiencies);
            charactersheetRepository.save(charactersheet);
            languageProficienciesRepository.delete(original);
        }
    }

    @PutMapping(
            path = "/{characterid}/toolproficiencies",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putToolProf(@PathVariable int characterid, @RequestBody ToolProficiencies toolProficiencies){
        if(toolProficiencies != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            ToolProficiencies original = charactersheet.getToolProficiencies();
            charactersheet.setToolProficiencies(toolProficiencies);
            charactersheetRepository.save(charactersheet);
            toolProficienciesRepository.delete(original);
        }
    }

    @PutMapping(
            path = "/{characterid}/weaponproficiencies",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putWeaponProf(@PathVariable int characterid, @RequestBody WeaponProficiencies weaponProficiencies){
        if(weaponProficiencies != null) {
            Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
            WeaponProficiencies original = charactersheet.getWeaponProficiencies();
            charactersheet.setWeaponProficiencies(weaponProficiencies);
            charactersheetRepository.save(charactersheet);
            weaponProficienciesRepository.delete(original);
        }
    }



    //PUT ON charactersheet Table_________________________________________________

    @PutMapping(
            path = "/{characterid}/initative",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInitiative(@PathVariable int characterid, @RequestBody int initative) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setInitiative(initative);
        charactersheetRepository.save(charactersheet);

    }


    @PutMapping(
            path = "/{characterid}/inspiration",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInspiration(@PathVariable int characterid, @RequestBody int inspiration) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setInspiration(inspiration);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/level",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLevel(@PathVariable int characterid, @RequestBody int level) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setLevel(level);
        charactersheetRepository.save(charactersheet);

    }

    @PutMapping(
            path = "/{characterid}/proficiencybonus",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putProficiencyBonus(@PathVariable int characterid, @RequestBody int proficiencybonus) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setProficiencyBonus(proficiencybonus);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/visibility",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putVisibility(@PathVariable int characterid, @RequestBody boolean visibility) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setSheetIsVisible(visibility);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/speed",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSpeed(@PathVariable int characterid, @RequestBody int speed) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setSpeed(speed);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/passiveperception",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putPassivePerception(@PathVariable int characterid, @RequestBody int passiveperception) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setPassivePerception(passiveperception);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/charactername",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putCharacterName(@PathVariable int characterid, @RequestBody String charactername) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setCharacterName(charactername);
        charactersheetRepository.save(charactersheet);
    }

    @PutMapping(
            path = "/{characterid}/armorclass",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putArmorClass(@PathVariable int characterid, @RequestBody int armorclass) {
        Charactersheet charactersheet = charactersheetRepository.findCharactersheetByID(characterid);
        charactersheet.setArmorClass(armorclass);
        charactersheetRepository.save(charactersheet);
    }




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

    @CrossOrigin
    @PostMapping(
            path = "/{characterid}/notes",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public @ResponseBody String
    postNote(@RequestBody NotesViewModel notesViewModel, @PathVariable int characterid){
        String returnString;
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

    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/notes/{notesid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void
    putNote(@RequestBody NotesViewModel notesViewModel, @PathVariable int characterid, @PathVariable int notesid){
        Notes notes = notesRepository.findNoteByIds(characterid, notesid);
        notes.setNote(notesViewModel.getNote());
        notesRepository.save(notes);
    }

    @CrossOrigin
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


    //EQUIPPABLE______________________________________________________________________________________

    @GetMapping("/{characterid}/equippable/all")
    public @ResponseBody Set<Equippable>
    getEquippablesfromCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid){

        return equippableRepository.findAllEquippablesFromSheet(characterid);
    }

    @CrossOrigin
    @PostMapping(
            path = "/{characterid}/equippable"
    )
    public @ResponseBody String
    postEquippable(@RequestBody EquippableViewModel equippableViewModel, @PathVariable int characterid){
        String returnString;
        if(equippableViewModel != null || characterid != 0) {
            Equippable equippable = new Equippable();
            equippable.setEquippable(equippableViewModel.getEquippable());
            equippable.setDetails(equippableViewModel.getDetails());
            equippable.setAttackBonus(equippableViewModel.getAttackBonus());
            equippable.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            equippableRepository.save(equippable);
            returnString = "Equippable was saved.";
        }
        else
            returnString = "No equippable to save.";
        return returnString;
    }

    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/equippable/{equippableid}"
    )
    public void
    putEquippable(@RequestBody EquippableViewModel equippableViewModel, @PathVariable int characterid, @PathVariable int equippableid){
        Equippable equippable = equippableRepository.findEquippableByIds(characterid, equippableid);
        equippable.setEquippable(equippableViewModel.getEquippable());
        equippableRepository.save(equippable);
    }

    @CrossOrigin
    @DeleteMapping(
            path = "/{characterid}/equippable/{equippableid}/delete"
    )
    public @ResponseBody String
    deleteEquippable(@PathVariable int characterid, @PathVariable int equippableid){
        Equippable equippable = equippableRepository.findEquippableByIds(characterid, equippableid);
        equippable.setCharactersheet(null);
        equippableRepository.delete(equippable);
        return "Equippable was deleted";
    }





    //WEARABLE_____________________________________________________________________________________________________________
    @GetMapping("/{characterid}/wearable/all")
    public @ResponseBody Set<Wearable>
    getWearablesfromCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid){

        return wearableRepository.findAllWearableFromSheet(characterid);
    }

    @CrossOrigin
    @PostMapping(
            path = "/{characterid}/wearable"
    )
    public @ResponseBody String
    postWearable(@RequestBody WearableViewModel wearableViewModel, @PathVariable int characterid){
        String returnString;
        if(wearableViewModel != null || characterid != 0) {
            Wearable wearable = new Wearable();
            wearable.setWearable(wearableViewModel.getWearable());
            wearable.setDetails(wearableViewModel.getDetails());
            wearable.setArmorClass(wearableViewModel.getArmorClass());
            wearable.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            wearableRepository.save(wearable);
            returnString = "Wearable was saved.";
        }
        else
            returnString = "No wearable to save.";
        return returnString;
    }

    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/wearable/{wearableid}"
    )
    public void
    putWearable(@RequestBody WearableViewModel wearableViewModel, @PathVariable int characterid, @PathVariable int wearableid){
        Wearable wearable = wearableRepository.findWearableByIds(characterid, wearableid);
        wearable.setWearable(wearableViewModel.getWearable());
        wearableRepository.save(wearable);
    }

    @CrossOrigin
    @DeleteMapping(
            path = "/{characterid}/wearable/{wearableid}/delete"
    )
    public @ResponseBody String
    deleteWearable(@PathVariable int characterid, @PathVariable int wearableid){
        Wearable wearable = wearableRepository.findWearableByIds(characterid, wearableid);
        wearable.setCharactersheet(null);
        wearableRepository.delete(wearable);
        return "Wearable was deleted";
    }





    //Carryable_________________________________________________________________________________
    @GetMapping("/{characterid}/carryable/all")
    public @ResponseBody Set<Carryable>
    getCarryablesfromCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid){

        return carryableRepository.findAllCarryablesFromSheet(characterid);
    }

    @CrossOrigin
    @PostMapping(
            path = "/{characterid}/carryable"
    )
    public @ResponseBody String
    postCarryable(@RequestBody CarryableViewModel carryableViewModel, @PathVariable int characterid){
        String returnString;
        if(carryableViewModel != null || characterid != 0) {
            Carryable carryable = new Carryable();
            carryable.setCarryable(carryableViewModel.getCarryable());
            carryable.setAmount(carryableViewModel.getAmount());
            carryable.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            carryableRepository.save(carryable);
            returnString = "Carryable was saved.";
        }
        else
            returnString = "No carryable to save.";
        return returnString;
    }

    @CrossOrigin
    @PutMapping(
            path = "/{characterid}/carryable/{carryableid}"
    )
    public void
    putCarryable(@RequestBody CarryableViewModel carryableViewModel, @PathVariable int characterid, @PathVariable int carryableid){
        Carryable carryable = carryableRepository.findACarryableByIds(characterid, carryableid);
        carryable.setCarryable(carryableViewModel.getCarryable());
        carryable.setAmount(carryableViewModel.getAmount());
        carryableRepository.save(carryable);
    }

    @CrossOrigin
    @DeleteMapping(
            path = "/{characterid}/carryable/{carryableid}/delete"
    )
    public @ResponseBody String
    deleteCarryable(@PathVariable int characterid, @PathVariable int carryableid){
        Carryable carryable = carryableRepository.findACarryableByIds(characterid, carryableid);
        carryable.setCharactersheet(null);
        carryableRepository.delete(carryable);
        return "Wearable was deleted";
    }
}
