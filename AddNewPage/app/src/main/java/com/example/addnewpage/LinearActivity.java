package com.example.addnewpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity {
    Button submit, reset;
    EditText name, email, password, msg;
    RadioGroup sexGroup;
    RadioButton sexButton;
    Spinner round;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);


        name=(EditText) findViewById(R.id.txtName);
        email=(EditText) findViewById(R.id.txtEmail);
        password=(EditText) findViewById(R.id.txtPassword);
        msg=(EditText) findViewById(R.id.msg);

        sexGroup =(RadioGroup) findViewById(R.id.radioSex);
        sexButton=(RadioButton) findViewById(R.id.radioMale);
        sexButton=(RadioButton) findViewById(R.id.radioFemale);

        checkBox=(CheckBox) findViewById(R.id.txtJava);
        checkBox=(CheckBox) findViewById(R.id.txtPhp);
        checkBox=(CheckBox) findViewById(R.id.txtJs);

        round=(Spinner) findViewById(R.id.txtRound);


        submit=(Button) findViewById(R.id.btnSubmit);
        reset=(Button) findViewById(R.id.btnReset);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder=new StringBuilder();

                stringBuilder.append(name.getText().toString()+"\n");
                stringBuilder.append(email.getText().toString()+"\n");
                stringBuilder.append(password.getText().toString()+"\n");


                stringBuilder.append(sexGroup.getCheckedRadioButtonId());
                stringBuilder.append(sexButton.getText().toString()+"\n");
                stringBuilder.append(checkBox.getText().toString()+"\n");

                stringBuilder.append(msg.getText().toString()+"\n");


                Toast toast=Toast.makeText(getApplicationContext(), stringBuilder.toString(), Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }
}
