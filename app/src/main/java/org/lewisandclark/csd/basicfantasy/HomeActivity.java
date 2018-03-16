package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<PlayerCharacter> sCharacters = new ArrayList<PlayerCharacter>();


    private Button mCreateCharacter;
    private int mCurrentCharacterIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mCreateCharacter = findViewById(R.id.create_button);
        mCreateCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentCharacterIndex = sCharacters.size();
                sCharacters.add(new PlayerCharacter(sCharacters.size()));
                Intent theIntent = RollAttributesActivity
                        .newIntent(HomeActivity.this, mCurrentCharacterIndex);
                startActivity(theIntent);
            }
        });
    }
}
