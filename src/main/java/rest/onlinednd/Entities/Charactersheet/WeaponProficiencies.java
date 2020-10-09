package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class WeaponProficiencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer weaponPrfoID;

    private boolean simpleMeleeWeapons;
    private boolean simpleRangedWeapons;
    private boolean martiaMeleeWeapons;
    private boolean martialRangedWeapons;

    public WeaponProficiencies() {

    }



    //____________________________________________________


    public boolean isSimpleMeleeWeapons() {
        return simpleMeleeWeapons;
    }

    public void setSimpleMeleeWeapons(boolean simpleMeleeWeapons) {
        this.simpleMeleeWeapons = simpleMeleeWeapons;
    }

    public boolean isSimpleRangedWeapons() {
        return simpleRangedWeapons;
    }

    public void setSimpleRangedWeapons(boolean simpleRangedWeapons) {
        this.simpleRangedWeapons = simpleRangedWeapons;
    }

    public boolean isMartiaMeleeWeapons() {
        return martiaMeleeWeapons;
    }

    public void setMartiaMeleeWeapons(boolean martiaMeleeWeapons) {
        this.martiaMeleeWeapons = martiaMeleeWeapons;
    }

    public boolean isMartialRangedWeapons() {
        return martialRangedWeapons;
    }

    public void setMartialRangedWeapons(boolean martialRangedWeapons) {
        this.martialRangedWeapons = martialRangedWeapons;
    }
}
