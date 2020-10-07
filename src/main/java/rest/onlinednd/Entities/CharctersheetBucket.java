package rest.onlinednd.Entities;

import javax.persistence.*;

@Entity
public class CharctersheetBucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column//(name = "charBucketID")
    private Integer charBucketID;




}
