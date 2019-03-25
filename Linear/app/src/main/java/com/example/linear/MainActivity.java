package com.example.linear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id, name, email, pass;
    private RadioGroup sex;
    private RadioButton male, female;
    private CheckBox java, c, php;

    Button submit, update, reset, Go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.txtId);
        name = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtEmail);
        pass = (EditText) findViewById(R.id.txtPassword);

        sex = (RadioGroup) findViewById(R.id.sexGroup);
        male = (RadioButton) findViewById(R.id.radioMale);
        female = (RadioButton) findViewById(R.id.radioFemale);

        java = (CheckBox) findViewById(R.id.chkJava);
        c = (CheckBox) findViewById(R.id.chkC);
        php = (CheckBox) findViewById(R.id.chkPhp);

        submit = (Button) findViewById(R.id.btnSubmit);
        reset = (Button) findViewById(R.id.btnReset);
        Go = (Button) findViewById(R.id.btnGo);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(id.getText().toString() + "\n");
                stringBuilder.append(name.getText().toString() + "\n");
                stringBuilder.append(email.getText().toString() + "\n");
                stringBuilder.append(pass.getText().toString() + "\n");

                if(male.isChecked()){
                    stringBuilder.append(male.getText().toString()+"\n");
                }else if (female.isChecked()){
                    stringBuilder.append(female.getText().toString()+"\n");
                }

                if (java.isChecked()) {
                    stringBuilder.append(java.getText().toString()+ ", ");
                }
                if (c.isChecked()) {
                    stringBuilder.append(c.getText().toString()+ ", ");
                }

                if (php.isChecked()) {
                    stringBuilder.append(php.getText().toString());
                }


                Toast toast = Toast.makeText(getApplicationContext(), stringBuilder.toString(), Toast.LENGTH_LONG);
                toast.show();



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id.setText("");
                name.setText("");
                email.setText("");
                pass.setText("");

                sex.clearCheck();

                java.setChecked(false);
                c.setChecked(false);
                php.setChecked(false);


            }
        });

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Relative.class);
                startActivity(intent);
            }
        });

    }
}
