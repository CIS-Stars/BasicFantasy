package org.lewisandclark.csd.basicfantasy;

import java.io.Serializable;

/**
 * Created by Thorin Schmidt on 2/22/2018.
 */

public enum Money implements Serializable{

    COPPER(R.string.copper),
    SILVER(R.string.silver),
    ELECTRUM(R.string.electrum),
    GOLD(R.string.gold),
    PLATINUM(R.string.platinum);

    private int mResId;

    Money(int resId) {
        mResId = resId;
    }

    public int getResId() {
        return mResId;
    }
}
