package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<PlayerCharacter> sCharacters = new ArrayList<PlayerCharacter>();
    public static int sCurrentCharacterIndex;

    private Button mCreateCharacter;
    private Button mChooseCharacterButton;
    private Spinner mChooseCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //testing characters
        sCharacters.add(new PlayerCharacter());
        sCurrentCharacterIndex = 0;

        mCreateCharacter = findViewById(R.id.create_button);
        mCreateCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sCurrentCharacterIndex = sCharacters.size();
                sCharacters.add(new PlayerCharacter(sCharacters.size()));
                Intent theIntent = RollAttributesActivity
                        .newIntent(HomeActivity.this, sCurrentCharacterIndex);
                startActivity(theIntent);
            }
        });
        mChooseCharacter = findViewById(R.id.spinner_choose_character);
        List<String> list = new ArrayList<String>();
        for(PlayerCharacter item: sCharacters){
            list.add(item.getName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseCharacter.setAdapter(dataAdapter);




    }
}
