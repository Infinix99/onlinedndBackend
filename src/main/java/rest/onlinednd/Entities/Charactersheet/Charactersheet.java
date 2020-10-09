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







//    private SavingThrows savingThrows;
//    private Spellcasting spellcasting;
//    private Equipment equipment;    --> Reicht als String (Bucket oder So?)
//    private FeaturesANDTraits featuresANDTraits;
//    private LanguageProficiencies languageProficiencies;
//    private ToolProficiencies toolProficiencies;
//    private WeaponProficiencies weaponProficiencies;
//
   public Charactersheet() {
//        languageProficiencies = new LanguageProficiencies();
//        toolProficiencies = new ToolProficiencies();
//        savingThrows = new SavingThrows();
//        armorProficiencies = new ArmorProficiencies();
//        weaponProficiencies = new WeaponProficiencies();
//        characterDescription = new CharacterDesc();
//        equipment = new Equipment();
//        toolProficiencies = new ToolProficiencies();
//        treasure = new Treasure();
   }

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


    //______KOMPLEX FRONT END OPPERTATIONS______\\

    private String race;
    private String combatClass;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCombatClass() {
        return combatClass;
    }

    public void setCombatClass(String combatClass) {
        this.combatClass = combatClass;
    }

    //________________FORGEIN KEY's___________________\\

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Stats stats;

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Skills skills;

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Life life;

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Treasure treasure;

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private CharacterDescription characterDescription;

    public CharacterDescription getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(CharacterDescription characterDescription) {
        this.characterDescription = characterDescription;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private ArmorProficiencies armorProficiencies;

    public ArmorProficiencies getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(ArmorProficiencies armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }
}
