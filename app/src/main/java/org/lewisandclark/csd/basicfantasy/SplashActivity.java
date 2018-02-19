package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Thorin Schmidt on 2/18/2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        try {
            //set time in mili
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
        finish();
    }
}
