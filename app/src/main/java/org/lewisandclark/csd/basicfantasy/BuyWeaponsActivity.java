package org.lewisandclark.csd.basicfantasy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.EquipmentDatabase;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.Weapon;

import java.util.ArrayList;
import java.util.List;


import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;

@SuppressLint("DefaultLocale")
public class BuyWeaponsActivity extends AppCompatActivity {

    private CharacterList sCharacters = CharacterList.getPlayerCharacterList(this);
    private EquipmentDatabase sEquipmentDatabase = EquipmentDatabase.getEquipmentDatabase(this);
    private LinearLayout mWeaponsLayout;
    private List<CheckedTextView> mWeaponCheckedTextViews = new ArrayList<>();
    private Button mCheckoutButton;
    private TextView mSubtotalView;
    private CheckBox mBuyForFree;

    public static Intent newIntent(Context packageContext){
        //Intent theIntent = new Intent(packageContext, ChooseRaceActivity.class);
        //Intent Extras go here
        //return theIntent;
        return new Intent(packageContext, BuyWeaponsActivity.class);
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buy_weapons);

        mSubtotalView = findViewById(R.id.weapon_subtotal_view);
        mSubtotalView.setText("0.0");

        mBuyForFree = findViewById(R.id.buy_for_free_checkbox);
        mBuyForFree.setChecked(false);
        mBuyForFree.setOnCheckedChangeListener((compoundButton, b) -> updateSubtotal());

        //Populate the ScrollView.  First with melee weapons, then ranged, then ammo
        mWeaponsLayout = findViewById(R.id.weapons_layout);
        for (Weapon item : sEquipmentDatabase.getWeaponList()) {
            Log.d("WEAPON", "found one");
            CheckedTextView v = new CheckedTextView(this);
            v.setText(String.format("%s:     %.1fgp", item.getNameID(), item.getCostInGP()));
            v.setChecked(false);
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            v.setOnClickListener(view -> onCheckTextClick(v));
            mWeaponCheckedTextViews.add(v);
            mWeaponsLayout.addView(v);
        }

        mCheckoutButton = findViewById(R.id.weapon_checkout_button);
        mCheckoutButton.setOnClickListener(view -> {
            for(int i = 0; i< mWeaponCheckedTextViews.size(); i++){
                if(mWeaponCheckedTextViews.get(i).isChecked()){
                    sCharacters.getPlayerCharacter(sCurrentCharacterIndex).
                            addEquipment(sEquipmentDatabase.getEquipment((String) mWeaponCheckedTextViews.get(i).getText()));
                }
            }
            logIt();
            finish();
        });

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
        updateSubtotal();
        return true;
    }

    private void updateSubtotal(){
        float subtotal = 0;
        if(!mBuyForFree.isChecked()) {
            for (int i = 0; i < mWeaponCheckedTextViews.size(); i++) {
                if (mWeaponCheckedTextViews.get(i).isChecked()) {
                    subtotal += sWeapons.get(i).getCostInGP();
                }
            }
        }
        mSubtotalView.setText(String.format("%.1f", subtotal));
    }

    private void logIt() {
        for (Item item: sCharacters.getPlayerCharacter(sCurrentCharacterIndex).getEquipmentList()) {
            Log.d("EQUIPMENT:", getString(item.getNameID()));

        }
    }

    // TODO: 4/23/2018 Create a custom view that displays the full weapon table from Equipment
    //     Emporium then inflate that view for use in a dialog box.
    //     https://stackoverflow.com/questions/16955053/android-how-do-i-make-this-alert-dialog-scrollable
}
