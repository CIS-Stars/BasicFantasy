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
        mArmorList.addAll(buildArmorList());
        mShieldList.addAll(buildShieldList());
        mWeaponList.addAll(buildWeaponList());
    }

    public Item getEquipment(String itemName){

        for (Item item: mItemList) {
            if (itemName.equalsIgnoreCase(item.getNameID())) {
                return item;
            }
        }

        for (Item item: mArmorList){
            if(itemName.equalsIgnoreCase(item.getNameID())){
                return item;
            }
        }

        for (Item item: mShieldList){
            if(itemName.equalsIgnoreCase(item.getNameID())){
                return item;
            }
        }

        for (Item item: mWeaponList){
            if(itemName.equalsIgnoreCase(item.getNameID())){
                return item;
            }
        }
        return null;
    }

    public List<Armor> getArmorList() {
        return mArmorList;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public List<Weapon> getWeaponList() {
        return mWeaponList;
    }

    public List<Shield> getShieldList() {
        return mShieldList;
    }

    private ArrayList<Shield> buildShieldList() {
        ArrayList<Shield> list = new ArrayList<>();

        list.add(new Shield("Buckler", "", 2, 5, 1,
                1, 0, 0, 0));
        list.add(new Shield("Medium Shield", "", 5, 7, 1,
                1, 1, 0, 0));
        list.add(new Shield("Tower Shield", "", 12, 15, 1,
                1, 3, 0, 0));

        return list;
    }

    private ArrayList<Armor> buildArmorList() {
        ArrayList<Armor> armorList = new ArrayList<>();

        armorList.add(new Armor("Padded","",10,15,1,
                12,12,0,0));
        armorList.add(new Armor("Hide","",30,10,1,
                13,13,0,0));
        armorList.add(new Armor("Leather","",15,20,1,
                13,13,0,0));
        armorList.add(new Armor("Studded Leather","",25,30,1,
                14,14,0,0));
        armorList.add(new Armor("Ring Mail","",30,25,1,
                14,14,0,0));
        /*armorList.add(new Armor(R.string.brigandine,"",30,80,1,
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
                19,19,0,0));*/

        return armorList;
    }

    private ArrayList<Weapon> buildWeaponList(){
        ArrayList<Weapon> list = new ArrayList<>();

        list.add(new Weapon("Hand Axe", 4, 5, 6, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon("Battle Axe", 7, 7, 8, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon("Great Axe", 14, 15, 10, 1, 0,
                0, "", true, false, 0, 0,
                0, ""));
        list.add(new Weapon("Pickaxe", 6, 4, 6, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));
        list.add(new Weapon("Mattock", 8, 6, 8, 1, 0,
                0, "", false, false, 0, 0,
                0, ""));

        return list;
    }
}
