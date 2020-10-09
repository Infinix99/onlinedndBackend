package rest.onlinednd.MappingController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Alexa.model.AlexaRO;
import rest.onlinednd.Alexa.model.OutputSpeechRO;
import rest.onlinednd.Alexa.model.ResponseRO;
import rest.onlinednd.Alexa.model.SlotsRO;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Repositories.Charactersheet.CharactersheetRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/User/{id}/Group/{groupid}")
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

    //ALEXA GET___________________________________________
    @PostMapping
    public AlexaRO getGames(@RequestBody AlexaRO alexaRO, @PathVariable int id, @PathVariable int groupid) {
        //String Charactername = CharacterName.toString();
        String outText = "";

        if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest"))
        {
            outText = outText + " Launched ";
            prepareResponse(alexaRO, outText, false);

        }
        //GET CURRETN HP__________________________________________________________________________________________________________
        else {
            if (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("GetCurrentHealth"))) {
                try {
                    Object charname = alexaRO.getRequest().getIntent().getSlots().getAdditionalProperties().get("CharacterName");
                    Charactersheet charsheet = charactersheetRepository.findCharacterByName((String)charname);

                    //CharacterSheet in der Gruppe nach Charactername filtern/suchen //QUERY (?)
                    //outText = outText + "du hast aktuell " + //QueryFür "CurrentHitPoints" UNTER Life -> Hitpoints -> *Attribute* int currentHitPoints//  + "Hit Points";


                    } catch (Exception e) {
                    outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
                    }
            prepareResponse(alexaRO, outText, true);

        }}
        //GET **************__________________________________________________________________________________________________________
        /*else { // Weitere GETS

        }

         */
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
}


