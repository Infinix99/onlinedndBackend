package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skillsID;

    public Skills() {
    }




    //_______Local Variable__________

    private int passivePerception;

    public int getPassivePerception() {
        return passivePerception;
    }

    public void setPassivePerception(int passivePerception) {
        this.passivePerception = passivePerception;
    }




    //____________Charisma Skills______________

    private int deception;          private boolean deception_prof;
    private int intimidation;       private boolean intimidation_prof;
    private int performance;        private boolean performance_prof;
    private int persuasion;         private boolean persuasion_prof;

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public boolean isDeception_prof() {
        return deception_prof;
    }

    public void setDeception_prof(boolean deception_prof) {
        this.deception_prof = deception_prof;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public boolean isIntimidation_prof() {
        return intimidation_prof;
    }

    public void setIntimidation_prof(boolean intimidation_prof) {
        this.intimidation_prof = intimidation_prof;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public boolean isPerformance_prof() {
        return performance_prof;
    }

    public void setPerformance_prof(boolean performance_prof) {
        this.performance_prof = performance_prof;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public boolean isPersuasion_prof() {
        return persuasion_prof;
    }

    public void setPersuasion_prof(boolean persuasion_prof) {
        this.persuasion_prof = persuasion_prof;
    }




    //________Dexterity Skills________________

    private int acrobatics;         private boolean acrobatics_prof;
    private int sleight_of_hand;    private boolean sleight_of_hand_prof;
    private int stealth;            private boolean stealth_prof;

    public Integer getSkillsID() {
        return skillsID;
    }

    public void setSkillsID(Integer skillsID) {
        this.skillsID = skillsID;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public boolean isAcrobatics_prof() {
        return acrobatics_prof;
    }

    public void setAcrobatics_prof(boolean acrobatics_prof) {
        this.acrobatics_prof = acrobatics_prof;
    }

    public int getSleight_of_hand() {
        return sleight_of_hand;
    }

    public void setSleight_of_hand(int sleight_of_hand) {
        this.sleight_of_hand = sleight_of_hand;
    }

    public boolean isSleight_of_hand_prof() {
        return sleight_of_hand_prof;
    }

    public void setSleight_of_hand_prof(boolean sleight_of_hand_prof) {
        this.sleight_of_hand_prof = sleight_of_hand_prof;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public boolean isStealth_prof() {
        return stealth_prof;
    }

    public void setStealth_prof(boolean stealth_prof) {
        this.stealth_prof = stealth_prof;
    }




    //________Intelligence Skills________________

    private int arcana ;             private boolean arcana_prof;
    private int history;            private boolean history_prof;
    private int investigation;      private boolean investigation_prof;
    private int nature;             private boolean nature_prof;
    private int religion;           private boolean religion_prof;

    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    public boolean isArcana_prof() {
        return arcana_prof;
    }

    public void setArcana_prof(boolean arcana_prof) {
        this.arcana_prof = arcana_prof;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public boolean isHistory_prof() {
        return history_prof;
    }

    public void setHistory_prof(boolean history_prof) {
        this.history_prof = history_prof;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }

    public boolean isInvestigation_prof() {
        return investigation_prof;
    }

    public void setInvestigation_prof(boolean investigation_prof) {
        this.investigation_prof = investigation_prof;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public boolean isNature_prof() {
        return nature_prof;
    }

    public void setNature_prof(boolean nature_prof) {
        this.nature_prof = nature_prof;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public boolean isReligion_prof() {
        return religion_prof;
    }

    public void setReligion_prof(boolean religion_prof) {
        this.religion_prof = religion_prof;
    }


    //___________Strength Skills__________________

    private int athletics;          private boolean athletics_prof;

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public boolean isAthletics_prof() {
        return athletics_prof;
    }

    public void setAthletics_prof(boolean athletics_prof) {
        this.athletics_prof = athletics_prof;
    }


    //__________Wisdom Skills_______________________

    private int animal_handling;    private boolean animal_handling_prof;
    private int insight;            private boolean insight_prof;
    private int medicine;           private boolean medicine_prof;
    private int perception;         private boolean perception_prof;
    private int survival;           private boolean survival_prof;

    public int getAnimal_handling() {
        return animal_handling;
    }

    public void setAnimal_handling(int animal_handling) {
        this.animal_handling = animal_handling;
    }

    public boolean isAnimal_handling_prof() {
        return animal_handling_prof;
    }

    public void setAnimal_handling_prof(boolean animal_handling_prof) {
        this.animal_handling_prof = animal_handling_prof;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public boolean isInsight_prof() {
        return insight_prof;
    }

    public void setInsight_prof(boolean insight_prof) {
        this.insight_prof = insight_prof;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public boolean isMedicine_prof() {
        return medicine_prof;
    }

    public void setMedicine_prof(boolean medicine_prof) {
        this.medicine_prof = medicine_prof;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public boolean isPerception_prof() {
        return perception_prof;
    }

    public void setPerception_prof(boolean perception_prof) {
        this.perception_prof = perception_prof;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public boolean isSurvival_prof() {
        return survival_prof;
    }

    public void setSurvival_prof(boolean survival_prof) {
        this.survival_prof = survival_prof;
    }
}
