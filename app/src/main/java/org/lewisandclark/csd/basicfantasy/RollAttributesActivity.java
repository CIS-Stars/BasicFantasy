package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RollAttributesActivity extends AppCompatActivity {

    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, RollAttributesActivity.class);
        return theIntent;
    }

    public static final String TAG = "RollAttributesActivity";

    private Button mRollStats;
    private Button mAcceptStats;
    private TextView mStrTextView;
    private TextView mIntTextView;
    private TextView mWisTextView;
    private TextView mDexTextView;
    private TextView mConTextView;
    private TextView mChaTextView;

    private int[] mStatArray = {0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_attributes);

        mStrTextView = findViewById(R.id.str_score);
        mStrTextView.setText(Integer.toString(mStatArray[0]));

        mIntTextView = findViewById(R.id.int_score);
        mIntTextView.setText(Integer.toString(mStatArray[1]));

        mWisTextView = findViewById(R.id.wis_score);
        mWisTextView.setText(Integer.toString(mStatArray[2]));

        mDexTextView = findViewById(R.id.dex_score);
        mDexTextView.setText(Integer.toString(mStatArray[3]));

        mConTextView = findViewById(R.id.con_score);
        mConTextView.setText(Integer.toString(mStatArray[4]));

        mChaTextView = findViewById(R.id.cha_score);
        mChaTextView.setText(Integer.toString(mStatArray[5]));

        mRollStats = findViewById(R.id.roll_stats_button);
        mRollStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //generate the random stats
                Log.d(TAG, "RollStats clicked.");
                for (int i=0; i<mStatArray.length; i++){
                    mStatArray[i] = DieRoller.statRoll();
                }

                mStrTextView.setText(Integer.toString(mStatArray[0]));
                mIntTextView.setText(Integer.toString(mStatArray[1]));
                mWisTextView.setText(Integer.toString(mStatArray[2]));
                mDexTextView.setText(Integer.toString(mStatArray[3]));
                mConTextView.setText(Integer.toString(mStatArray[4]));
                mChaTextView.setText(Integer.toString(mStatArray[5]));

            }
        });

        mAcceptStats = findViewById(R.id.accept_stats_button);
        mAcceptStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //put stats into player character record.
                Log.d(TAG, "AcceptStats clicked.");
            }
        });




    }
}
