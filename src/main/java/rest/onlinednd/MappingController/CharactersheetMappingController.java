package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Entities.Charactersheet.*;
import rest.onlinednd.Repositories.Charactersheet.*;
import rest.onlinednd.ViewModels.*;

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
    EquippableRepository equippableRepository;
    @Autowired
    WearableRepository wearableRepository;
    @Autowired
    CarryableRepository carryableRepository;


    //Charactersheet Methoden______________________________________________

    @GetMapping("/{characterid}")
    public @ResponseBody Charactersheet
    getCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid) {
        if(characterid != 0)
            return charactersheetRepository.findCharactersheetByID(characterid);
        else
            return null;
    }

    @PostMapping
    public @ResponseBody String
    postCharactersheet(@RequestBody CharactersheetViewModel charactersheetViewModel) {
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
            charactersheet.setGroupID(charactersheetViewModel.getGroupID());
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


            charactersheetRepository.save(charactersheet);
            returnString ="Charakterbogen erstellt";
        }

        else
            returnString = "Nichts gespeichert!";

        return returnString;
    }





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


    //EQUIPPABLE______________________________________________________________________________________

    @GetMapping("/{characterid}/equippable/all")
    public @ResponseBody Set<Equippable>
    getEquippablesfromCharactersheet(@PathVariable int userid, @PathVariable int groupid, @PathVariable int characterid){

        return equippableRepository.findAllEquippablesFromSheet(characterid);
    }

    @PostMapping(
            path = "/{characterid}/equippable"
    )
    public @ResponseBody String
    postEquippable(@RequestBody EquippableViewModel equippableViewModel, @PathVariable int characterid){
        String returnString;
        if(equippableViewModel != null || characterid != 0) {
            Equippable equippable = new Equippable();
            equippable.setEquippable(equippableViewModel.getEquippable());
            equippable.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            equippableRepository.save(equippable);
            returnString = "Equippable was saved.";
        }
        else
            returnString = "No equippable to save.";
        return returnString;
    }

    @PutMapping(
            path = "/{characterid}/equippable/{equippableid}"
    )
    public void
    putEquippable(@RequestBody EquippableViewModel equippableViewModel, @PathVariable int characterid, @PathVariable int equippableid){
        Equippable equippable = equippableRepository.findEquippableByIds(characterid, equippableid);
        equippable.setEquippable(equippableViewModel.getEquippable());
        equippableRepository.save(equippable);
    }

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

    @PostMapping(
            path = "/{characterid}/wearable"
    )
    public @ResponseBody String
    postWearable(@RequestBody WearableViewModel wearableViewModel, @PathVariable int characterid){
        String returnString;
        if(wearableViewModel != null || characterid != 0) {
            Wearable wearable = new Wearable();
            wearable.setWearable(wearableViewModel.getWearable());
            wearable.setCharactersheet(charactersheetRepository.findCharactersheetByID(characterid));
            wearableRepository.save(wearable);
            returnString = "Wearable was saved.";
        }
        else
            returnString = "No wearable to save.";
        return returnString;
    }

    @PutMapping(
            path = "/{characterid}/wearable/{wearableid}"
    )
    public void
    putWearable(@RequestBody WearableViewModel wearableViewModel, @PathVariable int characterid, @PathVariable int wearableid){
        Wearable wearable = wearableRepository.findWearableByIds(characterid, wearableid);
        wearable.setWearable(wearableViewModel.getWearable());
        wearableRepository.save(wearable);
    }

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
