package org.lewisandclark.csd.basicfantasy.model;

import org.lewisandclark.csd.basicfantasy.R;

import java.io.Serializable;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public enum CharacterClass implements Serializable {

    CLERIC(R.string.cleric),
    FIGHTER(R.string.fighter),
    MAGIC_USER(R.string.magic_user),
    THIEF(R.string.thief),
    FIGHTER_MU(R.string.fighter_magic_user),
    MU_THIEF(R.string.magic_user_thief);

    private int mResId;

    CharacterClass(int resId) {
        mResId = resId;
    }

    public int getResId() {
        return mResId;
    }
}
