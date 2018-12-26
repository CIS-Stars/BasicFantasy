package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.EquipmentDatabase;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

public class HomeActivity extends AppCompatActivity {

    public static Intent newIntent(Context packageContext, int index){
        Intent theIntent = new Intent(packageContext, HomeActivity.class);
        //Intent Extras go here
        theIntent.putExtra("HomeActivityIndex", index);
        return theIntent;
    }

    private CharacterList sCharacters = CharacterList.getPlayerCharacterList(this);
    private EquipmentDatabase sEquipmentDatabase = EquipmentDatabase.getEquipmentDatabase(this);

    public static int sCurrentCharacterIndex;

    private PlayerCharacter mCurrentCharacter;
    private TextView mCurrentCharacterName;
    private Button mChooseCharacterButton;
    private Button mCreateCharacterButton;
    private Button mOpenCharacterButton;
    private Button mDeleteCharacterButton;
    private Button mBuyEquipmentButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.d("HOME","Character Array is size: " +
                sCharacters.getList().size());
        Item testItem = sEquipmentDatabase.getEquipment("Hand Axe");
        Log.d("EQUIPMENT", testItem.getNameID());
        sCurrentCharacterIndex =
                getIntent().getIntExtra("HomeActivityIndex", 0);

        if (sCharacters.getList().size() == 0) {
            Log.d("HOME", "Size is Zero.");
            sCharacters.addCharacter(new PlayerCharacter());
            sCharacters.addCharacter(new PlayerCharacter("Marcia of Xant"));
            mCurrentCharacter = sCharacters.getPlayerCharacter(0);
            //mCurrentCharacter.addEquipment(sWeapons.);
            sCharacters.updateCharacter(mCurrentCharacter,0);
        }

        Log.d("HOME", "Current character index: " + Integer.toString(sCurrentCharacterIndex));
        Log.d("HOME", "Character Array Size: "+ Integer.toString(sCharacters.getList().size()));
        mCurrentCharacter = sCharacters.getPlayerCharacter(sCurrentCharacterIndex);

        mCurrentCharacterName = findViewById(R.id.currentCharacter);
        mCurrentCharacterName.setText(String.format(mCurrentCharacter.getName()));

        mChooseCharacterButton = (Button) findViewById(R.id.choose_button);
        mChooseCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent =
                        ChooseCurrentCharacterActivity.newIntent(HomeActivity.this,
                                sCurrentCharacterIndex);
                startActivity(theIntent);
            }
        });

        mCreateCharacterButton = findViewById(R.id.create_button);
        mCreateCharacterButton.setOnClickListener(view -> {
            sCurrentCharacterIndex = sCharacters.sizeOf();
            sCharacters.addCharacter(new PlayerCharacter(sCharacters.sizeOf()));
            Intent theIntent = RollAttributesActivity
                    .newIntent(HomeActivity.this);
            startActivity(theIntent);
        });

        mOpenCharacterButton = findViewById(R.id.open_button);
        mOpenCharacterButton.setOnClickListener(view -> {
            Intent theIntent = Page1Activity.newIntent(HomeActivity.this);
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
}
