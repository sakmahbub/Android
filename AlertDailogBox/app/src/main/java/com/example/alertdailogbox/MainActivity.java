package com.example.alertdailogbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void open(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("The New App");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 showText("Yes button");
            }
        }).show();

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showText("No button");
            }
        }).show();
    }


    public void showText(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();


    }
}
