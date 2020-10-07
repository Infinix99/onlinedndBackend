package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.*;

@Entity
@Table
public class Charactersheet {

    private String characterName;
    private int initiative;
    private int armorClass;
    private int proficiencyBonus;
    private int speed;
    private int passivePerception;
    private int level;
    private boolean sheetIsVisible;
    private int groupID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer charactersheetID;


//    private Stats stats;
//    private Skills skills;
//    private SavingThrows savingThrows;
//    private Spellcasting spellcasting;
//    private Equipment equipment;
//    private Treasure treasure;
//    private FeaturesANDTraits featuresANDTraits;
//    private Class aClass;
//    private Race race;
//    private CharacterDesc characterDescription;
//    private ArmorProficiencies armorProficiencies;
//    private LanguageProficiencies languageProficiencies;
//    private ToolProficiencies toolProficiencies;
//    private WeaponProficiencies weaponProficiencies;
//    private HitPoints hitPoints;
//    private HitDice hitDice;
//
//    public Charactersheet() {
//        stats = new Stats();
//        proficiencyBonus = 2;
//        skills = new Skills();
//        languageProficiencies = new LanguageProficiencies();
//        toolProficiencies = new ToolProficiencies();
//        savingThrows = new SavingThrows();
//        armorProficiencies = new ArmorProficiencies();
//        weaponProficiencies = new WeaponProficiencies();
//        hitPoints = new HitPoints();
//        hitDice = new HitDice();
//        characterDescription = new CharacterDesc();
//        equipment = new Equipment();
//        toolProficiencies = new ToolProficiencies();
//        treasure = new Treasure();
//    }


    //Getter and Setter______________________


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

    public Integer getCharactersheetID() {
        return charactersheetID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }


}
