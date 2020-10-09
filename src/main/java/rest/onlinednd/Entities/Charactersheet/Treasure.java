package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Treasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer treasureID;

    public Treasure() {
    }

    public Integer getTreasureID() {
        return treasureID;
    }


    private int platinum_coins;
    private int gold_coins;
    private int electrum_coins;
    private int silver_coins;
    private int copper_coins;

    public int getPlatinum_coins() {
        return platinum_coins;
    }

    public void setPlatinum_coins(int platinum_coins) {
        this.platinum_coins = platinum_coins;
    }

    public int getGold_coins() {
        return gold_coins;
    }

    public void setGold_coins(int gold_coins) {
        this.gold_coins = gold_coins;
    }

    public int getElectrum_coins() {
        return electrum_coins;
    }

    public void setElectrum_coins(int electrum_coins) {
        this.electrum_coins = electrum_coins;
    }

    public int getSilver_coins() {
        return silver_coins;
    }

    public void setSilver_coins(int silver_coins) {
        this.silver_coins = silver_coins;
    }

    public int getCopper_coins() {
        return copper_coins;
    }

    public void setCopper_coins(int copper_coins) {
        this.copper_coins = copper_coins;
    }
}
