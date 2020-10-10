package rest.onlinednd.Entities.Charactersheet;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Equippable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer equippableID;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private Charactersheet charactersheet;




    private String equippable;

    public Equippable() {
    }


    //_______GETTER & SETTER___________


    public Integer getEquippableID() {
        return equippableID;
    }

    public Charactersheet getCharactersheet() {
        return charactersheet;
    }

    public void setCharactersheet(Charactersheet charactersheet) {
        this.charactersheet = charactersheet;
    }

    public String getEquippable() {
        return equippable;
    }

    public void setEquippable(String equippable) {
        this.equippable = equippable;
    }
}
