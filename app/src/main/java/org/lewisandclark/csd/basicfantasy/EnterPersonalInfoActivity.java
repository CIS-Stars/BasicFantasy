package org.lewisandclark.csd.basicfantasy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.utils.DieRoller;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

public class EnterPersonalInfoActivity extends AppCompatActivity {

    private final String[] EYE_COLOR = {"Blue", "Hazel", "Brown", "Black", "Red", "Gray", "Aqua",
            "Purple", "Yellow", "Copper", "Green"};
    private final String[] HAIR_COLOR = {"Blonde", "Blue", "Brown", "Black", "Red", "Gray","Yellow",
            "Copper", "Green"};

    private CharacterList sCharacters = CharacterList.getPlayerCharacter(this);

    private Button mClearButton;
    private Button mSaveButton;
    private Button mBackButton;
    private Button mRollEyeColor;
    private Button mRollHairColor;
    private Button mRollAge;
    private Button mRollHeight;
    private Button mRollWeight;

    private EditText mEditName;
    private EditText mEditAge;
    private EditText mEditHeight;
    private EditText mEditWeight;
    private EditText mEditEyeColor;
    private EditText mEditHairColor;

    public static Intent newIntent(Context packageContext){
        //Intent theIntent = new Intent(packageContext, EnterPersonalInfoActivity.class);
        //Intent Extras go here
        //return theIntent;
        return new Intent(packageContext, EnterPersonalInfoActivity.class);
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_personal_info);

        mEditName = findViewById(R.id.name_editbox);
        mEditAge = findViewById(R.id.age_editbox);
        mEditHeight = findViewById(R.id.height_editbox);
        mEditWeight = findViewById(R.id.weight_editbox);
        mEditEyeColor = findViewById(R.id.eye_color_editbox);
        mEditHairColor = findViewById(R.id.hair_color_editbox);

        mRollAge = findViewById(R.id.age_button);
        mRollAge.setOnClickListener(view -> mEditAge.setText(Integer.toString(20)));

        mRollHeight = findViewById(R.id.height_button);
        mRollHeight.setOnClickListener(view -> mEditHeight.setText(Integer.toString(72)));

        mRollWeight = findViewById(R.id.weight_button);
        mRollWeight.setOnClickListener(view -> mEditWeight.setText(Integer.toString(200)));

        mRollEyeColor = findViewById(R.id.eye_color_button);
        mRollEyeColor.setOnClickListener(view -> mEditEyeColor.setText(EYE_COLOR[DieRoller.rollIndex(EYE_COLOR.length)]));

        mRollHairColor = findViewById(R.id.hair_color_button);
        mRollHairColor.setOnClickListener(view -> mEditHairColor.setText(HAIR_COLOR[DieRoller.rollIndex(HAIR_COLOR.length)]));

        mClearButton = findViewById(R.id.clear_fields_button);
        mClearButton.setOnClickListener(view -> {
            mEditName.setText("");
            mEditAge.setText("");
            mEditHeight.setText("");
            mEditWeight.setText("");
            mEditEyeColor.setText("");
            mEditHairColor.setText("");
        });

        mBackButton = findViewById(R.id.back_button);
        mBackButton.setOnClickListener(view -> finish());

        mSaveButton = findViewById(R.id.save_info_button);
        mSaveButton.setOnClickListener(view -> {
            int count =0;
            try {

                //count 0
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setName(mEditName.getText().toString());
                count++; //count 1
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setAge(Integer.parseInt(mEditAge.getText().toString()));
                count++;
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setHeight(Integer.parseInt(mEditHeight.getText().toString()));
                count++;
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setWeight(Integer.parseInt(mEditWeight.getText().toString()));
                count++;
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setName(mEditEyeColor.getText().toString());
                count++;
                sCharacters.getPlayerCharacter(sCurrentCharacterIndex).setName(mEditHairColor.getText().toString());
                count++;

                Intent intent = BuyEquipmentActivity.newIntent(EnterPersonalInfoActivity.this);
                count++;
                startActivity(intent);
            }
            catch (Exception e){
                String msg = "Something went wrong with the save: " + count;
                Toast.makeText(EnterPersonalInfoActivity.this, msg ,Toast.LENGTH_SHORT).show();
                Log.d("SAVE", msg);
            }
        });
    }
}
