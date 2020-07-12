package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        EditText ed1 = (EditText)findViewById(R.id.eT1);
        EditText ed2 = (EditText)findViewById(R.id.eT2);
        EditText ed3 = (EditText)findViewById(R.id.eT3);
        final TextView tv = (TextView)findViewById(R.id.tV4);
        Button but = (Button) findViewById(R.id.but2);
        Button but1 = (Button) findViewById(R.id.button);
        String dd = ed1.getText().toString();
        String mm = ed2.getText().toString();
        String yy = ed3.getText().toString();
        String date = dd+"."+mm+"."+yy;
        but.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        EditText ed1 = (EditText)findViewById(R.id.eT1);
                        EditText ed2 = (EditText)findViewById(R.id.eT2);
                        EditText ed3 = (EditText)findViewById(R.id.eT3);
                        final TextView tv = (TextView)findViewById(R.id.tV4);
                        Button but = (Button) findViewById(R.id.but2);
                        String dd = ed1.getText().toString();
                        String mm = ed2.getText().toString();
                        String yy = ed3.getText().toString();
                        String date = dd+"."+mm+"."+yy;
                        FileInputStream fis = null;
                        try {
                            fis = openFileInput(date);
                            InputStreamReader isr = new InputStreamReader(fis);
                            BufferedReader br = new BufferedReader(isr);
                            StringBuilder sb = new StringBuilder();
                            String text;
                            while ((text = br.readLine()) != null) {
                                sb.append(text).append("\n\n");
                            }
                            tv.setText(sb);

                        } catch (FileNotFoundException e) {
                            tv.setText("Not Found:"+date);
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
                    }
                }
        );
        but1.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();
                    }
                }
        );
    }
}
