package org.lewisandclark.csd.basicfantasy;

import java.util.HashMap;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public class PlayerCharacter {

    //Standard non-crucial stuff
    private String mName;
    private String mSex;
    private String mAge;
    private int mLevel;
    private int mXP;

    //Hashmaps
    private HashMap<Attribute, AttributeScore> mAttributes = new HashMap<>();
    private HashMap<Money, Integer> mMoney = new HashMap<>();


    private int mTotalHitPoints;
    private int mCurrentHitPoints;

    private Race mRace;
    private CharacterClass mClass;

    private int mArmorClass;

    private int mBaseAttackBonus;
    private int mCurrentAttackBonus;

    private int mBaseMovement;
    private int mCurrentMovement;




}
