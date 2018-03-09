package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseRaceActivity extends AppCompatActivity {

    public static final String EXTRA_STAT_ARRAY = "stat_array";
    private static final int STR = 0;
    private static final int INT = 1;
    private static final int WIS = 2;
    private static final int DEX = 3;
    private static final int CON = 4;
    private static final int CHA = 5;

    // order of STAT values in array: [STR, INT, WIS, DEX, CON, CHA]
    private int[] mStatArray;


    private RadioGroup mRadioRaceGroup;
    private RadioButton mRadioDwarfButton;
    private RadioButton mRadioElfButton;
    private RadioButton mRadioHalflingButton;
    private RadioButton mRadioHumanButton;
    private RadioButton mRadioSelectedButton;
    private Button mAcceptButton;
    private Button mBackButton;

    public static Intent newIntent(Context packageContext, int[] statArray){
        Intent theIntent = new Intent(packageContext, ChooseRaceActivity.class);
        theIntent.putExtra(EXTRA_STAT_ARRAY, statArray );
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_race);

        mStatArray = getIntent().getIntArrayExtra(EXTRA_STAT_ARRAY);
        for(int stat : mStatArray){
            Log.d("STAT:", " "+ stat );
        }

        mRadioRaceGroup = findViewById(R.id.radio_race_group);

        mRadioDwarfButton = findViewById(R.id.radio_dwarf);
        mRadioElfButton = findViewById(R.id.radio_elf);
        mRadioHalflingButton = findViewById(R.id.radio_halfling);
        mRadioHumanButton = findViewById(R.id.radio_human);

        /** we need to deactivate ineligible races.
         *  if the attributes don't meet certain criteria, the player can't choose that race:
         *  Dwarves: must have CON at least 9, CHA maximum 17
         *  Elves: INT min of 9, CON max 17
         *  Halflings: DEX min 9, STR max 17
         *  Humans: no min or max
         */
        if(mStatArray[CON]< 9 || mStatArray[CHA]>17){mRadioDwarfButton.setEnabled(false);}
        if(mStatArray[INT]< 9 || mStatArray[CON]>17){mRadioElfButton.setEnabled(false);}
        if(mStatArray[DEX]< 9 || mStatArray[STR]>17){mRadioHalflingButton.setEnabled(false);}


        mAcceptButton = findViewById(R.id.accept_race_button);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = mRadioRaceGroup.getCheckedRadioButtonId();
            }
        });

    }
}
