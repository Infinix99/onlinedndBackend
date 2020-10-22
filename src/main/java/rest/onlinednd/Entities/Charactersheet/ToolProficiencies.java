package rest.onlinednd.Entities.Charactersheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToolProficiencies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer toolProfID;

    private boolean alchemistSupplies;
    private boolean bagpipes;
    private boolean brewerSupplies;
    private boolean calligrapherSupplies;
    private boolean carpenterTools;
    private boolean cartographerTools;
    private boolean cobblerTools;
    private boolean cookUtensils;
    private boolean diceSet;
    private boolean disguiseKit;
    private boolean dragonchessSet;
    private boolean drum;
    private boolean dulcimer;
    private boolean flute;
    private boolean forgeryKit;
    private boolean glassblowerTools;
    private boolean herbalismKit;
    private boolean horn;
    private boolean jewelersTools;
    private boolean landVehicles;
    private boolean leatherworkerTools;
    private boolean lute;
    private boolean lyre;
    private boolean masonTools;
    private boolean navigatorTools;
    private boolean painterTools;
    private boolean poisonerKit;
    private boolean potterTools;
    private boolean shawm;
    private boolean smithTools;
    private boolean thieveTools;
    private boolean threeDragonAnteSet;
    private boolean tinkerTools;
    private boolean viol;
    private boolean waterVehicles;
    private boolean weaverTools;
    private boolean woodcarverTools;            //37

    public ToolProficiencies() {

    }

    //__________________________________________________________________

    public boolean isAlchemistSupplies() {
        return alchemistSupplies;
    }

    public void setAlchemistSupplies(boolean alchemistSupplies) {
        this.alchemistSupplies = alchemistSupplies;
    }

    public boolean isBagpipes() {
        return bagpipes;
    }

    public void setBagpipes(boolean bagpipes) {
        this.bagpipes = bagpipes;
    }

    public boolean isBrewerSupplies() {
        return brewerSupplies;
    }

    public void setBrewerSupplies(boolean brewerSupplies) {
        this.brewerSupplies = brewerSupplies;
    }

    public boolean isCalligrapherSupplies() {
        return calligrapherSupplies;
    }

    public void setCalligrapherSupplies(boolean calligrapherSupplies) {
        this.calligrapherSupplies = calligrapherSupplies;
    }

    public boolean isCarpenterTools() {
        return carpenterTools;
    }

    public void setCarpenterTools(boolean carpenterTools) {
        this.carpenterTools = carpenterTools;
    }

    public boolean isCartographerTools() {
        return cartographerTools;
    }

    public void setCartographerTools(boolean cartographerTools) {
        this.cartographerTools = cartographerTools;
    }

    public boolean isCobblerTools() {
        return cobblerTools;
    }

    public void setCobblerTools(boolean cobblerTools) {
        this.cobblerTools = cobblerTools;
    }

    public boolean isCookUtensils() {
        return cookUtensils;
    }

    public void setCookUtensils(boolean cookUtensils) {
        this.cookUtensils = cookUtensils;
    }

    public boolean isDiceSet() {
        return diceSet;
    }

    public void setDiceSet(boolean diceSet) {
        this.diceSet = diceSet;
    }

    public boolean isDisguiseKit() {
        return disguiseKit;
    }

    public void setDisguiseKit(boolean disguiseKit) {
        this.disguiseKit = disguiseKit;
    }

    public boolean isDragonchessSet() {
        return dragonchessSet;
    }

    public void setDragonchessSet(boolean dragonchessSet) {
        this.dragonchessSet = dragonchessSet;
    }

    public boolean isDrum() {
        return drum;
    }

    public void setDrum(boolean drum) {
        this.drum = drum;
    }

    public boolean isDulcimer() {
        return dulcimer;
    }

    public void setDulcimer(boolean dulcimer) {
        this.dulcimer = dulcimer;
    }

    public boolean isFlute() {
        return flute;
    }

    public void setFlute(boolean flute) {
        this.flute = flute;
    }

    public boolean isForgeryKit() {
        return forgeryKit;
    }

    public void setForgeryKit(boolean forgeryKit) {
        this.forgeryKit = forgeryKit;
    }

    public boolean isGlassblowerTools() {
        return glassblowerTools;
    }

    public void setGlassblowerTools(boolean glassblowerTools) {
        this.glassblowerTools = glassblowerTools;
    }

    public boolean isHerbalismKit() {
        return herbalismKit;
    }

    public void setHerbalismKit(boolean herbalismKit) {
        this.herbalismKit = herbalismKit;
    }

    public boolean isHorn() {
        return horn;
    }

    public void setHorn(boolean horn) {
        this.horn = horn;
    }

    public boolean isJewelersTools() {
        return jewelersTools;
    }

    public void setJewelersTools(boolean jewelersTools) {
        this.jewelersTools = jewelersTools;
    }

    public boolean isLandVehicles() {
        return landVehicles;
    }

    public void setLandVehicles(boolean landVehicles) {
        this.landVehicles = landVehicles;
    }

    public boolean isLeatherworkerTools() {
        return leatherworkerTools;
    }

    public void setLeatherworkerTools(boolean leatherworkerTools) {
        this.leatherworkerTools = leatherworkerTools;
    }

    public boolean isLute() {
        return lute;
    }

    public void setLute(boolean lute) {
        this.lute = lute;
    }

    public boolean isLyre() {
        return lyre;
    }

    public void setLyre(boolean lyre) {
        this.lyre = lyre;
    }

    public boolean isMasonTools() {
        return masonTools;
    }

    public void setMasonTools(boolean masonTools) {
        this.masonTools = masonTools;
    }

    public boolean isNavigatorTools() {
        return navigatorTools;
    }

    public void setNavigatorTools(boolean navigatorTools) {
        this.navigatorTools = navigatorTools;
    }

    public boolean isPainterTools() {
        return painterTools;
    }

    public void setPainterTools(boolean painterTools) {
        this.painterTools = painterTools;
    }

    public boolean isPoisonerKit() {
        return poisonerKit;
    }

    public void setPoisonerKit(boolean poisonerKit) {
        this.poisonerKit = poisonerKit;
    }

    public boolean isPotterTools() {
        return potterTools;
    }

    public void setPotterTools(boolean potterTools) {
        this.potterTools = potterTools;
    }

    public boolean isShawm() {
        return shawm;
    }

    public void setShawm(boolean shawm) {
        this.shawm = shawm;
    }

    public boolean isSmithTools() {
        return smithTools;
    }

    public void setSmithTools(boolean smithTools) {
        this.smithTools = smithTools;
    }

    public boolean isThieveTools() {
        return thieveTools;
    }

    public void setThieveTools(boolean thieveTools) {
        this.thieveTools = thieveTools;
    }

    public boolean isThreeDragonAnteSet() {
        return threeDragonAnteSet;
    }

    public void setThreeDragonAnteSet(boolean threeDragonAnteSet) {
        this.threeDragonAnteSet = threeDragonAnteSet;
    }

    public boolean isTinkerTools() {
        return tinkerTools;
    }

    public void setTinkerTools(boolean tinkerTools) {
        this.tinkerTools = tinkerTools;
    }

    public boolean isViol() {
        return viol;
    }

    public void setViol(boolean viol) {
        this.viol = viol;
    }

    public boolean isWaterVehicles() {
        return waterVehicles;
    }

    public void setWaterVehicles(boolean waterVehicles) {
        this.waterVehicles = waterVehicles;
    }

    public boolean isWeaverTools() {
        return weaverTools;
    }

    public void setWeaverTools(boolean weaverTools) {
        this.weaverTools = weaverTools;
    }

    public boolean isWoodcarverTools() {
        return woodcarverTools;
    }

    public void setWoodcarverTools(boolean woodcarverTools) {
        this.woodcarverTools = woodcarverTools;
    }

    public Integer getToolProfID() {
        return toolProfID;
    }
}
