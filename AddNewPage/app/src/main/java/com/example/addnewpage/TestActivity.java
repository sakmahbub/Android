package com.example.addnewpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {

    Button btnT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnT=(Button) findViewById(R.id.btnBack);

        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentm=new Intent(TestActivity.this, MainActivity.class);
                startActivity(intentm);
            }
        });
    }
}
