package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseRaceActivity extends AppCompatActivity {


    public static final String EXTRA_CURRENT_CHARACTER = "current character index";

    private int mCharacterIndex;
    private AttributeScore[] mStatArray;
    private Race mNewRace;

    private RadioGroup mRadioRaceGroup;
    private RadioButton mRadioDwarfButton;
    private RadioButton mRadioElfButton;
    private RadioButton mRadioHalflingButton;
    private RadioButton mRadioHumanButton;
    private RadioButton mRadioSelectedButton;
    private Button mAcceptButton;
    private Button mBackButton;

    public static Intent newIntent(Context packageContext, int index){
        Intent theIntent = new Intent(packageContext, ChooseRaceActivity.class);
        theIntent.putExtra(EXTRA_CURRENT_CHARACTER, index );
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_race);

        mCharacterIndex = getIntent().getIntExtra(EXTRA_CURRENT_CHARACTER, 0);
        mStatArray = HomeActivity.sCharacters.get(mCharacterIndex).getStatArray();

        mRadioRaceGroup = findViewById(R.id.radio_race_group);

        mRadioDwarfButton = findViewById(R.id.radio_dwarf);
        mRadioElfButton = findViewById(R.id.radio_elf);
        mRadioHalflingButton = findViewById(R.id.radio_halfling);
        mRadioHumanButton = findViewById(R.id.radio_human);
        mRadioHumanButton.setChecked(true);

        /** we need to deactivate ineligible races.
         *  if the attributes don't meet certain criteria, the player can't choose that race:
         *  Dwarves: must have CON at least 9, CHA maximum 17
         *  Elves: INT min of 9, CON max 17
         *  Halflings: DEX min 9, STR max 17
         *  Humans: no min or max
         */
        if(mStatArray[Attribute.CON.ordinal()].getScore() < 9
                || mStatArray[Attribute.CHA.ordinal()].getScore() > 17){mRadioDwarfButton.setEnabled(false);}
        if(mStatArray[Attribute.INT.ordinal()].getScore() < 9
                || mStatArray[Attribute.CON.ordinal()].getScore() > 17){mRadioElfButton.setEnabled(false);}
        if(mStatArray[Attribute.DEX.ordinal()].getScore() < 9
                || mStatArray[Attribute.STR.ordinal()].getScore() > 17){mRadioHalflingButton.setEnabled(false);}


        mAcceptButton = findViewById(R.id.accept_race_button);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = mRadioRaceGroup.getCheckedRadioButtonId();
                mRadioSelectedButton = findViewById(selectedId);

                switch(selectedId){

                    case R.id.radio_elf         :   mNewRace = Race.ELF;
                                                    break;
                    case R.id.radio_dwarf       :   mNewRace = Race.DWARF;
                                                    break;
                    case R.id.radio_halfling    :   mNewRace = Race.HALFLING;
                                                    break;
                    case R.id.radio_human       :   mNewRace = Race.HUMAN;
                                                    break;
                }

                HomeActivity.sCharacters.get(mCharacterIndex).setRace(mNewRace);

                Intent intent = ChooseClassActivity.newIntent(ChooseRaceActivity.this, mCharacterIndex);
                startActivity(intent);

                //testing button response
                //Toast.makeText(ChooseRaceActivity.this, mRadioSelectedButton.getText(),
                //        Toast.LENGTH_SHORT).show();
            }
        });

        mBackButton = findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
