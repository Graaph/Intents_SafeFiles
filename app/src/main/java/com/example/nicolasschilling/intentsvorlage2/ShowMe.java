package com.example.nicolasschilling.intentsvorlage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;

public class ShowMe extends AppCompatActivity {

    TextView txtview;
    Button loadbtn;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        loadbtn = (Button) findViewById(R. id.loadbtnanzeige);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);
        listview =(ListView) findViewById(R.id.listviewanzeige);

        //Data from the .txt-file is printed out once the activity is opened
loadData();
    }



    public void reloadData(View v){
        FileWriter reader = new FileWriter();

        String[] liste = reader.readFile("file.txt").split("\n");//split .txt at linechange
        ArrayAdapter<String> listadapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,liste);
        listview.setAdapter(listadapter);
    }
    public void loadData(){
        FileWriter reader = new FileWriter();

       String[] liste = reader.readFile("file.txt").split("\n");
       ArrayAdapter<String> listadapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,liste);
       listview.setAdapter(listadapter);
    }


}