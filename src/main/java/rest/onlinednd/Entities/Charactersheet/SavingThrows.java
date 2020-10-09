package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavingThrows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer savingThrowsID;

    private boolean save1;
    private boolean save2;
    private boolean save3;
    private boolean fail1;
    private boolean fail2;
    private boolean fail3;

    public SavingThrows() {
    }

    public Integer getSavingThrowsID() {
        return savingThrowsID;
    }

    public boolean isSave1() {
        return save1;
    }

    public void setSave1(boolean save1) {
        this.save1 = save1;
    }

    public boolean isSave2() {
        return save2;
    }

    public void setSave2(boolean save2) {
        this.save2 = save2;
    }

    public boolean isSave3() {
        return save3;
    }

    public void setSave3(boolean save3) {
        this.save3 = save3;
    }

    public boolean isFail1() {
        return fail1;
    }

    public void setFail1(boolean fail1) {
        this.fail1 = fail1;
    }

    public boolean isFail2() {
        return fail2;
    }

    public void setFail2(boolean fail2) {
        this.fail2 = fail2;
    }

    public boolean isFail3() {
        return fail3;
    }

    public void setFail3(boolean fail3) {
        this.fail3 = fail3;
    }
}
