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
    public static int sCurrentCharacterIndex;

    private Spinner mCharacterListSpinner;
    private Button mCreateCharacterButton;
    private Button mOpenCharacterButton;
    private Button mDeleteCharacterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        mOpenCharacterButton = findViewById(R.id.open_button);
        mOpenCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Open Character Button clicked.",
                        Toast.LENGTH_SHORT).show();
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
}
