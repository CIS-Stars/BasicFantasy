package org.lewisandclark.csd.basicfantasy;

import java.io.Serializable;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public enum Race implements Serializable {

    DWARF(R.string.dwarf),
    ELF(R.string.elf),
    HALFLING(R.string.halfling),
    HUMAN(R.string.human);

    private int mResId;

    Race(int resId) {
        mResId = resId;
    }

    public int getResId() {
        return mResId;
    }
}
