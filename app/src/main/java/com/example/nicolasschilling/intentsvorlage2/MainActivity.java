package com.example.nicolasschilling.intentsvorlage2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button filesafebtn;
    Button showMebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the items
        editText = (EditText) findViewById(R.id.editText);
        filesafebtn = (Button) findViewById(R.id.filesafebtn);
        showMebtn = (Button) findViewById(R.id.showMebtn);


    }



//Share-Funktion
    public void share(String sharetxt){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }




    //Filesave button
    public void FileSave(View v){

        editText = (EditText) findViewById(R.id.editText);
        //Startet eine instance des FileWriters and versucht das aus dem EditText zu schreiben
        FileWriter writer = new FileWriter();


        if (writer.saveFile(editText.getText().toString())) {
            Toast.makeText(MainActivity.this, "Has been safed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }


        editText.setText("");

        Intent intent = new Intent(this, ShowMe.class);
            startActivity(intent);
    }





    //change activity to ShowMe Class
    public void ShowMeActivity(View v) {
        Intent intent = new Intent(this, ShowMe.class);
        startActivity(intent);
    }



}
