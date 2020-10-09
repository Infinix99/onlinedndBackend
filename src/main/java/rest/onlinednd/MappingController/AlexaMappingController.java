package rest.onlinednd.MappingController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Alexa.model.AlexaRO;
import rest.onlinednd.Alexa.model.OutputSpeechRO;
import rest.onlinednd.Alexa.model.ResponseRO;
import rest.onlinednd.Alexa.model.SlotsRO;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;

import java.util.HashMap;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1.0/User/{id}/Group/{groupid}/Charactersheet")
public class AlexaMappingController {

    @Autowired
    CharactersheetRepository charactersheetRepository;
    /*
    @GetMapping("/{groupid}")
    public @ResponseBody
    Optional<Charactersheet> getCharactersheet(@PathVariable int id, @PathVariable int groupid, @PathVariable int charid) {

        return charactersheetRepository.findById(charid);
    }
*/

    //ALEXA Methoden___________________________________________

    @PostMapping("/{charid}")
    public AlexaRO getHitPoints(@RequestBody AlexaRO alexaRO, @PathVariable int id, @PathVariable int groupid, @PathVariable int charid) {
        String outText = "";

        if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest"))
        {
            outText = outText + " Launched! ";
            prepareResponse(alexaRO, outText, false);

        }
        //GET CURRENT HP__________________________________________________________________________________________________________
        else if
             (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("GetCurrentHealth"))) {
                try {
                    String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");  //Erklärung notwendig lma-fucking-o
                    Charactersheet charsheet = charactersheetRepository.findCharacterByName(charname);

                    outText = (String) charname + "has" + charsheet.getLife().getCurrentHitPoints() + "!";

                    } catch (Exception e) {
                    outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
                    }
            prepareResponse(alexaRO, outText, true);

        }


        //Recover CurrentHealth__________________________________________________________________________________________________________
         else if
            (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                    (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("RecoverCurrentHealthPoints"))) {
                try {
                    String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");
                    int regain = ((HashMap<Integer ,Integer>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("regain"))).get("value");


                    Charactersheet charsheet = charactersheetRepository.findCharacterByName(charname);

                        if(charsheet.getLife().getCurrentHitPoints() + regain > charsheet.getLife().getMaximumHitPoints())
                            charsheet.getLife().setCurrentHitPoints(charsheet.getLife().getMaximumHitPoints());
                        else {

                            charsheet.getLife().setCurrentHitPoints(charsheet.getLife().getCurrentHitPoints() + regain);
                        }

                        outText = (String) charname + " current Health Points are now set at " + charsheet.getLife().getCurrentHitPoints();


                } catch (Exception e) {
                    outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
                }
                prepareResponse(alexaRO, outText, true);

            }




        //Remove CurrentHealth__________________________________________________________________________________________________________
        else if
        (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                        (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("RemoveCurrentHealthPoints"))) {
            try {
                String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");
                int damage = ((HashMap<Integer ,Integer>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("damage"))).get("value");

                Charactersheet charsheet = charactersheetRepository.findCharacterByName(charname);

                    if(charsheet.getLife().getCurrentHitPoints() - damage < 0)
                        charsheet.getLife().setCurrentHitPoints(0);
                    else {

                        charsheet.getLife().setCurrentHitPoints(charsheet.getLife().getCurrentHitPoints() - damage);
                    }

                outText = (String) charname + " current Health Points are now set at " + charsheet.getLife().getCurrentHitPoints();



            } catch (Exception e) {
                outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
            }
            prepareResponse(alexaRO, outText, true);

        }



        //Set CurrentHealth__________________________________________________________________________________________________________
        else if
        (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                        (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("SetCurrentHealthPoints"))) {
            try {
                String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");
                int healthpoints = ((HashMap<Integer ,Integer>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("hitpoints"))).get("value");

                Charactersheet charsheet = charactersheetRepository.findCharacterByName((String) charname);


                int maxHitpoints = charsheet.getLife().getMaximumHitPoints();

                if(  (healthpoints > maxHitpoints)  || healthpoints < 0)

                    outText = "ERROR: New Current Health Points are either above your Max-HP or under 0";
                else {

                    charsheet.getLife().setCurrentHitPoints(healthpoints);
                }

                outText = (String) charname + " current Health Points are now set at " + charsheet.getLife().getCurrentHitPoints();


            } catch (Exception e) {
                outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
            }
            prepareResponse(alexaRO, outText, true);

        }

        //Kill Player__________________________________________________________________________________________________________
        else if
        (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                        (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("KillPlayer"))) {
            try {
                String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");

                Charactersheet charsheet = charactersheetRepository.findCharacterByName((String) charname);

                charsheet.getLife().setCurrentHitPoints(0);
                outText = charname + " is now at 0 HP..... " + charname + " may be dead!";



            } catch (Exception e) {
                outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
            }
            prepareResponse(alexaRO, outText, true);

        }


        //Max Player__________________________________________________________________________________________________________
        else if
        (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                        (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("MaxHealth"))) {
            try {
                String charname = ((HashMap<String ,String>)(alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName"))).get("value");

                Charactersheet charsheet = charactersheetRepository.findCharacterByName((String) charname);

                charsheet.getLife().setCurrentHitPoints(charsheet.getLife().getMaximumHitPoints());
                outText = charname + " is now at FULL HP! -> " + charsheet.getLife().getCurrentHitPoints();



            } catch (Exception e) {
                outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
            }
            prepareResponse(alexaRO, outText, true);

        }

        return alexaRO;


    }



    //_____________________________________________________________________________________________

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




}


