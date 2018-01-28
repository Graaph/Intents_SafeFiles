package com.example.nicolasschilling.intentsvorlage2;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShowMe extends AppCompatActivity {

    TextView txtview;
    Button menubtn, editbtn, deletebtn;

    ListView listview;
    public static final String parKEY = "parKey";
    int listsize=0; //Number of notes, gets updated by loadData()
    int noteposition=-1; //Position of selected note

    boolean editing =false;//is true when note is being edited






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        menubtn = (Button) findViewById(R. id.loadbtnanzeige);
        editbtn = (Button) findViewById(R. id.editbtn);
        deletebtn = (Button) findViewById(R. id.deletetbn);
        txtview = (TextView) findViewById(R. id. textViewAnzeige);
        listview =(ListView) findViewById(R. id.listviewanzeige);

        //Data from the .txt-file is printed out once the activity is opened
        //Checks if there was something edited and "Notes"-Button was pressed without changing
loadData();





        if ((EditNote) getIntent().getSerializableExtra(MainActivity.parKEY) != null ) {

            //checks if something was edited
            //Get Intent from other activity with Note object

            EditNote editNote;
            editNote = (EditNote) getIntent().getSerializableExtra(MainActivity.parKEY);
            editing = editNote.getEditing();
            if (editing == true) { //is true if sth was edited
                loadEditingData();
            } else { //this else is probably useless because it never happens
                loadData();
            }
        }

        else{
                loadData();

            }




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
                noteposition =position;
            }
        });

//Listener for editbtn
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noteposition>=0){
                edit(listview.getItemAtPosition(noteposition).toString());}
                else{
                    Toast.makeText(ShowMe.this, "Plese select note first", Toast.LENGTH_SHORT).show();
                }
            }
        });

//Listener for deletebtn

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });




    }


    public void loadData(){
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

    private void edit(String note){

    //send Note via Intent to other activity
    EditNote editnote = new EditNote(note, true);
    Intent myIntent = new Intent(ShowMe.this, MainActivity.class);
    myIntent.putExtra(parKEY, editnote);

    //delete the note from file
    FileWriter fileWriter = new FileWriter();
    fileWriter.delete(listsize-1-noteposition);
    noteposition=-1;
    startActivity(myIntent);


        }

    private void delete(){
        if (noteposition>=0) {
            FileWriter fileWriter = new FileWriter();
            fileWriter.delete((listsize - 1) - noteposition);
            loadData();
            noteposition=-1;

        }
        else{
            Toast.makeText(this, "Select note first", Toast.LENGTH_SHORT).show();

        }
    }

    //Function in case something was edited
    private void loadEditingData(){

        //Get Intent from other activity with Note object

        EditNote editNote;
        editNote = (EditNote) getIntent().getSerializableExtra(MainActivity.parKEY);
        FileWriter fileWriter = new FileWriter();
        fileWriter.saveFile(editNote.getNote().toString());
        loadData();
    }



    }