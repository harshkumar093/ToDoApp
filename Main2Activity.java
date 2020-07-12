package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main2Activity extends AppCompatActivity {

    String data;
    int a;
    String tdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try {
            File myObj = new File("FILES/new_task.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        TextView tv1 = (TextView) findViewById(R.id.tV1);
        final TextView tv2 = (TextView) findViewById(R.id.tV2);
        final TextView tv3 = (TextView) findViewById(R.id.tV3);
        EditText ed1 = (EditText) findViewById(R.id.eT1);
        EditText ed2 = (EditText) findViewById(R.id.eT2);
        EditText ed3 = (EditText) findViewById(R.id.eT3);
        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button)findViewById(R.id.but2);
        final String task_name = ed1.getText().toString();
        final String task_detials = ed2.getText().toString();
        String rating =ed3.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateandTime = sdf.format(new Date());
        tdate = currentDateandTime;
        tv1.setText(currentDateandTime);
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
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
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText ed1 = (EditText) findViewById(R.id.eT1);
                        EditText ed2 = (EditText) findViewById(R.id.eT2);
                        EditText ed3 = (EditText) findViewById(R.id.eT3);
                        String task_name = ed1.getText().toString().toUpperCase();
                        String task_detials = ed3 .getText().toString().toUpperCase();
                        String rating =ed2.getText().toString();
                        if (task_name.isEmpty() || task_detials.isEmpty()) {
                            tv3.setText("complete below");
                        }
                        else{
                        String new_file = tdate;
                        String mydata = "-> TASK:" + task_name + "\t\tPRIORITY:" + rating + "\t\tDETAILS:" + task_detials + "\n";
                        FileOutputStream fos = null;
                        try {
                            fos = openFileOutput(new_file, MODE_PRIVATE|MODE_APPEND);
                            fos.write(mydata.getBytes());
                            tv3.setText("Data Saved");
                            ed1.setText("");
                            ed2.setText("");
                            ed3.setText("");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        }
                    }
                }
        );
        but2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();
                    }
                }
        );
    }

}
