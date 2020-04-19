package com.example.a72button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    TextView newText;
    String textToSet;
    Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.editText);
        newText = (TextView) findViewById(R.id.userInput);
        context = MainActivity.this;
        System.out.println("KANSION SIJAINTI"+context.getFilesDir());
    }
    public void readFile(View v){
        try{
            InputStream inS = context.openFileInput("testi.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(inS));
            String str = "";
            while ((str=br.readLine())!=null){
                newText.setText(str);
            }
            inS.close();
        }catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }finally {
            System.out.println("Luettu");
        }

    }
    public void writeFile(View v){
        try{
            OutputStreamWriter owS = new OutputStreamWriter(context.openFileOutput("testi.txt", Context.MODE_PRIVATE));
            String str = "";
            str = inputText.getText().toString();
            owS.write(str);
            owS.close();
        }catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }finally {
            System.out.println("Kirjoitettu");
        }
    }
    public void testMethod (View v){
        System.out.println("Hello world!");
    }
}
