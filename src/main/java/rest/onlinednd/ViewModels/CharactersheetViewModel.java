package rest.onlinednd.ViewModels;


import rest.onlinednd.Entities.Charactersheet.Stats;

public class CharactersheetViewModel {
    private String characterName;
    private int initiative;
    private int armorClass;
    private int proficiencyBonus;
    private int speed;
    private int passivePerception;
    private int level;
    private boolean sheetIsVisible;
    private int groupID;

    //private Stats stats;

    public CharactersheetViewModel() {
    }




    //_________________GETTER & SETTER_________________\\

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPassivePerception() {
        return passivePerception;
    }

    public void setPassivePerception(int passivePerception) {
        this.passivePerception = passivePerception;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isSheetIsVisible() {
        return sheetIsVisible;
    }

    public void setSheetIsVisible(boolean visible) {
        sheetIsVisible = visible;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int group) {
        this.groupID = group;
    }
}
