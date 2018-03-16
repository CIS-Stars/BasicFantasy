package org.lewisandclark.csd.basicfantasy;

import java.util.ArrayList;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class PlayerCharacter {

    private int ID;

    //Standard non-crucial stuff
    private String mName;
    private String mSex;
    private int mAge;
    private int mLevel;
    private int mXP;

    //Hashmaps
    //private HashMap<Attribute, AttributeScore> mAttributes = new HashMap<>();
    //private HashMap<Money, Integer> mMoney = new HashMap<>();
    // abandoned this because forums say is a memory hog.

    private AttributeScore[] mStatArray = new AttributeScore[6]; //[STR,INT,WIS,DEX,CON,CHA]
    private int[] mMoneyArray = new int[5]; //[PP,GP,EP,SP,CP]
    private ArrayList<Treasure> mTreasureList = new ArrayList<Treasure>();

    private int mTotalHitPoints;
    private int mCurrentHitPoints;

    private Race mRace;
    private CharacterClass mPlayerClass;

    private int mArmorClass;

    private int mBaseAttackBonus;
    private int mCurrentAttackBonus;

    private int mBaseMovement;
    private int mCurrentMovement;

    public PlayerCharacter(int id) {
        this.ID = id;
    }

    public PlayerCharacter(){
        mName = "Jared";
        mSex = "male";
        mAge = 12;
        mLevel = 1;
        mXP = 0;

        mStatArray[Attribute.STR.ordinal()] = new AttributeScore(12);
        mStatArray[Attribute.INT.ordinal()] = new AttributeScore(12);
        mStatArray[Attribute.WIS.ordinal()] = new AttributeScore(12);
        mStatArray[Attribute.DEX.ordinal()] = new AttributeScore(12);
        mStatArray[Attribute.CON.ordinal()] = new AttributeScore(3);
        mStatArray[Attribute.CHA.ordinal()] = new AttributeScore(12);

        mTotalHitPoints = 10;
        mCurrentHitPoints = 8;

        mRace = Race.HUMAN;
        mPlayerClass = CharacterClass.FIGHTER;

        mArmorClass = 14;

        mBaseAttackBonus = 1;
        mCurrentAttackBonus = 2;

        mBaseMovement =30;
        mCurrentMovement = 35;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getXP() {
        return mXP;
    }

    public void setXP(int XP) {
        mXP = XP;
    }

    public AttributeScore[] getStatArray() {
        return mStatArray;
    }

    public void setStatArray(AttributeScore[] statArray) {
        mStatArray = statArray;
    }

    public int[] getMoneyArray() {
        return mMoneyArray;
    }

    public void setMoneyArray(int[] moneyArray) {
        mMoneyArray = moneyArray;
    }

    public ArrayList<Treasure> getTreasureList() {
        return mTreasureList;
    }

    public void setTreasureList(ArrayList<Treasure> treasureList) {
        mTreasureList = treasureList;
    }

    public int getTotalHitPoints() {
        return mTotalHitPoints;
    }

    public void setTotalHitPoints(int totalHitPoints) {
        mTotalHitPoints = totalHitPoints;
    }

    public int getCurrentHitPoints() {
        return mCurrentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        mCurrentHitPoints = currentHitPoints;
    }

    public Race getRace() {
        return mRace;
    }

    public void setRace(Race race) {
        mRace = race;
    }

    public CharacterClass getPlayerClass() {
        return mPlayerClass;
    }

    public void setPlayerClass(CharacterClass aClass) {
        mPlayerClass = aClass;
    }

    public int getArmorClass() {
        return mArmorClass;
    }

    public void setArmorClass(int armorClass) {
        mArmorClass = armorClass;
    }

    public int getBaseAttackBonus() {
        return mBaseAttackBonus;
    }

    public void setBaseAttackBonus(int baseAttackBonus) {
        mBaseAttackBonus = baseAttackBonus;
    }

    public int getCurrentAttackBonus() {
        return mCurrentAttackBonus;
    }

    public void setCurrentAttackBonus(int currentAttackBonus) {
        mCurrentAttackBonus = currentAttackBonus;
    }

    public int getBaseMovement() {
        return mBaseMovement;
    }

    public void setBaseMovement(int baseMovement) {
        mBaseMovement = baseMovement;
    }

    public int getCurrentMovement() {
        return mCurrentMovement;
    }

    public void setCurrentMovement(int currentMovement) {
        mCurrentMovement = currentMovement;
    }
}
