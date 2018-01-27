package com.example.nicolasschilling.intentsvorlage2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShowMe extends AppCompatActivity {

    TextView txtview;
    Button menubtn;
    ListView listview;
    public static final String parKEY = "parKey";
int listsize=0; //Number of notes, gets updated by loadData()





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        menubtn = (Button) findViewById(R. id.loadbtnanzeige);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);
        listview =(ListView) findViewById(R.id.listviewanzeige);

        //Data from the .txt-file is printed out once the activity is opened
loadData();

//Listener for menubtn
menubtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        menubtnfunc();
    }
});


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //String selectedFromList = (listview.getItemAtPosition(position).toString());
edit(listview.getItemAtPosition(position).toString(), position);


            }
        });




    }








    public void reloadData(View v){
        FileWriter reader = new FileWriter();
        String[] liste = reader.readFile("file.txt").split("\n");//split .txt at linechange
        List<String> listelist = Arrays.asList(liste);
        Collections.reverse(listelist);
        ArrayAdapter<String> listadapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,listelist);
        listview.setAdapter(listadapter);
        listsize=listelist.size();
    }


    public void loadData(){  //possibly not needed any more??
        FileWriter reader = new FileWriter();

        String[] liste = reader.readFile("file.txt").split("\n");//split .txt at linechange
        List<String> listelist = Arrays.asList(liste);
        Collections.reverse(listelist);
       ArrayAdapter<String> listadapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,liste);
       listview.setAdapter(listadapter);
       listsize=listelist.size();
    }


    public void menubtnfunc(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }




    private void edit(String note, int position){

        int realposition = listsize-position;
        EditNote editnote = new EditNote(note);
        Intent myIntent = new Intent (ShowMe.this, MainActivity.class);
        myIntent.putExtra(parKEY, editnote);
        startActivity(myIntent);
        FileWriter fileWriter = new FileWriter();
        fileWriter.delete(realposition);
        //Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show(); //debugging

        }



    }