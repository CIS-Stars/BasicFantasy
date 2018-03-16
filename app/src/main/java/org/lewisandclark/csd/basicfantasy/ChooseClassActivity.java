package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ChooseClassActivity extends AppCompatActivity {
    public static final String EXTRA_CURRENT_CHARACTER = "current character index";

    private int mCharacterIndex;
    private AttributeScore[] mStatArray;
    private Race mRace;

    public static Intent newIntent(Context packageContext, int index){
        Intent theIntent = new Intent(packageContext, ChooseClassActivity.class);
        theIntent.putExtra(EXTRA_CURRENT_CHARACTER, index );
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        mCharacterIndex = getIntent().getIntExtra(EXTRA_CURRENT_CHARACTER, 0);
        mStatArray = HomeActivity.sCharacters.get(mCharacterIndex).getStatArray();
        mRace = HomeActivity.sCharacters.get(mCharacterIndex).getRace();

        //deactivate ineligible class buttons
        if(mRace == Race.DWARF || mRace == Race.HALFLING){

        }



    }
}
