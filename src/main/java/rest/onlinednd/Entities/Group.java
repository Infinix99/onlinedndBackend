package rest.onlinednd.Entities;

import javax.persistence.*;

@Entity
public class Group {
    private String groupid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer charBucketID;






}
