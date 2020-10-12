package rest.onlinednd.Entities.Charactersheet;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Carryable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carryableID;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private Charactersheet charactersheet;




    private String carryable;
    private int amount;

    public Carryable() {
    }


    //_______GETTER & SETTER___________


    public Integer getCarryableID() {
        return carryableID;
    }

    public Charactersheet getCharactersheet() {
        return charactersheet;
    }

    public void setCharactersheet(Charactersheet charactersheet) {
        this.charactersheet = charactersheet;
    }

    public String getCarryable() {
        return carryable;
    }

    public void setCarryable(String carryable) {
        this.carryable = carryable;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
