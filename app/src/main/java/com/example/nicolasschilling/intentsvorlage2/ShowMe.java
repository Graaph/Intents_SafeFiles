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
    ArrayList<Data> my_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        loadbtn = (Button) findViewById(R. id.loadbtnanzeige);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);

        //Wir laden mal Data gleich am anfang...
        //my_data = (ArrayList<Data>) getIntent().getSerializableExtra(MainActivity.parKEY);

        //System.out.println("Intent Extra First Entry: " + my_data.get(0).describeContents());

        //Filling Screen with loaded Data from .txt-file


    }



   /* //LOADDATA
    public void loadData(View v) {

        txtview = (TextView) findViewById(R.id.textView);
        loadbtn = (Button) findViewById(R.id.loadbtn);

        //txtview.setText(my_data.get(0).describeContents());
    } */

    private void loadData(){
        FileWriter reader = new FileWriter();
        String ausgabe = reader.readFile("file.txt");

        txtview.setText(ausgabe);
    }

}





