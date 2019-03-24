package com.example.addnewpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

Button btnH, llbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnH =(Button) findViewById(R.id.button);
        llbtn =(Button) findViewById(R.id.lbtn);

        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
        llbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LinearActivity.class);
                startActivity(intent);
            }
        });

    }
}
