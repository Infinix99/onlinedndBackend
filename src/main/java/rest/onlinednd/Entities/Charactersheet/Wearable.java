package rest.onlinednd.Entities.Charactersheet;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Wearable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wearableID;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private Charactersheet charactersheet;




    private String wearable;

    public Wearable() {
    }


    //_______GETTER & SETTER___________


    public Integer getWearableID() {
        return wearableID;
    }

    public Charactersheet getCharactersheet() {
        return charactersheet;
    }

    public void setCharactersheet(Charactersheet charactersheet) {
        this.charactersheet = charactersheet;
    }

    public String getWearable() {
        return wearable;
    }

    public void setWearable(String wearable) {
        this.wearable = wearable;
    }
}
