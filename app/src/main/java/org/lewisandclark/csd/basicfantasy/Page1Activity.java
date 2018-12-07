package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCharacters;
import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

public class Page1Activity extends AppCompatActivity {

    PlayerCharacter mCurrentCharacter;

    private TextView mTextViewCharacterName;
    private TextView mTextViewCharacterClass;
    private TextView mTextViewStrengthScore;
    private TextView mTextViewStrengthMod;
    private TextView mTextViewDexterityScore;
    private TextView mTextViewDexterityMod;
    private TextView mTextViewIntelligenceScore;
    private TextView mTextViewIntelligenceMod;
    private TextView mTextViewConstitutionScore;
    private TextView mTextViewConstitutionMod;
    private TextView mTextViewWisdomScore;
    private TextView mTextViewWisdomMod;
    private TextView mTextViewCharismaScore;
    private TextView mTextViewChrasismaMod;

    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, Page1Activity.class);
        //Intent Extras go here
        return theIntent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        mCurrentCharacter = sCharacters.get(sCurrentCharacterIndex);

        mTextViewCharacterName = findViewById(R.id.character_name);
        mTextViewCharacterClass = findViewById(R.id.character_class_and_level);
        mTextViewStrengthScore = findViewById(R.id.strength_score);
        mTextViewStrengthMod = findViewById(R.id.strength_mod);
        mTextViewDexterityScore = findViewById(R.id.dexterity_score);
        mTextViewDexterityMod = findViewById(R.id.dexterity_mod);
        mTextViewIntelligenceScore = findViewById(R.id.intelligence_score);
        mTextViewIntelligenceMod = findViewById(R.id.intelligence_mod);
        mTextViewConstitutionScore = findViewById(R.id.constitution_score);
        mTextViewConstitutionMod = findViewById(R.id.constitution_mod);
        mTextViewWisdomScore = findViewById(R.id.wisdom_score);
        mTextViewWisdomMod = findViewById(R.id.wisdom_mod);
        mTextViewCharismaScore = findViewById(R.id.charisma_score);
        mTextViewChrasismaMod = findViewById(R.id.charisma_mod);





    }
}
