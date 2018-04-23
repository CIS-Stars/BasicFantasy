package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.*;

@SuppressWarnings("UnnecessaryLocalVariable")
public class DetailedCharacterSheetActivity extends AppCompatActivity {

    PlayerCharacter mPlayerCharacter;

    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, DetailedCharacterSheetActivity.class);
        //Intent Extras go here
        return theIntent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_charactersheet);

        mPlayerCharacter = sCharacters.get(sCurrentCharacterIndex);




    }
}
