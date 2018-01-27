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
    Button loadbtn;
    ListView listview;
    public static final String parKEY = "parKey";










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        loadbtn = (Button) findViewById(R. id.loadbtnanzeige);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);
        listview =(ListView) findViewById(R.id.listviewanzeige);

        //Data from the .txt-file is printed out once the activity is opened
loadData();











        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //String selectedFromList = (listview.getItemAtPosition(position).toString());
edit(listview.getItemAtPosition(position).toString());


                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
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
    }
    public void loadData(){
        FileWriter reader = new FileWriter();

        String[] liste = reader.readFile("file.txt").split("\n");//split .txt at linechange
        List<String> listelist = Arrays.asList(liste);
        Collections.reverse(listelist);
       ArrayAdapter<String> listadapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,liste);
       listview.setAdapter(listadapter);
    }

    private void edit(String note){


        EditNote editnote = new EditNote(note);
        Intent myIntent = new Intent (ShowMe.this, MainActivity.class);
        myIntent.putExtra(parKEY, editnote); //Dadurch das wir das Serializable gemacht haben kann man das einfach rein tun :)
        startActivity(myIntent);
        }






    }








