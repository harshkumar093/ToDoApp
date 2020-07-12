package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        EditText ed = (EditText)findViewById(R.id.eT1);
        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button) findViewById(R.id.but2);
        TextView tv = (TextView)findViewById(R.id.tV);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        final String currentDateandTime = sdf.format(new Date());
        FileInputStream fis = null;
        try {
            fis = openFileInput(currentDateandTime);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n\n");
            }
            ed.setText(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        but1.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        EditText ed = (EditText)findViewById(R.id.eT1);
                        TextView tv = (TextView)findViewById(R.id.tV);
                        String mydata = ed.getText().toString();
                        FileOutputStream fos = null;
                        try {
                            fos = openFileOutput(currentDateandTime, MODE_PRIVATE);
                            fos.write(mydata.getBytes());
                            tv.setText("Data Saved");
                            ed.setText("Press back button to retrun to home");
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
