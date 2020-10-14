package rest.onlinednd.ViewModels;

import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

public class GroupViewModel {

    private String name;

    public GroupViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
