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

import org.lewisandclark.csd.basicfantasy.model.Armor;
import org.lewisandclark.csd.basicfantasy.model.CharacterList;
import org.lewisandclark.csd.basicfantasy.model.Item;
import org.lewisandclark.csd.basicfantasy.model.Shield;

import java.util.ArrayList;
import java.util.List;

import static org.lewisandclark.csd.basicfantasy.HomeActivity.sArmors;
import static org.lewisandclark.csd.basicfantasy.HomeActivity.sCurrentCharacterIndex;
import static org.lewisandclark.csd.basicfantasy.HomeActivity.sShields;
@SuppressLint("DefaultLocale")

public class BuyArmorActivity extends AppCompatActivity {

    private CharacterList sCharacters = CharacterList.getPlayerCharacter(this);
    private LinearLayout mArmorLayout;
    private List<CheckedTextView> mArmorCheckedTextViews = new ArrayList<>();
    private List<CheckedTextView> mShieldCheckedTextViews = new ArrayList<>();
    private Button mCheckoutButton;
    private TextView mSubtotalView;
    private CheckBox mBuyForFree;


    public static Intent newIntent(Context packageContext){
        //Intent theIntent = new Intent(packageContext, ChooseRaceActivity.class);
        //Intent Extras go here
        //return theIntent;
        return new Intent(packageContext, BuyArmorActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_armor);

        mSubtotalView = findViewById(R.id.armor_subtotal_view);
        mSubtotalView.setText("0.0");

        mBuyForFree = findViewById(R.id.buy_for_free_checkbox);
        mBuyForFree.setChecked(false);
        mBuyForFree.setOnCheckedChangeListener((compoundButton, b) -> updateSubtotal());

        //Populate the ScrollView.  First with armors
        mArmorLayout = findViewById(R.id.armor_layout);
        for (Armor item: sArmors) {
            CheckedTextView v = new CheckedTextView(this);
            v.setText(String.format("%s:     %.1fgp",getString(item.getNameID()),item.getCostInGP()));
            v.setChecked(false);
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24 );
            v.setOnClickListener(view -> onCheckTextClick(v));
            mArmorCheckedTextViews.add(v);
            mArmorLayout.addView(v);
        }

        //now the shields
        for (Shield item: sShields) {
            CheckedTextView v = new CheckedTextView(this);
            v.setText(String.format("%s:     %.1fgp",getString(item.getNameID()),item.getCostInGP()));
            v.setChecked(false);
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24 );
            v.setOnClickListener(view -> onCheckTextClick(v));
            mShieldCheckedTextViews.add(v);
            mArmorLayout.addView(v);
        }

        mCheckoutButton = findViewById(R.id.armor_checkout_button);
        mCheckoutButton.setOnClickListener(view -> {
            for(int i = 0; i< mArmorCheckedTextViews.size(); i++){
                if(mArmorCheckedTextViews.get(i).isChecked()){
                    sCharacters.getPlayerCharacter(sCurrentCharacterIndex).addEquipment(sArmors.get(i));
                }
            }
            for(int i = 0; i< mShieldCheckedTextViews.size(); i++){
                if(mShieldCheckedTextViews.get(i).isChecked()){
                    sCharacters.getPlayerCharacter(sCurrentCharacterIndex).addEquipment(sShields.get(i));
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

    @SuppressLint("DefaultLocale")
    private void updateSubtotal(){
        float subtotal = 0;
        if(!mBuyForFree.isChecked()) {
            for (int i = 0; i < mArmorCheckedTextViews.size(); i++) {
                if (mArmorCheckedTextViews.get(i).isChecked()) {
                    subtotal += sArmors.get(i).getCostInGP();
                }
            }
            for (int i = 0; i < mShieldCheckedTextViews.size(); i++) {
                if (mShieldCheckedTextViews.get(i).isChecked()) {
                    subtotal += sShields.get(i).getCostInGP();
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
}
