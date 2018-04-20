package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BuyEquipmentActivity extends AppCompatActivity {


    private Button mBuyArmorButton;

    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, BuyEquipmentActivity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_equipment);
        mBuyArmorButton = findViewById(R.id.button_armor);
        mBuyArmorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = BuyArmorActivity.newIntent(BuyEquipmentActivity.this);
                startActivity(intent);           }
        });
    }
}
