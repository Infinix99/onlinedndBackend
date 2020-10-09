package rest.onlinednd.Entities.Charactersheet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer notesID;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonBackReference
    private Charactersheet charactersheet;




    private String note;

    public Notes() {
    }


    //_______GETTER & SETTER___________

    public Integer getNotesID() {
        return notesID;
    }

    public Charactersheet getCharactersheet() {
        return charactersheet;
    }

    public void setCharactersheet(Charactersheet charactersheet) {
        this.charactersheet = charactersheet;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
