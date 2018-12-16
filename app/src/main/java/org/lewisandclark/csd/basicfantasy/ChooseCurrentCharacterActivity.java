package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import org.lewisandclark.csd.basicfantasy.model.Armor;
import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;
import org.lewisandclark.csd.basicfantasy.model.Shield;
import org.lewisandclark.csd.basicfantasy.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class ChooseCurrentCharacterActivity extends AppCompatActivity {


    private CharacterList sCharacters = CharacterList.getPlayerCharacter(this);
    public static ArrayList<Item> sItems = new ArrayList<>();
    public static ArrayList<Armor> sArmors = new ArrayList<>();
    public static ArrayList<Shield> sShields = new ArrayList<>();
    public static ArrayList<Weapon> sWeapons = new ArrayList<>();

    public static int sCurrentCharacterIndex;

    private LinearLayout mCharactersView;
    private List<CheckedTextView> mCharactersCheckedTextViews = new ArrayList<>();

    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, ChooseCurrentCharacterActivity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_current_character);

        Log.d("START", "Choose Current Character");

                //Populate the ScrollView.
        mCharactersView = findViewById(R.id.characters_layout);
        for (PlayerCharacter character: sCharacters.getList()){
            Log.d("CHARACTER", "found one");
            CheckedTextView v = new CheckedTextView(this);
            v.setText(String.format("%s:", character.getName()));
            v.setChecked(false);
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            v.setOnClickListener(view -> onCheckTextClick(v));
            mCharactersCheckedTextViews.add(v);
            mCharactersView.addView(v);
        }

        for (Weapon weapon: sWeapons){
            Log.d("WEAPON", "Found one");
        }
    }

    public boolean onCheckTextClick(View view){
        CheckedTextView v = (CheckedTextView) view;
        if(v.isChecked()){
            v.setChecked(false);
            v.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else{
            v.setChecked(true);
            v.setBackgroundColor(getResources().getColor(R.color.lime));

        }
        return true;
    }
}
