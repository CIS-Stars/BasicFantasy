package org.lewisandclark.csd.basicfantasy;

import java.util.ArrayList;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class PlayerCharacter {

    private int ID;

    //Standard non-crucial stuff
    private String mName;
    private Gender mSex;
    private int mAge;
    private int mLevel;
    private int mXP;
    private Race mRace;
    private CharacterClass mPlayerClass;

    private int mStatRollCounter;
    private AttributeScore[] mStatArray = new AttributeScore[6]; //[STR,INT,WIS,DEX,CON,CHA]

    private int mTotalHitPoints;
    private int mCurrentHitPoints;
    private int mArmorClass;

    private int mBaseAttackBonus;
    private int mMeleeAttackBonus;
    private int mRangedAttackBonus;

    private int mBaseMovement;
    private int mCurrentMovement;

    private int mAbilityRoll;

    private int mDeathRayPoisonSave;
    private int mDeathRayPosionMod;
    private int mWandSave;
    private int mWandMod;
    private int mParalysisStoneSave;
    private int mParalysisStoneMod;
    private int mDragonBreathSave;
    private int mDragonBreathMod;
    private int mRodStaveSpellSave;
    private int mRodStaveSpellMod;

    private int[] mMoneyArray = new int[5]; //[PP,GP,EP,SP,CP]
    private ArrayList<Treasure> mTreasureList = new ArrayList<Treasure>();
    private ArrayList<Item> mEquipmentList = new ArrayList<>();

    public PlayerCharacter(int id) {

        this.ID = id;
        this.mStatRollCounter = 0;
    }

    /**
     * Generic Constructor for testing
     */
    public PlayerCharacter(){
        this.mName = "Fenton Falomar";
        this.mSex = Gender.MALE;
        this.mRace = Race.HUMAN;
        this.mPlayerClass = CharacterClass.FIGHTER;
        this.mAge = 20;
        this.mLevel = 1;
        this.mXP = 0;

        this.mStatRollCounter = 1;
        this.mStatArray[Attribute.STR.ordinal()] = new AttributeScore(15);
        this.mStatArray[Attribute.INT.ordinal()] = new AttributeScore(10);
        this.mStatArray[Attribute.WIS.ordinal()] = new AttributeScore(9);
        this.mStatArray[Attribute.DEX.ordinal()] = new AttributeScore(12);
        this.mStatArray[Attribute.CON.ordinal()] = new AttributeScore(12);
        this.mStatArray[Attribute.CHA.ordinal()] = new AttributeScore(5);

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

    public Gender getSex() {
        return mSex;
    }

    public void setSex(Gender sex) {
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

    public int getStatRollCounter() {
        return mStatRollCounter;
    }

    public void setStatRollCounter(int statRollCounter) {
        mStatRollCounter = statRollCounter;
    }

    public void incrementStatRollCounter(){ mStatRollCounter++;}

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

    public int getMeleeAttackBonus() {
        return mMeleeAttackBonus;
    }

    public void setMeleeAttackBonus(int meleeAttackBonus) {
        mMeleeAttackBonus = meleeAttackBonus;
    }

    public int getRangedAttackBonus() {
        return mRangedAttackBonus;
    }

    public void setRangedAttackBonus(int rangedAttackBonus) {
        mRangedAttackBonus = rangedAttackBonus;
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

    public int getAbilityRoll() {
        return mAbilityRoll;
    }

    public void setAbilityRoll(int abilityRoll) {
        mAbilityRoll = abilityRoll;
    }

    public int getDeathRayPoisonSave() {
        return mDeathRayPoisonSave;
    }

    public void setDeathRayPoisonSave(int deathRayPoisonSave) {
        mDeathRayPoisonSave = deathRayPoisonSave;
    }

    public int getDeathRayPosionMod() {
        return mDeathRayPosionMod;
    }

    public void setDeathRayPosionMod(int deathRayPosionMod) {
        mDeathRayPosionMod = deathRayPosionMod;
    }

    public int getWandSave() {
        return mWandSave;
    }

    public void setWandSave(int wandSave) {
        mWandSave = wandSave;
    }

    public int getWandMod() {
        return mWandMod;
    }

    public void setWandMod(int wandMod) {
        mWandMod = wandMod;
    }

    public int getParalysisStoneSave() {
        return mParalysisStoneSave;
    }

    public void setParalysisStoneSave(int paralysisStoneSave) {
        mParalysisStoneSave = paralysisStoneSave;
    }

    public int getParalysisStoneMod() {
        return mParalysisStoneMod;
    }

    public void setParalysisStoneMod(int paralysisStoneMod) {
        mParalysisStoneMod = paralysisStoneMod;
    }

    public int getDragonBreathSave() {
        return mDragonBreathSave;
    }

    public void setDragonBreathSave(int dragonBreathSave) {
        mDragonBreathSave = dragonBreathSave;
    }

    public int getDragonBreathMod() {
        return mDragonBreathMod;
    }

    public void setDragonBreathMod(int dragonBreathMod) {
        mDragonBreathMod = dragonBreathMod;
    }

    public int getRodStaveSpellSave() {
        return mRodStaveSpellSave;
    }

    public void setRodStaveSpellSave(int rodStaveSpellSave) {
        mRodStaveSpellSave = rodStaveSpellSave;
    }

    public int getRodStaveSpellMod() {
        return mRodStaveSpellMod;
    }

    public void setRodStaveSpellMod(int rodStaveSpellMod) {
        mRodStaveSpellMod = rodStaveSpellMod;
    }
}
