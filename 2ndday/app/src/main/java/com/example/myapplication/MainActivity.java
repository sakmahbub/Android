package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.txtName);
        pass=(EditText) findViewById(R.id.txtPass);
        btn=(Button) findViewById(R.id.btnSubmit) ;

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
    }
}
