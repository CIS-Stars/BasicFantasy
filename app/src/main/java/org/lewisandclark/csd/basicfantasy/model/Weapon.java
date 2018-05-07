package org.lewisandclark.csd.basicfantasy.model;

import org.lewisandclark.csd.basicfantasy.R;
import org.lewisandclark.csd.basicfantasy.utils.DieRoller;

/**
 * Created by Thorin Schmidt on 4/23/2018.
 */
public class Weapon extends Item {

    private int mDamageDie;
    private int mAttackBonus;
    private int mSecondAttackBonus;
    private String mSecondABTarget;
    private boolean mTwoHanded;
    private boolean mRanged;
    private int mShortRange;
    private int mMediumRange;
    private int mLongRange;

    public Weapon(){
        super(R.string.fists, "", 0, 0, 1);
        mAttackBonus = 0;
        mDamageDie = 3;
        mSecondAttackBonus = 0;
        mSecondABTarget = "";
        mTwoHanded = false;
        mRanged = false;
        mShortRange = 0;
        mMediumRange = 0;
        mLongRange = 0;
    }

    public Weapon(int nameID, double costInGP, double weight,int damageDie, int quantity,
                 int AB, int SecondAB, String ABTarget, boolean twoHand, boolean ranged,
                  int shortRange, int mediumRange, int longRange, String formalName) {
        super(nameID, formalName, weight, costInGP, quantity);
        mAttackBonus = AB;
        mDamageDie = damageDie;
        mSecondAttackBonus = SecondAB;
        mSecondABTarget = ABTarget;
        mTwoHanded = twoHand;
        mRanged = ranged;
        mShortRange = shortRange;
        mMediumRange = mediumRange;
        mLongRange = longRange;
    }

    public int getAttackBonus() {
        return mAttackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        mAttackBonus = attackBonus;
    }

    public int getSecondAttackBonus() {
        return mSecondAttackBonus;
    }

    public void setSecondAttackBonus(int secondAttackBonus) {
        mSecondAttackBonus = secondAttackBonus;
    }

    public String getSecondABTarget() {
        return mSecondABTarget;
    }

    public void setSecondABTarget(String secondABTarget) {
        mSecondABTarget = secondABTarget;
    }

    public boolean isTwoHanded() {
        return mTwoHanded;
    }

    public void setTwoHanded(boolean twoHanded) {
        mTwoHanded = twoHanded;
    }

    public boolean isRanged() {
        return mRanged;
    }

    public void setRanged(boolean ranged) {
        mRanged = ranged;
    }

    public int getShortRange() {
        return mShortRange;
    }

    public void setShortRange(int shortRange) {
        mShortRange = shortRange;
    }

    public int getMediumRange() {
        return mMediumRange;
    }

    public void setMediumRange(int mediumRange) {
        mMediumRange = mediumRange;
    }

    public int getLongRange() {
        return mLongRange;
    }

    public void setLongRange(int longRange) {
        mLongRange = longRange;
    }

    public int getDamageDie() {
        return mDamageDie;
    }

    public void setDamageDie(int damageDie) {
        mDamageDie = damageDie;
    }

    public int rollDamage(){
        return DieRoller.roll(mDamageDie);
    }
}
