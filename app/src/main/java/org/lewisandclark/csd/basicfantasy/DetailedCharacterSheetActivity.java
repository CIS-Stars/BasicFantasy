package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.*;

@SuppressWarnings("UnnecessaryLocalVariable")
public class DetailedCharacterSheetActivity extends AppCompatActivity {

    PlayerCharacter mPlayerCharacter;

    private TextView mTextViewName;
    private TextView mTextViewClass;
    private TextView mTextViewRace;
    private TextView mTextViewAge;
    private TextView mTextViewHeight;
    private TextView mTextViewWeight;
    private TextView mTextViewEyeColor;
    private TextView mTextViewHairColor;

    private TextView mTextViewPlayerName;
    private TextView mTextViewPlayerClass;
    private TextView mTextViewPlayerRace;
    private TextView mTextViewPlayerAge;
    private TextView mTextViewPlayerHeight;
    private TextView mTextViewPlayerWeight;
    private TextView mTextViewPlayerEyeColor;
    private TextView mTextViewPlayerHairColor;
    private TextView mTextViewPlayerMoney;



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

        //textViews that are titles for each entry
        mTextViewName = findViewById(R.id.text_view_name);
        mTextViewClass = findViewById(R.id.text_view_class);
        mTextViewRace = findViewById(R.id.text_view_race);
        mTextViewAge = findViewById(R.id.text_view_age);
        mTextViewHeight = findViewById(R.id.text_view_height);
        mTextViewWeight = findViewById(R.id.text_view_weight);
        mTextViewEyeColor = findViewById(R.id.text_view_eye_color);
        mTextViewHairColor = findViewById(R.id.text_view_hair_color);

        //textViews that show the value of each entry for the player
        mTextViewPlayerName = findViewById(R.id.text_view_player_name);
        mTextViewPlayerClass = findViewById(R.id.text_view_player_class);
        mTextViewPlayerRace = findViewById(R.id.text_view_player_race);
        mTextViewPlayerAge = findViewById(R.id.text_view_player_age);
        mTextViewPlayerHeight = findViewById(R.id.text_view_player_height);
        mTextViewPlayerWeight = findViewById(R.id.text_view_player_wieght);
        mTextViewPlayerEyeColor = findViewById(R.id.text_view_player_eye_color);
        mTextViewPlayerHairColor = findViewById(R.id.text_view_player_hair_color);
        mTextViewPlayerMoney = findViewById(R.id.text_view_player_money);

        mTextViewPlayerName.setText(mPlayerCharacter.getName());
        mTextViewPlayerClass.setText(mPlayerCharacter.getPlayerClass().getResId());
        mTextViewPlayerRace.setText(mPlayerCharacter.getRace().getResId());
        mTextViewPlayerAge.setText(mPlayerCharacter.getAge());
        mTextViewPlayerHeight.setText(mPlayerCharacter.getHeight());
        mTextViewPlayerWeight.setText(mPlayerCharacter.getWeight());
        mTextViewPlayerEyeColor.setText(mPlayerCharacter.get());
        mTextViewPlayerHeight.setText(mPlayerCharacter.getHeight());
        mTextViewPlayerWeight.setText(mPlayerCharacter.getWeight());
    }
}
