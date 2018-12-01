package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.lewisandclark.csd.basicfantasy.model.Armor;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;
import org.lewisandclark.csd.basicfantasy.model.Shield;
import org.lewisandclark.csd.basicfantasy.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<PlayerCharacter> sCharacters = new ArrayList<>();
    public static ArrayList<Item> sItems = new ArrayList<>();
    public static ArrayList<Armor> sArmors = new ArrayList<>();
    public static ArrayList<Shield> sShields = new ArrayList<>();
    public static ArrayList<Weapon> sWeapons = new ArrayList<>();

    public static int sCurrentCharacterIndex;

    private Spinner mCharacterListSpinner;
    private Button mCreateCharacterButton;
    private Button mOpenCharacterButton;
    private Button mDeleteCharacterButton;
    private Button mBuyEquipmentButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sArmors.addAll(buildArmorList());
        sShields.addAll(buildShieldList());
        sWeapons.addAll(buildWeaponList());
        sCurrentCharacterIndex = 0;
        sCharacters.add(new PlayerCharacter());

        List<String > characterList = new ArrayList<>();
        for(PlayerCharacter character : sCharacters ){
            characterList.add(character.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, characterList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCharacterListSpinner = findViewById(R.id.character_list_spinner);
        mCharacterListSpinner.setAdapter(adapter);

        mCreateCharacterButton = findViewById(R.id.create_button);
        mCreateCharacterButton.setOnClickListener(view -> {
            sCurrentCharacterIndex = sCharacters.size();
            sCharacters.add(new PlayerCharacter(sCharacters.size()));
            Intent theIntent = RollAttributesActivity
                    .newIntent(HomeActivity.this);
            startActivity(theIntent);
        });

        mOpenCharacterButton = findViewById(R.id.open_button);
        mOpenCharacterButton.setOnClickListener(view -> {
            Intent theIntent = DetailedCharacterSheetActivity.newIntent(HomeActivity.this);
            startActivity(theIntent);
        });

        mDeleteCharacterButton = findViewById(R.id.delete_button);
        mDeleteCharacterButton.setOnClickListener(view -> Toast.makeText(HomeActivity.this,
                "Delete Character Button clicked.",
                Toast.LENGTH_SHORT).show());

        mBuyEquipmentButton = findViewById(R.id.buy_equipment_button);
        mBuyEquipmentButton.setOnClickListener(view -> {
            Intent theIntent = BuyEquipmentActivity.newIntent(HomeActivity.this);
            startActivity(theIntent);
        });
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
