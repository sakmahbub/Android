package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestActivity extends Activity {
    Button btnA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA=(Button)findViewById(R.id.btnBacktohome);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
