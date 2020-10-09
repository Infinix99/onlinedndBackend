package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArmorProficiencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ArmorProfID;


    private boolean lightArmor;
    private boolean mediumArmor;
    private boolean heavyArmor;
    private boolean shield;

    public ArmorProficiencies() {

    }


    //__________________________GETTER & SETTER_________________________

    public boolean isLightArmor() {
        return lightArmor;
    }

    public boolean isMediumArmor() {
        return mediumArmor;
    }

    public boolean isHeavyArmor() {
        return heavyArmor;
    }

    public boolean isShield() {
        return shield;
    }

    public void setLightArmor(boolean lightArmor) {
        this.lightArmor = lightArmor;
    }

    public void setMediumArmor(boolean mediumArmor) {
        this.mediumArmor = mediumArmor;
    }

    public void setHeavyArmor(boolean heavyArmor) {
        this.heavyArmor = heavyArmor;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public Integer getArmorProfID() {
        return ArmorProfID;
    }
}
