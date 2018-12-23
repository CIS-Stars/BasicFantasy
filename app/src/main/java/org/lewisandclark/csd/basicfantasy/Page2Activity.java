package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

public class Page2Activity extends AppCompatActivity {

    private TextView mTextViewLeftNavigate;
    private TextView mTextViewRightNavigate;
    private TextView mHPMaxScore;
    private TextView mHPCurrentScore;
    private TextView mACScore;

    private CharacterList sCharacters = CharacterList.getPlayerCharacterList(this);
    private PlayerCharacter mCurrentCharacter;


    public static Intent newIntent(Context packageContext) {
        Intent theIntent = new Intent(packageContext, Page2Activity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        mCurrentCharacter = sCharacters.getPlayerCharacter(sCurrentCharacterIndex);
        mHPMaxScore.setText(Integer.toString(mCurrentCharacter.getTotalHitPoints()));
        mHPCurrentScore.setText(Integer.toString(mCurrentCharacter.getCurrentHitPoints()));
        mACScore.setText(Integer.toString(mCurrentCharacter.getArmorClass()));

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
