package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.EquipmentDatabase;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.PlayerCharacter;
import org.lewisandclark.csd.basicfantasy.model.Weapon;

import java.util.ArrayList;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

public class CombatActivity extends AppCompatActivity {

    private TextView mTextViewLeftNavigate;
    private TextView mTextViewRightNavigate;
    private TextView mHPMaxScore;
    private TextView mHPCurrentScore;
    private TextView mACScore;

    private TableRow mWeapon1;
    private TableRow mWeapon2;
    private TableRow mWeapon3;
    private TableRow mWeapon4;
    private TableRow mWeapon5;

    private TextView[] mWeaponNameArray;
    private TextView[] mWeaponToHitArray;
    private TextView[] mWeaponDamageArray;


    private CharacterList sCharacters = CharacterList.getPlayerCharacterList(this);
    private PlayerCharacter mCurrentCharacter;
    private EquipmentDatabase sEquipmentDatabase = EquipmentDatabase.getEquipmentDatabase(this);


    public static Intent newIntent(Context packageContext) {
        Intent theIntent = new Intent(packageContext, CombatActivity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        ArrayList<Weapon> equippedWeapons;

        mHPMaxScore = findViewById(R.id.hp_max_score);
        mHPCurrentScore = findViewById(R.id.hp_current_score);
        mACScore = findViewById(R.id.AC_score);

        mCurrentCharacter = sCharacters.getPlayerCharacter(sCurrentCharacterIndex);
        int totHP = mCurrentCharacter.getTotalHitPoints();
        Log.d("PAGE2", "onCreate: total HP = "+ Integer.toString(totHP));
        mHPMaxScore.setText(Integer.toString(totHP));
        mHPCurrentScore.setText(Integer.toString(mCurrentCharacter.getCurrentHitPoints()));
        mACScore.setText(Integer.toString(mCurrentCharacter.getArmorClass()));

        mWeapon1 = findViewById(R.id.weapon_row1);
        mWeapon2 = findViewById(R.id.weapon_row2);
        mWeapon3 = findViewById(R.id.weapon_row3);
        mWeapon4 = findViewById(R.id.weapon_row4);
        mWeapon5 = findViewById(R.id.weapon_row5);

        mWeaponNameArray = new TextView[]{
                findViewById(R.id.weapon_1_name),
                findViewById(R.id.weapon_2_name),
                findViewById(R.id.weapon_3_name),
                findViewById(R.id.weapon_4_name),
                findViewById(R.id.weapon_5_name)};

        mWeaponToHitArray = new TextView[]{
                findViewById(R.id.weapon_1_tohit),
                findViewById(R.id.weapon_2_tohit),
                findViewById(R.id.weapon_3_tohit),
                findViewById(R.id.weapon_4_tohit),
                findViewById(R.id.weapon_5_tohit)};

        mWeaponDamageArray = new TextView[]{
                findViewById(R.id.weapon_1_damage),
                findViewById(R.id.weapon_2_damage),
                findViewById(R.id.weapon_3_damage),
                findViewById(R.id.weapon_4_damage),
                findViewById(R.id.weapon_5_damage)};

        int index = 0;
        for(Item item : mCurrentCharacter.getEquipmentList()){
            if(item instanceof Weapon && index < 5){
                mWeaponNameArray[index].setText(item.getNameID());
                index++;
                Log.d("EQUIPPED WEAPON", item.getNameID());
            }
        }




        mTextViewLeftNavigate = findViewById(R.id.left_button);
        mTextViewRightNavigate = findViewById(R.id.right_button);

        mTextViewLeftNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open left screen
                Intent i = StatsActivity.newIntent(CombatActivity.this);
                startActivity(i);
                overridePendingTransition(R.anim.left_to_right_in, R.anim.left_to_right_out);
            }
        });

        mTextViewRightNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open right screen
                Intent i = StatsActivity.newIntent(CombatActivity.this);
                startActivity(i);
                overridePendingTransition(R.anim.right_to_left_in, R.anim.right_to_left_out);
            }
        });

    }
}
