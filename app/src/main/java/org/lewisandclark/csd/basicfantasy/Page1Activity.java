package org.lewisandclark.csd.basicfantasy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;
import org.lewisandclark.csd.basicfantasy.utils.DieRoller;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.*;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CHA;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.CON;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.DEX;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.INT;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.STR;
import static org.lewisandclark.csd.basicfantasy.model.Attribute.WIS;

public class Page1Activity extends AppCompatActivity {

    static final String TAG = "Page1Activity";

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

    private LinearLayout mLayoutStrength;
    private LinearLayout mLayoutDexterity;
    private LinearLayout mLayoutIntelligence;
    private LinearLayout mLayoutConstitution;
    private LinearLayout mLayoutWisdom;
    private LinearLayout mLayoutCharisma;

    private TextView mLinearLayoutDeathSave;
    private TextView mLinearLayoutMagicSave;
    private TextView mLinearLayoutParalysisSave;
    private TextView mLinearLayoutDragonSave;
    private TextView mLinearLayoutSpellSave;

    private TextView mTextViewLeftNavigate;
    private TextView mTextViewRightNavigate;

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

        mLayoutStrength = findViewById(R.id.strength_layout);
        mLayoutDexterity = findViewById(R.id.dexterity_layout);
        mLayoutIntelligence = findViewById(R.id.intelligence_layout);
        mLayoutConstitution = findViewById(R.id.constitution_layout);
        mLayoutWisdom = findViewById(R.id.wisdom_layout);
        mLayoutCharisma = findViewById(R.id.charisma_layout);

        mLinearLayoutDeathSave = findViewById(R.id.death_save);
        mLinearLayoutMagicSave = findViewById(R.id.magic_save);
        mLinearLayoutParalysisSave = findViewById(R.id.paralysis_save);
        mLinearLayoutDragonSave = findViewById(R.id.dragon_save);
        mLinearLayoutSpellSave = findViewById(R.id.spell_save);

        mTextViewLeftNavigate = findViewById(R.id.left_button);
        mTextViewRightNavigate = findViewById(R.id.right_button);

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

        mLinearLayoutDeathSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Death Ray or Poison", mCurrentCharacter.getDeathRayPosionMod(),
                        mCurrentCharacter.getDeathRayPoisonSave());
            }
        });

        mLinearLayoutMagicSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Magic Wands", mCurrentCharacter.getWandMod(),
                        mCurrentCharacter.getWandSave());
            }
        });

        mLinearLayoutParalysisSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Paralysis or Turn to Stone", mCurrentCharacter.getParalysisStoneMod(),
                        mCurrentCharacter.getParalysisStoneSave());
            }
        });

        mLinearLayoutDragonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Dragon Breath", mCurrentCharacter.getDragonBreathMod(),
                        mCurrentCharacter.getDragonBreathSave());
            }
        });


        mLinearLayoutSpellSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Rods, Staves, and Spells", mCurrentCharacter.getRodStaveSpellMod(),
                        mCurrentCharacter.getRodStaveSpellSave());
            }
        });

        mLayoutStrength.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Strength", mCurrentCharacter.getStatArray()[STR.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mLayoutDexterity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Dexterity", mCurrentCharacter.getStatArray()[DEX.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mLayoutIntelligence.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Intelligence", mCurrentCharacter.getStatArray()[INT.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mLayoutConstitution.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Constitution", mCurrentCharacter.getStatArray()[CON.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mLayoutWisdom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Wisdom", mCurrentCharacter.getStatArray()[WIS.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mLayoutCharisma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog("Charisma", mCurrentCharacter.getStatArray()[CHA.ordinal()].getModifier(),
                        mCurrentCharacter.getAbilityRoll());
            }
        });

        mTextViewLeftNavigate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //open left screen
                Intent i = Page2Activity.newIntent(Page1Activity.this);
                startActivity(i);
                overridePendingTransition(R.anim.left_to_right_in, R.anim.left_to_right_out);
            }
        });

        mTextViewRightNavigate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //open right screen
                Intent i = Page2Activity.newIntent(Page1Activity.this);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_in, R.anim.right_to_left_out);
            }
        });
    }


    public void openDialog(String title, int mod, int target){

        int roll = DieRoller.d20();
        String modString;

        if (mod > -1){
            modString = "+"+String.valueOf(mod);
        }
        else {
            modString = String.valueOf(mod);
        }

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        TextView mTextViewTitle = new TextView(this);
        mTextViewTitle.setText(title);
        mTextViewTitle.setPadding(3, 3, 3, 10);
        mTextViewTitle.setGravity(Gravity.CENTER);
        mTextViewTitle.setTextColor(Color.BLUE);
        mTextViewTitle.setTextSize(20);
        alertDialog.setCustomTitle(mTextViewTitle);

        TextView msg = new TextView(this);

        msg.setText("Target Score:  "+String.valueOf(target)+
                "\nYour roll:  "+ String.valueOf(roll)+modString+
                " = "+String.valueOf(roll+mod));
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        msg.setTextSize(18);
        alertDialog.setView(msg);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //no action to perform
            }
        });

        new Dialog(getApplicationContext());
        alertDialog.show();

        //set properties of the OK button
        final Button okButton = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralButtonLP = (LinearLayout.LayoutParams) okButton.getLayoutParams();
        okButton.setTextColor(Color.BLUE);
        okButton.setLayoutParams(neutralButtonLP);
    }


}
