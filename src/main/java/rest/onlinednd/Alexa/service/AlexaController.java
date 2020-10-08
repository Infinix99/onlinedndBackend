/*package rest.onlinednd.Alexa.service.AlexaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.onlinednd.Alexa.model.AlexaRO;
import rest.onlinednd.Alexa.model.OutputSpeechRO;
import rest.onlinednd.Alexa.model.ResponseRO;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/User/{id}/Group/{groupid}/Charactersheet")
public class AlexaController{


    @Autowired
    CharactersheetTESTRepository charactersheetTESTRepository;

    //GET Methoden___________________________________________________

    @GetMapping("/{charid}")
    public @ResponseBody
    Optional<CharactersheetTEST> getCharactersheet(@PathVariable int id, @PathVariable int groupid, @PathVariable int charid) {

        return charactersheetTESTRepository.findById(charid);
    }


    //POST Methoden_________________________________________________

    @PostMapping(path = "{id}/alexa/gamesbyID")
    public AlexaRO getGames(@RequestBody AlexaRO alexaRO, @PathVariable Integer id) {

        String outText = "";

        if (alexaRO.getRequest().getType().equalsIgnoreCase("LaunchRequest"))
        {
            outText = outText + "Willkommen bei UltimateTicTacToe Statistics ";
            prepareResponse(alexaRO, outText, false);
        }
        else {
            if (alexaRO.getRequest().getType().equalsIgnoreCase("IntentRequest") &&
                    (alexaRO.getRequest().getIntent().getName().equalsIgnoreCase("GamesCountIntent"))) {
                try {
                    outText = outText + "du hast aktuell " + userRepository.findNumberOfGames(id) + "Spiele gespielt";
                } catch (Exception e) {
                    outText = "Unser REST-Server hat leider aktuell Probleme. Bitte Versuch es später noch einmal ";
                }
                prepareResponse(alexaRO, outText, true);

            }
            else {
                //todo andere Statistik/intent einbauen
            }
        }

        return alexaRO;

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

 */



