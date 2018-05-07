package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class BuyEquipmentActivity extends AppCompatActivity {


    private Button mBuyArmorButton;
    private Button mBuyWeaponsButton;

    public static Intent newIntent(Context packageContext){
        //Intent theIntent = new Intent(packageContext, BuyEquipmentActivity.class);
        //Intent Extras go here
        //return theIntent;
        return new Intent(packageContext, BuyEquipmentActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_equipment);

        mBuyArmorButton = findViewById(R.id.button_armor);
        mBuyArmorButton.setOnClickListener(view -> {
            Intent intent = BuyArmorActivity.newIntent(BuyEquipmentActivity.this);
            startActivity(intent);           });

        mBuyWeaponsButton = findViewById(R.id.button_weapons);
        mBuyWeaponsButton.setOnClickListener(view -> {
            Intent intent = BuyWeaponsActivity.newIntent(BuyEquipmentActivity.this);
            startActivity(intent);           });
    }
}
