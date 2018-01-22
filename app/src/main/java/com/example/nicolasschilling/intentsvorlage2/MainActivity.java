package com.example.nicolasschilling.intentsvorlage2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button safebtn;
    Button filesafebtn;
    Button showMebtn;
    ArrayList<Data> datenliste = new ArrayList<>();
    public static final String parKEY = "parKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the items
        editText = (EditText) findViewById(R.id.editText);
        safebtn = (Button) findViewById(R.id.safebtn); //Hier war ein leerzeichen nach dem R.id. .. ka ob das was macht :D
        filesafebtn = (Button) findViewById(R.id.filesafebtn);
        showMebtn = (Button) findViewById(R.id.showMebtn);


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
    }



    //Save button
    public void ButtonWasClicked(View v){
        //Get the filed again
        editText = (EditText) findViewById(R.id.editText);

        Data newdata = new Data (editText.getText().toString());
        datenliste.add(newdata);
        senddata();
    }

    //change activity to ShowMe Class
    public void ShowMeActivity(View v) {
Intent intent = new Intent(this, ShowMe.class);
startActivity(intent);

    }

    public void senddata(){
        Intent myIntent = new Intent (MainActivity.this, ShowMe.class);
        myIntent.putExtra(parKEY, this.datenliste); //Dadurch das wir das Serializable gemacht haben kann man das einfach rein tun
        startActivity(myIntent);
    }




}
