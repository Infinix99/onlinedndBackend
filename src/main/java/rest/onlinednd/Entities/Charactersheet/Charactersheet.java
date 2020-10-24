package rest.onlinednd.Entities.Charactersheet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.mapping.Collection;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Charactersheet {

    private String characterName;
    private int initiative;
    private int armorClass;
    private int proficiencyBonus;
    private int speed;
    private int passivePerception;
    private int level;                              //INPUT
    int inspiration;
    private boolean sheetIsVisible;
    private int groupID;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer charactersheetID;


//    private Spellcasting spellcasting;
//    private Equipment equipment;    --> Reicht als String (Bucket oder So?)
//    private FeaturesANDTraits featuresANDTraits;
//
    public Charactersheet() {
//        equipment = new Equipment();
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

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
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



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private LanguageProficiencies languageProficiencies;

    public LanguageProficiencies getLanguageProficiencies() {
        return languageProficiencies;
    }

    public void setLanguageProficiencies(LanguageProficiencies languageProficiencies) {
        this.languageProficiencies = languageProficiencies;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private ToolProficiencies toolProficiencies;

    public ToolProficiencies getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(ToolProficiencies toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private WeaponProficiencies weaponProficiencies;

    public WeaponProficiencies getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(WeaponProficiencies weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private SavingThrows savingThrows;

    public SavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }



    @OneToMany(mappedBy = "charactersheet")
    @JsonManagedReference
    private Set<Notes> notes;

    public Set<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Set<Notes> notes) {
        this.notes = notes;
    }



    @OneToMany(mappedBy = "charactersheet")
    @JsonManagedReference
    private Set<Equippable> equippables;

    public Set<Equippable> getEquippables() {
        return equippables;
    }

    public void setEquippables(Set<Equippable> equippables) {
        this.equippables = equippables;
    }




    @OneToMany(mappedBy = "charactersheet")
    @JsonManagedReference
    private Set<Wearable> wearables;

    public Set<Wearable> getWearables() {
        return wearables;
    }

    public void setWearables(Set<Wearable> wearables) {
        this.wearables = wearables;
    }




    @OneToMany(mappedBy = "charactersheet")
    @JsonManagedReference
    private Set<Carryable> carryables;

    public Set<Carryable> getCarryables() {
        return carryables;
    }

    public void setCarryables(Set<Carryable> carryables) {
        this.carryables = carryables;
    }



    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Group group;


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

