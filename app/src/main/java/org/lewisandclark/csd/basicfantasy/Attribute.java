package org.lewisandclark.csd.basicfantasy;



import java.io.Serializable;


/**
 * Enumeration of Attributes for Characters
 * Created by Thorin Schmidt on 2/21/2018.
 */

public enum Attribute implements Serializable {

    STR(R.string.strength),
    INT(R.string.intelligence),
    WIS(R.string.wisdom),
    DEX(R.string.dexterity),
    CON(R.string.constitution),
    CHA(R.string.charisma);


    /**
     * The resource id for the attribute's name.
     */
    private int mResId;


    Attribute(int resId) {
        mResId = resId;
    }

    public int getResId() {
        return mResId;
    }
}
