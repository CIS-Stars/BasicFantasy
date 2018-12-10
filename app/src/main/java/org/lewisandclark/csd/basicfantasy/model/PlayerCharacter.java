package org.lewisandclark.csd.basicfantasy.model;

import org.lewisandclark.csd.basicfantasy.utils.DieRoller;

import java.util.ArrayList;

import static org.lewisandclark.csd.basicfantasy.model.GameConstants.ATTACK_BONUS_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.CLERIC_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.FIGHTER_MU_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.FIGHTER_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.MU_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.MU_THIEF_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.GameConstants.THIEF_SAVE_MATRIX;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CHA;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CON;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.DEX;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.INT;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.STR;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.WIS;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class PlayerCharacter {

    private int ID;
    private String mName;
    private Gender mSex;
    private int mHeight;
    private int mWeight;
    private int mAge;
    private int mLevel;
    private int mXP;
    private Race mRace;
    private CharacterClass mPlayerClass;
    private String mEyeColor;

    private int mStatRollCounter;
    private AttributeScore[] mStatArray = new AttributeScore[6]; //[STR,INT,WIS,DEX,CON,CHA]

    private int mHitDie;
    private int mTotalHitPoints;
    private int mCurrentHitPoints;
    private int mArmorClass;
    private Armor mEquippedArmor;
    private Shield mEquippedShield;
    private Weapon mEquippedWeapon;

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
    private ArrayList<Treasure> mTreasureList = new ArrayList<>();
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
        this.mHeight = 76;
        this.mWeight = 220;
        this.mLevel = 1;
        this.mXP = 0;
        this.mHitDie = 8;
        this.mTotalHitPoints = 8;
        this.mCurrentHitPoints = 8;
        this.mEyeColor = "Green";

        this.mStatRollCounter = 1;
        this.mStatArray[STR.ordinal()] = new AttributeScore(18);
        this.mStatArray[INT.ordinal()] = new AttributeScore(16);
        this.mStatArray[WIS.ordinal()] = new AttributeScore(9);
        this.mStatArray[DEX.ordinal()] = new AttributeScore(12);
        this.mStatArray[CON.ordinal()] = new AttributeScore(8);
        this.mStatArray[CHA.ordinal()] = new AttributeScore(5);
        this.autoCalc();
    }

    private void autoCalc(){
        int[] saveArray;
        //total hit points
        if(this.mTotalHitPoints == 0){
            for(int i=0; i<this.mLevel; i++){
                this.mTotalHitPoints += DieRoller.roll(this.mHitDie) +
                    this.mStatArray[CON.ordinal()].getModifier();
            }
        }
        else{
            this.mTotalHitPoints += DieRoller.roll(this.mHitDie) +
                    this.mStatArray[CON.ordinal()].getModifier();
        }
        this.mCurrentHitPoints = this.mTotalHitPoints;

        // Attack Bonus and weapons
        mBaseAttackBonus = ATTACK_BONUS_MATRIX[mPlayerClass.ordinal()][mLevel];
        mMeleeAttackBonus = mBaseAttackBonus + mStatArray[STR.ordinal()].getModifier();
        mRangedAttackBonus = mBaseAttackBonus + mStatArray[DEX.ordinal()].getModifier();
        this.mEquipmentList.add(new Weapon()); //adds entry to "Fists"
        this.mEquippedWeapon = (Weapon) this.mEquipmentList.get(0);

        //Armor Class and Armor
        this.mEquipmentList.add(new Armor());  //adds entry for "No Armor"
        this.mEquipmentList.add(new Shield()); // adds entry for "No Shield"
        this.mEquippedArmor = (Armor) this.mEquipmentList.get(1);
        this.mEquippedShield = (Shield) this.mEquipmentList.get(2);

        //Saves
        switch (this.mPlayerClass){
            case CLERIC: saveArray = CLERIC_SAVE_MATRIX[mLevel];
            break;
            case FIGHTER: saveArray = FIGHTER_SAVE_MATRIX[mLevel];
            break;
            case MAGIC_USER: saveArray = MU_SAVE_MATRIX[mLevel];
            break;
            case THIEF: saveArray = THIEF_SAVE_MATRIX[mLevel];
            break;
            case FIGHTER_MU: saveArray = FIGHTER_MU_SAVE_MATRIX[mLevel];
            break;
            case MU_THIEF: saveArray = MU_THIEF_SAVE_MATRIX[mLevel];
            break;
            default: saveArray = new int[]{20, 20, 20, 20, 20};
        }
        mDeathRayPoisonSave = saveArray[0];
        mWandSave = saveArray[1];
        mParalysisStoneSave = saveArray[2];
        mDragonBreathSave = saveArray[3];
        mRodStaveSpellSave = saveArray[3];

        //Save bonuses
        switch (mRace) {
            case DWARF:
                mDeathRayPosionMod = 4;
                mWandMod = 4;
                mParalysisStoneMod = 4;
                mDragonBreathMod = 3;
                mRodStaveSpellMod = 4;
                break;
            case ELF:
                mDeathRayPosionMod = 0;
                mWandMod = 2;
                mParalysisStoneMod = 0;
                mDragonBreathMod = 0;
                mRodStaveSpellMod = 2;
                break;
            case HALFLING:
                mDeathRayPosionMod = 4;
                mWandMod = 4;
                mParalysisStoneMod = 4;
                mDragonBreathMod = 3;
                mRodStaveSpellMod = 4;
                break;
            default: //human
                mDeathRayPosionMod = 0;
                mWandMod = 0;
                mParalysisStoneMod = 0;
                mDragonBreathMod = 0;
                mRodStaveSpellMod = 0;
                break;
        }

        

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

    public String getEyeColor() {return mEyeColor;}

    public void setEyeColor(String eyeColor) {mEyeColor = eyeColor;}

    public int getAge() {
        return mAge;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
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

    public CharacterClass getCharacterClass() {
        return mPlayerClass;
    }

    public void setCharacterClass(CharacterClass aClass) {
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

    public int getHitDie() {
        return mHitDie;
    }

    public void setHitDie(int hitDie) {
        mHitDie = hitDie;
    }

    public ArrayList<Item> getEquipmentList() {
        return mEquipmentList;
    }

    public void setEquipmentList(ArrayList<Item> equipmentList) {
        mEquipmentList = equipmentList;
    }

    public void addEquipment(Item item){
        this.mEquipmentList.add(item);
    }
}
