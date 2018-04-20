package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<PlayerCharacter> sCharacters = new ArrayList<>();
    public static ArrayList<Armor> sArmors = new ArrayList<>();
    public static ArrayList<Item> sItems = new ArrayList<>();
    public static int sCurrentCharacterIndex;

    private Spinner mCharacterListSpinner;
    private Button mCreateCharacterButton;
    private Button mOpenCharacterButton;
    private Button mDeleteCharacterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sArmors.addAll(buildArmorList());
        sCurrentCharacterIndex = 0;
        sCharacters.add(new PlayerCharacter());

        List<String > characterList = new ArrayList<>();
        for(PlayerCharacter character : sCharacters ){
            characterList.add(character.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, characterList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCharacterListSpinner = findViewById(R.id.character_list_spinner);
        mCharacterListSpinner.setAdapter(adapter);

        mCreateCharacterButton = findViewById(R.id.create_button);
        mCreateCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sCurrentCharacterIndex = sCharacters.size();
                sCharacters.add(new PlayerCharacter(sCharacters.size()));
                Intent theIntent = RollAttributesActivity
                        .newIntent(HomeActivity.this);
                startActivity(theIntent);
            }
        });

        mCharacterListSpinner = findViewById(R.id.character_list_spinner);
        List<String> list = new ArrayList<String>();
        for(PlayerCharacter item: sCharacters){
            list.add(item.getName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCharacterListSpinner.setAdapter(dataAdapter);

        mOpenCharacterButton = findViewById(R.id.open_button);
        mOpenCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(HomeActivity.this, "Open Character Button clicked.",
                    //    Toast.LENGTH_SHORT).show();
                Intent theIntent = DetailedCharacterSheetActivity.newIntent(HomeActivity.this);
                startActivity(theIntent);
            }
        });

        mDeleteCharacterButton = findViewById(R.id.delete_button);
        mDeleteCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Delete Character Button clicked.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Armor> buildArmorList() {
        ArrayList<Armor> armorList = new ArrayList<>();

        armorList.add(new Armor(R.string.none,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.padded,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.hide,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.leather,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.studded,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.ring_mail,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.brigandine,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.chain_mail,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.scale,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.splint,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.banded,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.plate,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.field_plate,"",0,0,1,0,0,0,0));
        armorList.add(new Armor(R.string.full_plate,"",0,0,1,0,0,0,0));

        return armorList;
    }
}
