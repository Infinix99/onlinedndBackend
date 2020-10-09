package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharacterDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer characterDescriptionID;


    private String alignment;
    private String background;

    //______Appearance______
    private String gender;
    private String eyes;
    private String hair;
    private String characterAppearance;
    private int age;
    private double height;
    private double weight;

    //Personality & Backstory
    private String personalityTraits;
    private String personalityTraits2;
    private String ideals;
    private String bonds;
    private String flaws;
    private String alliesAndOrganizations;
    private String characterBackstory;


    public Integer getCharacterDescriptionID() {
        return characterDescriptionID;
    }


    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getCharacterAppearance() {
        return characterAppearance;
    }

    public void setCharacterAppearance(String characterAppearance) {
        this.characterAppearance = characterAppearance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public String getAlliesAndOrganizations() {
        return alliesAndOrganizations;
    }

    public void setAlliesAndOrganizations(String alliesAndOrganizations) {
        this.alliesAndOrganizations = alliesAndOrganizations;
    }

    public String getCharacterBackstory() {
        return characterBackstory;
    }

    public void setCharacterBackstory(String characterBackstory) {
        this.characterBackstory = characterBackstory;
    }

    public String getPersonalityTraits2() {
        return personalityTraits2;
    }

    public void setPersonalityTraits2(String personalityTraits2) {
        this.personalityTraits2 = personalityTraits2;
    }


}
