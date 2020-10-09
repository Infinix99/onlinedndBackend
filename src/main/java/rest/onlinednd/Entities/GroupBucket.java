package rest.onlinednd.Entities;

import javax.persistence.*;

@Entity
public class GroupBucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column//(name = "groupBucketID")
    private Integer groupBucketID;
}
