package com.example.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1, cancel;
CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.btnAdd);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlerts();
            }
        });
        
        cancel =(Button) findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlerts();
            }
        });
        
        checkBox=(CheckBox) findViewById(R.id.chk);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    startAlerts();
                    
                }else{
                    cancelAlerts();
                }
            }
        });
        
    }
    
    PendingIntent pendingIntent;
    public void startAlerts(){

        EditText text=(EditText) findViewById(R.id.txtName);
        int i = Integer.parseInt(text.getText().toString());
        
        Intent intent=new Intent(this, MyBroadcastReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am=(AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i * 100), (500 * 1000), pendingIntent );
    }



    public void cancelAlerts(){

        EditText text=(EditText) findViewById(R.id.txtName);
        int i = Integer.parseInt(text.getText().toString());

        Intent intent=new Intent(this, MyBroadcastReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager am=(AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, (i * 100), (500 * 1000), pendingIntent );
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
