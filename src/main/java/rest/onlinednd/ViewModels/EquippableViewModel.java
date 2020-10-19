package rest.onlinednd.ViewModels;

public class EquippableViewModel {

    String equippable;
    String details;
    int attackBonus;

    public String getEquippable() {
        return equippable;
    }

    public void setEquippable(String equippable) {
        this.equippable = equippable;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }
}
