package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.lewisandclark.csd.basicfantasy.model.AttributeScore;
import org.lewisandclark.csd.basicfantasy.model.CharacterClass;
import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.Race;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

public class ChooseClassActivity extends AppCompatActivity {

    private CharacterList sCharacters = CharacterList.getPlayerCharacter(this);
    private RadioGroup mRadioClassGroup;

    private RadioButton mRadioClericButton;
    private RadioButton mRadioFighterButton;
    private RadioButton mRadioMagicUserButton;
    private RadioButton mRadioThiefButton;
    private RadioButton mRadioFighterMUButton;
    private RadioButton mRadioMUThiefButton;


    private Button mAcceptButton;
    private Button mBackButton;

    private AttributeScore[] mStatArray;
    private Race mRace;
    private CharacterClass mNewClass;
    private int mNewHitDie;

    public static Intent newIntent(Context packageContext){
        //Intent theIntent = new Intent(packageContext, ChooseClassActivity.class);
        //Intent Extras go here
        //return theIntent;
        return new Intent(packageContext, ChooseClassActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        mStatArray = sCharacters.getPlayerCharacter(sCurrentCharacterIndex).getStatArray();
        mRace = sCharacters.getPlayerCharacter(sCurrentCharacterIndex).getRace();

        mRadioClassGroup = findViewById(R.id.radio_class_group);

        mRadioClericButton = findViewById(R.id.radio_cleric);
        mRadioFighterButton = findViewById(R.id.radio_fighter);
        mRadioMagicUserButton = findViewById(R.id.radio_magic_user);
        mRadioThiefButton = findViewById(R.id.radio_thief);
        mRadioFighterMUButton = findViewById(R.id.radio_fighter_magic_user);
        mRadioMUThiefButton = findViewById(R.id.radio_magic_user_thief);

        mRadioFighterButton.setChecked(true);

        /*deactivate ineligible class buttons
           if the characgter is a dwarf or halfing, they can't be a magic-user.
           also, unless the chaacter is an elf, they can't be a multi-class
              (fighter/MU, or MU/Thief)
         */
        if(mRace == Race.DWARF || mRace == Race.HALFLING){
            mRadioClericButton.setEnabled(false);
        }
        if(mRace != Race.ELF){
            mRadioMUThiefButton.setEnabled(false);
            mRadioFighterMUButton.setEnabled(false);
        }


        mAcceptButton = findViewById(R.id.accept_class_button);
        mAcceptButton.setOnClickListener(view -> {
            int selectedId = mRadioClassGroup.getCheckedRadioButtonId();

            switch(selectedId){

                case R.id.radio_cleric          :   mNewClass = CharacterClass.CLERIC;
                                                    mNewHitDie = 6;
                                                    break;
                case R.id.radio_fighter         :   mNewClass = CharacterClass.FIGHTER;
                                                    mNewHitDie = 8;
                    break;
                case R.id.radio_magic_user      :   mNewClass = CharacterClass.MAGIC_USER;
                    mNewHitDie = 4;
                    break;
                case R.id.radio_thief           :   mNewClass = CharacterClass.THIEF;
                    mNewHitDie = 4;
                    break;
                case R.id.radio_fighter_magic_user : mNewClass = CharacterClass.FIGHTER_MU;
                    mNewHitDie = 6;
                    break;
                case R.id.radio_magic_user_thief : mNewClass = CharacterClass.MU_THIEF;
                    mNewHitDie = 4;
                    break;

            }
            // Elf and Halfling can only have max hitdie of 6
            if ((sCharacters.getPlayerCharacter(sCurrentCharacterIndex).getRace()==Race.ELF ||
                    sCharacters.getPlayerCharacter(sCurrentCharacterIndex).getRace()==Race.HALFLING)
                    && mNewHitDie > 6){
                mNewHitDie = 6;
            }

            sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setCharacterClass(mNewClass);
            sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setHitDie(mNewHitDie);

            Intent intent = EnterPersonalInfoActivity.newIntent(ChooseClassActivity.this);
            startActivity(intent);
        });

        mBackButton = findViewById(R.id.back_button);
        mBackButton.setOnClickListener(view -> finish());

    }



}
