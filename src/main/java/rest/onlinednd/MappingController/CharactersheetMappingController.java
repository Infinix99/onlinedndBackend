package rest.onlinednd.MappingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Alexa.model.AlexaRO;
import rest.onlinednd.Alexa.model.OutputSpeechRO;
import rest.onlinednd.Alexa.model.ResponseRO;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Skills;
import rest.onlinednd.Entities.Charactersheet.Stats;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;
import rest.onlinednd.ViewModels.CharactersheetViewModel;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/User/{id}/Group/{groupid}/Charactersheet")
public class CharactersheetMappingController {


    @Autowired
    CharactersheetRepository charactersheetRepository;

    //GET Methoden___________________________________________________

    @GetMapping("/{charid}")
    public @ResponseBody
    Optional<Charactersheet> getCharactersheet(@PathVariable int id, @PathVariable int groupid, @PathVariable int charid) {

        return charactersheetRepository.findById(charid);
    }


    //POST Methoden_________________________________________________

    @PostMapping(

    )
    public @ResponseBody String postCharactersheet(@RequestBody CharactersheetViewModel charactersheetViewModel) {
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
            charactersheet.setStats(charactersheetViewModel.getStats());
            charactersheet.setSkills(charactersheetViewModel.getSkills());
            //HitPoints
//
//            switch (charactersheetViewModel.race) {
//                case 0:
//                    charactersheet.setRace(new Dwarf());
//            }
//            for (SkillsModel s : charactersheetViewModel.skillsModel) {
//                switch (s) {
//                    case athletics:
//                        charactersheet.getSkills().getStrengthSkills().setAthletics_prof(true);
//                    case deception:
//                        charactersheet.getSkills().getCharismaSkills().setDeception_prof(true);
//                }
//            }
//            switch (charactersheetViewModel.aclass) {
//                case 0:
//                    charactersheet.setaClass(new Fighter());
//            }
//            charactersheet.setLevel(charactersheetViewModel.level);



            charactersheetRepository.save(charactersheet);
            returnString ="Charakterbogen erstellt";
        }

        else
            returnString = "Nichts gespeichert!";






        return returnString;
    }



    //PUT Methoden__________________________________________________



                //PreBuild - Alexa
                @PostMapping("/{charid}")
                    public AlexaRO getGames(@RequestBody AlexaRO alexaRO, @PathVariable int id, @PathVariable int groupid, @PathVariable int charid) {

                        String outText = "";

                        /*if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest"))
                            {
                            outText = outText + " ";
                                prepareResponse(alexaRO, outText, false);
                            }
                            else {

                         */
                            if (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                                    (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("GetCurrentHitPoints"))) {
                                try {
                                    // outText = outText + "du hast aktuell " + charactersheetRepository.findAllById(charid) + "Hit Points";   GETTER HITPOINTS
                                } catch (Exception e) {
                                    outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
                                }
                                prepareResponse(alexaRO, outText, true);

                            }
                            else { // Weitere GETS

                            }
                        return alexaRO;
                    }
                    private AlexaRO prepareResponse(AlexaRO alexaRO, String outText, boolean shouldEndSession) {

                        alexaRO.setRequest(null);
                        alexaRO.setSession(null);
                        alexaRO.setContext(null);
                        OutputSpeechRO outputSpeechRO = new OutputSpeechRO();
                        outputSpeechRO.setType("PlainText");
                        outputSpeechRO.setText(outText);
                        ResponseRO response = new ResponseRO(outputSpeechRO, shouldEndSession);
                        alexaRO.setResponse(response);
                        return alexaRO;
                    }




/*
    @PutMapping(
            path = "/{charid}/skills",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSkills(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Background",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putBackground(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/CharacterDescription",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putCharacterDescription(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Class",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putClass(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Equipment",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putEquipment(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Race",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putRace(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Savingthrows",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putSavingThrows(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/OtherProficienciesAndLanguages",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putOtherProficienciesAndLanguages(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Treasure",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putTreasure(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/FeaturesAndTraits",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putFeaturesAndTraits(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Life",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLife(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/ExperiencePoints",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putExperiencePoints(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}/Groups",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putGroups(@PathVariable int charid) {

    }


    //PUT ON CHARID ENDPOINT_________________________________________________

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInitiative(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putDefenses(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putInspiration(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putLevel(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putDeathSaves(@PathVariable int charid) {

    }

    @PutMapping(
            path = "/{charid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void putVisibility(@PathVariable int charid) {

    }


 */

}
