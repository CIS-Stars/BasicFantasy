package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.*;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CHA;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CON;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.DEX;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.INT;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.STR;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.WIS;

public class Page1Activity extends AppCompatActivity {
    private PlayerCharacter mCurrentCharacter;

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
    private TextView mTextViewCharismaMod;

    private TextView mTextViewDeathSaveScore;
    private TextView mTextViewMagicSaveScore;
    private TextView mTextViewParalysisSaveScore;
    private TextView mTextViewDragonSaveScore;
    private TextView mTextViewSpellSaveScore;



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
        mTextViewCharismaMod = findViewById(R.id.charisma_mod);

        mTextViewDeathSaveScore = findViewById(R.id.death_save_target_score);
        mTextViewMagicSaveScore = findViewById(R.id.magic_save_target_score);
        mTextViewParalysisSaveScore = findViewById(R.id.paralysis_save_target_score);
        mTextViewDragonSaveScore = findViewById(R.id.dragon_save_target_score);
        mTextViewSpellSaveScore = findViewById(R.id.spell_save_target_score);


        mTextViewCharacterName.setText(mCurrentCharacter.getName());
        mTextViewCharacterClass.setText(mCurrentCharacter.getCharacterClass().toString());
        mTextViewStrengthScore.setText(mCurrentCharacter.getStatArray()[STR.ordinal()].getScoreString());
        mTextViewStrengthMod.setText(mCurrentCharacter.getStatArray()[STR.ordinal()].getModifierString());
        mTextViewDexterityScore.setText(mCurrentCharacter.getStatArray()[DEX.ordinal()].getScoreString());
        mTextViewDexterityMod.setText(mCurrentCharacter.getStatArray()[DEX.ordinal()].getModifierString());
        mTextViewIntelligenceScore.setText(mCurrentCharacter.getStatArray()[INT.ordinal()].getScoreString());
        mTextViewIntelligenceMod.setText(mCurrentCharacter.getStatArray()[INT.ordinal()].getModifierString());
        mTextViewConstitutionScore.setText(mCurrentCharacter.getStatArray()[CON.ordinal()].getScoreString());
        mTextViewConstitutionMod.setText(mCurrentCharacter.getStatArray()[CON.ordinal()].getModifierString());
        mTextViewWisdomScore.setText(mCurrentCharacter.getStatArray()[WIS.ordinal()].getScoreString());
        mTextViewWisdomMod.setText(mCurrentCharacter.getStatArray()[WIS.ordinal()].getModifierString());
        mTextViewCharismaScore.setText(mCurrentCharacter.getStatArray()[CHA.ordinal()].getScoreString());
        mTextViewCharismaMod.setText(mCurrentCharacter.getStatArray()[CHA.ordinal()].getModifierString());

        mTextViewDeathSaveScore.setText(mCurrentCharacter.getDeathRayPoisonSaveString());
        mTextViewMagicSaveScore.setText(mCurrentCharacter.getWandSaveString());
        mTextViewParalysisSaveScore.setText(mCurrentCharacter.getParalysisStoneSaveString());
        mTextViewDragonSaveScore.setText(mCurrentCharacter.getDragonBreathSaveString());
        mTextViewSpellSaveScore.setText(mCurrentCharacter.getRodStaveSpellSaveString());
    }
}
