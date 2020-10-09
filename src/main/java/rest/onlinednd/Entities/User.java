package rest.onlinednd.Entities;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserID;

    private String name;

    private String email;


    @ManyToOne
    @JoinColumn(name = "char_bucketid")
    private CharctersheetBucket charactersheetBucket;







    //---------------Getter Setter---------------------------------------------------

    public Integer getId() {
        return UserID;
    }

    public void setId(Integer id) {
        this.UserID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
