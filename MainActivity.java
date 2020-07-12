package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.tV1);
        TextView tv2 = (TextView) findViewById(R.id.tV2);
        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button) findViewById(R.id.but2);
        Button but3 = (Button) findViewById(R.id.but3);
        Button but4 = (Button) findViewById(R.id.but4);
        Button but5 = (Button) findViewById(R.id.but5);
        Button but6 = (Button) findViewById(R.id.button);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateandTime = sdf.format(new Date());
        tv1.setText(currentDateandTime);
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch(dayOfWeek){
            case 2:
                tv2.setText("Monday");
                break;
            case 3:
                tv2.setText("Tuesday");
                break;
            case 4:
                tv2.setText("Wednesday");
                break;
            case 5:
                tv2.setText("Thursday");
                break;
            case 6:
                tv2.setText("Friday");
                break;
            case 7:
                tv2.setText("Saturday");
                break;
            case 1:
                tv2.setText("Sunday");
                break;
        }
        but1.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        }
        );
        but2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main3Activity.class));
                    }
                }
        );

        but3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main4Activity.class));
                    }
                }
        );
        but6.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(MainActivity.this,Main5Activity.class));
                    }
                }
        );
        but5.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        MainActivity.this.finish();
                        System.exit(0);
                    }
                }
        );
    }
}
