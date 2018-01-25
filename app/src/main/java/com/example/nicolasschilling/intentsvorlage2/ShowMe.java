package com.example.nicolasschilling.intentsvorlage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;

public class ShowMe extends AppCompatActivity {

    TextView txtview;
    Button loadbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        loadbtn = (Button) findViewById(R. id.loadbtnanzeige);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);


        //Data from the .txt-file is printed out once the activity is opened
loadData();
    }



    public void reloadData(View v){
        FileWriter reader = new FileWriter();
        String ausgabe = reader.readFile("file.txt");

        txtview.setText(ausgabe);
    }
    public void loadData(){
        FileWriter reader = new FileWriter();
        String ausgabe = reader.readFile("file.txt");

        txtview.setText(ausgabe);
    }


}