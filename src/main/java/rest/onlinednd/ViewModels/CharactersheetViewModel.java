package rest.onlinednd.ViewModels;


import rest.onlinednd.Entities.Charactersheet.*;

import java.util.Set;

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

    private String combatClass;
    private String race;

    private Stats stats;
    private Skills skills;
    private Life life;
    private Treasure treasure;
    private CharacterDescription characterDescription;
    private ArmorProficiencies armorProficiencies;
    private LanguageProficiencies languageProficiencies;
    private ToolProficiencies toolProficiencies;
    private WeaponProficiencies weaponProficiencies;
    private SavingThrows savingThrows;
    private Set<Notes> notes;


    public CharactersheetViewModel() {
    }




    //_________________GETTER & SETTER_________________\\


    public String getCombatClass() {
        return combatClass;
    }

    public void setCombatClass(String combatClass) {
        this.combatClass = combatClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

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

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public CharacterDescription getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(CharacterDescription characterDescription) {
        this.characterDescription = characterDescription;
    }

    public ArmorProficiencies getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(ArmorProficiencies armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public LanguageProficiencies getLanguageProficiencies() {
        return languageProficiencies;
    }

    public void setLanguageProficiencies(LanguageProficiencies languageProficiencies) {
        this.languageProficiencies = languageProficiencies;
    }

    public ToolProficiencies getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(ToolProficiencies toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public WeaponProficiencies getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(WeaponProficiencies weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public SavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }

    public Set<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Set<Notes> notes) {
        this.notes = notes;
    }
}
