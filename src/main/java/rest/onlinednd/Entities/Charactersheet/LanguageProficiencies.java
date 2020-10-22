package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LanguageProficiencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer languageProfID;

    private boolean CelestialAbyssal;
    private boolean Celestial;
    private boolean Common;
    private boolean DeepSpeech;
    private boolean Draconic;
    private boolean Dwarvish;
    private boolean Elvish;
    private boolean Giant; //___
    private boolean Gnomish;
    private boolean Goblin;
    private boolean Halfling;
    private boolean Infernal;
    private boolean Orc;
    private boolean Primordial;
    private boolean Sylvan;
    private boolean Undercommon;        //16

    public LanguageProficiencies( ) { }


    //__________________________________________________________________

    public boolean isCelestialAbyssal() {
        return CelestialAbyssal;
    }

    public void setCelestialAbyssal(boolean celestialAbyssal) {
        CelestialAbyssal = celestialAbyssal;
    }

    public boolean isCelestial() {
        return Celestial;
    }

    public void setCelestial(boolean celestial) {
        Celestial = celestial;
    }

    public boolean isCommon() {
        return Common;
    }

    public void setCommon(boolean common) {
        Common = common;
    }

    public boolean isDeepSpeech() {
        return DeepSpeech;
    }

    public void setDeepSpeech(boolean deepSpeech) {
        DeepSpeech = deepSpeech;
    }

    public boolean isDraconic() {
        return Draconic;
    }

    public void setDraconic(boolean draconic) {
        Draconic = draconic;
    }

    public boolean isDwarvish() {
        return Dwarvish;
    }

    public void setDwarvish(boolean dwarvish) {
        Dwarvish = dwarvish;
    }

    public boolean isElvish() {
        return Elvish;
    }

    public void setElvish(boolean elvish) {
        Elvish = elvish;
    }

    public boolean isGiant() {
        return Giant;
    }

    public void setGiant(boolean giant) {
        Giant = giant;
    }

    public boolean isGnomish() {
        return Gnomish;
    }

    public void setGnomish(boolean gnomish) {
        Gnomish = gnomish;
    }

    public boolean isGoblin() {
        return Goblin;
    }

    public void setGoblin(boolean goblin) {
        Goblin = goblin;
    }

    public boolean isHalfling() {
        return Halfling;
    }

    public void setHalfling(boolean halfling) {
        Halfling = halfling;
    }

    public boolean isInfernal() {
        return Infernal;
    }

    public void setInfernal(boolean infernal) {
        Infernal = infernal;
    }

    public boolean isOrc() {
        return Orc;
    }

    public void setOrc(boolean orc) {
        Orc = orc;
    }

    public boolean isPrimordial() {
        return Primordial;
    }

    public void setPrimordial(boolean primordial) {
        Primordial = primordial;
    }

    public boolean isSylvan() {
        return Sylvan;
    }

    public void setSylvan(boolean sylvan) {
        Sylvan = sylvan;
    }

    public boolean isUndercommon() {
        return Undercommon;
    }

    public void setUndercommon(boolean undercommon) {
        Undercommon = undercommon;
    }

    public Integer getLanguageProfID() {
        return languageProfID;
    }
}
