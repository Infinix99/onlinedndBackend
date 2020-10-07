package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Charactersheet {

    private String characterName;
    private int initiative;
    private int armorClass;
    private int proficiencyBonus;
    private int speed;
    private int passivePerception;
    //private boolean[] deathSaves = new boolean[6];
    private int level;
    private boolean isVisible;
    private int group;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer charID;


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

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Integer getCharID() {
        return charID;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }


}
