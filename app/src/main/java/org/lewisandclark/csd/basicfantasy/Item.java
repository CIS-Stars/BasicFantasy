package org.lewisandclark.csd.basicfantasy;

/**
 * Base class for all items.
 *
 * Created by Thorin Schmidt on 2/21/2018.
 */

public class Item {
    private int mNameID;           //the common name of the item - "sword"
    private String mFormalName;     //a more formal name for a specific item - "Excalibur"
    private double mWeight;         //the weight of a single item
    private double mCostInGP;       //cost of a single item
    private int mQuantity;          //how much of the item a character has
    private boolean mEquipped;      //is the character wearing/carrying the item

    public Item(){
        mNameID = R.string.thing;
        mFormalName = "";
        mWeight = 0;
        mCostInGP = 0;
        mQuantity = 1;
        mEquipped = false;
    }

    /**
     * Constructor
     *
     * @param nameID              the common name of the item - "sword"
     * @param formalName        a more formal name for a specific item - "Excalibur"
     * @param weight            factors into how much a character can carry
     * @param costInGP          cost of a single item
     * @param quantity          how much of the item a character has
     */
    public Item(int nameID, String formalName, double weight, double costInGP, int quantity) {
        mNameID = nameID;
        mFormalName = formalName;
        mWeight = weight;
        mCostInGP = costInGP;
        mQuantity = quantity;
        mEquipped = false;
    }

    public int getNameID() {
        return mNameID;
    }

    public void setName(int nameID) {
        mNameID = nameID;
    }

    public String getFormalName() {
        return mFormalName;
    }

    public void setFormalName(String formalName) {
        mFormalName = formalName;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }

    public double getCostInGP() {
        return mCostInGP;
    }

    public void setCostInGP(double costInGP) {
        mCostInGP = costInGP;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public boolean isEquipped() {
        return mEquipped;
    }

    public void setEquipped(boolean equipped) {
        mEquipped = equipped;
    }
}
