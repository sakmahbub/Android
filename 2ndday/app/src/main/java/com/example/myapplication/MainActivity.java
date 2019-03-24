package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText name, pass;
    Button btn, btnGoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.txtName);
        pass=(EditText) findViewById(R.id.txtPass);
        btn=(Button) findViewById(R.id.btnSubmit) ;

        btnGoes=(Button) findViewById(R.id.btnGo) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(name.getText().toString()+"\n");
                stringBuilder.append(pass.getText().toString()+"\n");

                Toast toast=Toast.makeText(getApplicationContext(), stringBuilder.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });


        btnGoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
