package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class BuyArmorActivity extends AppCompatActivity {

    LinearLayout mArmorLayout;
    List<CheckedTextView> mCheckedTextViews;

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

        mArmorLayout = findViewById(R.id.armor_layout);
        mCheckedTextViews = new ArrayList<>();

        for (Armor item: HomeActivity.sArmors) {
            CheckedTextView v = new CheckedTextView(this);
            v.setText(item.getNameID());
            v.setChecked(false);
            v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24 );
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCheckTextClick(v);
                }
            });
            mCheckedTextViews.add(v);
            mArmorLayout.addView(v);
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
