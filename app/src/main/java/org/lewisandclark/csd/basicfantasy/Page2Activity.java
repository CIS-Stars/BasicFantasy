package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Page2Activity extends AppCompatActivity {

    private TextView mTextViewLeftNavigate;
    private TextView mTextViewRightNavigate;


    public static Intent newIntent(Context packageContext) {
        Intent theIntent = new Intent(packageContext, Page2Activity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        mTextViewLeftNavigate = findViewById(R.id.left_button);
        mTextViewRightNavigate = findViewById(R.id.right_button);

        mTextViewLeftNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open left screen
                Intent i = Page1Activity.newIntent(Page2Activity.this);
                startActivity(i);
                overridePendingTransition(R.anim.left_to_right_in, R.anim.left_to_right_out);
            }
        });

        mTextViewRightNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open right screen
                Intent i = Page1Activity.newIntent(Page2Activity.this);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_in, R.anim.right_to_left_out);
            }
        });

    }
}
