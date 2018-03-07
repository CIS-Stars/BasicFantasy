package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ChooseRaceActivity extends AppCompatActivity {

    public static final String EXTRA_STAT_ARRAY = "stat_array";

    private int[] mStatArray;

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
    }
}
