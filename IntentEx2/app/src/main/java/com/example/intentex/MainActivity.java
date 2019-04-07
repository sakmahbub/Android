package com.example.intentex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button btn;
    ListView listView;
    String[] cityes={"Dhaka", "Rajshahi", "Rangpur", "Bogra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.editText);
        btn=(Button) findViewById(R.id.btnAd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("nn", name.getText().toString());
                startActivity(intent);
            }
        });



        listView=(ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityes);
        listView.setAdapter(adapter);



    }
}
