package com.example.bdcriket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ball, over, run;
    Button btn, reset, run1,run2,run3,run4,run5,run6,run7;
    int balls = 0;
    int overs = 0;
    int runs=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ball = (EditText) findViewById(R.id.ball);
        over = (EditText) findViewById(R.id.over);
        run = (EditText) findViewById(R.id.runs);
        btn = (Button) findViewById(R.id.btnCount);
        reset = (Button) findViewById(R.id.btnReset);
        run1 = (Button) findViewById(R.id.btnRun);
        run2 = (Button) findViewById(R.id.btn2Runs);
        run3 = (Button) findViewById(R.id.btn3Runs);
        run4 = (Button) findViewById(R.id.btn4Runs);
        run5 = (Button) findViewById(R.id.btn5Runs);
        run6 = (Button) findViewById(R.id.btn6Runs);
        run7 = (Button) findViewById(R.id.btn7Runs);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balls++;
                ball.setText(String.valueOf(balls));
                if(balls == 6){
                    balls = 0;
                    overs++;
                    over.setText(String.valueOf(overs));
                }
            }
        });

        run1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run1.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });

        run2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run2.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });
        run3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run3.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });

        run4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run4.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });

        run5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run5.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });
        run6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run6.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });

        run7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runs+=Integer.parseInt(run7.getText().toString());
                run.setText(String.valueOf(runs));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balls = 0;
                overs = 0;
                runs=0;
                ball.setText(String.valueOf(balls));
                over.setText(String.valueOf(overs));
                run.setText(String.valueOf(runs));
            }
        });
    }
}
