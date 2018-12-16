package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.*;

@SuppressWarnings("UnnecessaryLocalVariable")
public class DetailedCharacterSheetActivity extends AppCompatActivity {

    private CharacterList sCharacters = CharacterList.getPlayerCharacter(this);
    PlayerCharacter mCurrentCharacter;

    private TextView mTextViewName;
    private TextView mTextViewClass;
    private TextView mTextViewRace;
    private TextView mTextViewAge;
    private TextView mTextViewHeight;
    private TextView mTextViewWeight;
    private TextView mTextViewEyeColor;
    private TextView mTextViewHairColor;

    private TextView mTextViewCurrentCharacterName;
    private TextView mTextViewCurrentCharacterClass;
    private TextView mTextViewCurrentCharacterRace;
    private TextView mTextViewCurrentCharacterAge;
    private TextView mTextViewCurrentCharacterHeight;
    private TextView mTextViewCurrentCharacterWeight;
    private TextView mTextViewCurrentCharacterEyeColor;
    private TextView mTextViewCurrentCharacterHairColor;
    private TextView mTextViewCurrentCharacterMoney;



    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, DetailedCharacterSheetActivity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_charactersheet);

        mCurrentCharacter = sCharacters.getPlayerCharacter(sCurrentCharacterIndex);

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
        mTextViewCurrentCharacterName = findViewById(R.id.text_view_player_name);
        mTextViewCurrentCharacterClass = findViewById(R.id.text_view_player_class);
        mTextViewCurrentCharacterRace = findViewById(R.id.text_view_player_race);
        mTextViewCurrentCharacterAge = findViewById(R.id.text_view_player_age);
        mTextViewCurrentCharacterHeight = findViewById(R.id.text_view_player_height);
        mTextViewCurrentCharacterWeight = findViewById(R.id.text_view_player_wieght);
        mTextViewCurrentCharacterEyeColor = findViewById(R.id.text_view_player_eye_color);
        mTextViewCurrentCharacterHairColor = findViewById(R.id.text_view_player_hair_color);
        mTextViewCurrentCharacterMoney = findViewById(R.id.text_view_player_money);

        mTextViewCurrentCharacterName.setText(mCurrentCharacter.getName());
        mTextViewCurrentCharacterClass.setText(mCurrentCharacter.getCharacterClass().getResId());
        mTextViewCurrentCharacterRace.setText(mCurrentCharacter.getRace().getResId());
        mTextViewCurrentCharacterAge.setText(String.valueOf(mCurrentCharacter.getAge()));
        mTextViewCurrentCharacterHeight.setText(String.valueOf(mCurrentCharacter.getHeight()));
        mTextViewCurrentCharacterWeight.setText(String.valueOf(mCurrentCharacter.getWeight()));
        mTextViewCurrentCharacterEyeColor.setText(mCurrentCharacter.getEyeColor());
        mTextViewCurrentCharacterHeight.setText(String.valueOf(mCurrentCharacter.getHeight()));
        mTextViewCurrentCharacterWeight.setText(String.valueOf(mCurrentCharacter.getWeight()));
    }
}
