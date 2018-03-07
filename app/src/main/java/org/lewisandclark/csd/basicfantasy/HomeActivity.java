package org.lewisandclark.csd.basicfantasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button mCreateCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mCreateCharacter = findViewById(R.id.create_button);
        mCreateCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = RollAttributesActivity.newIntent(HomeActivity.this);
                startActivity(theIntent);
            }
        });
    }
}
