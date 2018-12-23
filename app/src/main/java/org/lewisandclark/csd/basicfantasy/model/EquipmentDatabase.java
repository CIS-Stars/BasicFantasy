package org.lewisandclark.csd.basicfantasy.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thorin Schmidt on 12/22/2018.
 */
public class EquipmentDatabase {
    private static EquipmentDatabase sEquipmentDatabase;
    private List<Item> mItemList;
    private List<Armor> mArmorList;
    private List<Weapon> mWeaponList;
    private List<Shield> mShieldList;

    public static EquipmentDatabase getEquipmentDatabase(Context context){
        if (sEquipmentDatabase == null){
            sEquipmentDatabase = new EquipmentDatabase(context);
        }
        return sEquipmentDatabase;
    }

    private EquipmentDatabase(Context context){
        mItemList = new ArrayList<>();
        mArmorList = new ArrayList<>();
        mWeaponList = new ArrayList<>();
        mShieldList = new ArrayList<>();
    }
}
