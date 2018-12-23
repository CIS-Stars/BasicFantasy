package org.lewisandclark.csd.basicfantasy.model;

import android.content.Context;

import org.lewisandclark.csd.basicfantasy.R;

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
        mArmorList.addAll(buildArmorList());
        mShieldList.addAll(buildShieldList());
        mWeaponList.addAll(buildWeaponList());
    }

    private ArrayList<Shield> buildShieldList() {
        ArrayList<Shield> list = new ArrayList<>();

        list.add(new Shield(R.string.buckler, "", 2, 5, 1,
                1, 0, 0, 0));
        list.add(new Shield(R.string.medium, "", 5, 7, 1,
                1, 1, 0, 0));
        list.add(new Shield(R.string.tower, "", 12, 15, 1,
                1, 3, 0, 0));

        return list;
    }

    private ArrayList<Armor> buildArmorList() {
        ArrayList<Armor> armorList = new ArrayList<>();

        armorList.add(new Armor(R.string.padded,"",10,15,1,
                12,12,0,0));
        armorList.add(new Armor(R.string.hide,"",30,10,1,
                13,13,0,0));
        armorList.add(new Armor(R.string.leather,"",15,20,1,
                13,13,0,0));
        armorList.add(new Armor(R.string.studded,"",25,30,1,
                14,14,0,0));
        armorList.add(new Armor(R.string.ring_mail,"",30,25,1,
                14,14,0,0));
        armorList.add(new Armor(R.string.brigandine,"",30,80,1,
                15,15,0,0));
        armorList.add(new Armor(R.string.chain_mail,"",40,60,1,
                15,15,0,0));
        armorList.add(new Armor(R.string.scale,"",55,80,1,
                16,16,0,0));
        armorList.add(new Armor(R.string.splint,"",45,100,1,
                16,16,0,0));
        armorList.add(new Armor(R.string.banded,"",35,200,1,
                16,16,0,0));
        armorList.add(new Armor(R.string.plate,"",50,300,1,
                17,17,0,0));
        armorList.add(new Armor(R.string.field_plate,"",70,500,1,
                18,18,0,0));
        armorList.add(new Armor(R.string.full_plate,"",80,1500,1,
                19,19,0,0));

        return armorList;
    }

    private ArrayList<Weapon> buildWeaponList(){
        ArrayList<Weapon> list = new ArrayList<>();

        list.add(new Weapon(R.string.hand_axe, 4, 5, 6, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon(R.string.battle_axe, 7, 7, 8, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon(R.string.great_axe, 14, 15, 10, 1, 0,
                0, "", true, false, 0, 0,
                0, ""));
        list.add(new Weapon(R.string.pickaxe, 6, 4, 6, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon(R.string.mattock, 8, 6, 8, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));

        return list;
    }
}
