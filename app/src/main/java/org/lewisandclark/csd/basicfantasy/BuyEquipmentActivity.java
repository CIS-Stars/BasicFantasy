package org.lewisandclark.csd.basicfantasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BuyEquipmentActivity extends AppCompatActivity {


    public static Intent newIntent(Context packageContext){
        Intent theIntent = new Intent(packageContext, BuyEquipmentActivity.class);
        //Intent Extras go here
        return theIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_equipment);
    }
}
