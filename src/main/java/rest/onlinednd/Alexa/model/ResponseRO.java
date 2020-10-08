package rest.onlinednd.Alexa.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ResponseRO
{
    protected final static String TYPENAME = "ResponseRO";

    @JsonProperty("outputSpeech")
    private rest.onlinednd.Alexa.model.OutputSpeechRO outputSpeech;
    @JsonProperty("shouldEndSession")
    private Boolean shouldEndSession;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public ResponseRO(OutputSpeechRO outputSpeechRO, boolean shouldEndSession)
    {
        super();
    }

    public ResponseRO(rest.onlinednd.Alexa.model.OutputSpeechRO outputSpeech, Boolean shouldEndSession)
    {
        super();
        this.outputSpeech = outputSpeech;
        this.shouldEndSession = shouldEndSession;
    }
    
    @JsonProperty("outputSpeech")
    public rest.onlinednd.Alexa.model.OutputSpeechRO getOutputSpeech() {
        return outputSpeech;
    }

    @JsonProperty("outputSpeech")
    public void setOutputSpeech(rest.onlinednd.Alexa.model.OutputSpeechRO outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    @JsonProperty("shouldEndSession")
    public Boolean getShouldEndSession() {
        return shouldEndSession;
    }

    @JsonProperty("shouldEndSession")
    public void setShouldEndSession(Boolean shouldEndSession) {
        this.shouldEndSession = shouldEndSession;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
