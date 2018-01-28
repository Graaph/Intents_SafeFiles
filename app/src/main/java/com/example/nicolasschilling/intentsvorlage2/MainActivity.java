package com.example.nicolasschilling.intentsvorlage2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button filesafebtn;
    Button showMebtn;
    public boolean editing = false;//check if something is being edited
    public static final String parKEY = "parKey";

    //buffer for note if being edited. In case nothing is safed, the "original" note is getting safed again
    String notebuffer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the items
        editText = (EditText) findViewById(R.id.editText);
        filesafebtn = (Button) findViewById(R.id.filesafebtn);
        showMebtn = (Button) findViewById(R.id.showMebtn);


EditNote editNote;


        //Show the edit-Data in case something was edited
        if ((EditNote) getIntent().getSerializableExtra(ShowMe.parKEY) != null ) {
            editNote = (EditNote) getIntent().getSerializableExtra(ShowMe.parKEY);
            editText.setText(editNote.getNote()); //print out the data
            editing= editNote.getEditing();
            notebuffer =editNote.getNote();

        }

    }







//Filesave button
    public void FileSave(View v){

        editText = (EditText) findViewById(R.id.editText);
        //Startet eine instance des FileWriters and versucht das aus dem EditText zu schreiben
        FileWriter writer = new FileWriter();


        if (writer.saveFile(editText.getText().toString())) {
            Toast.makeText(MainActivity.this, "Has been safed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "ERROR. Try to authorize Data Usage in App-Settings", Toast.LENGTH_SHORT).show();
        }


        editText.setText("");


        Intent intent = new Intent(this, ShowMe.class);
            startActivity(intent);
    }



//change activity to ShowMe Class
    public void ShowMeActivity(View v) {

    //Check Info from Intent
    EditNote editNote;



        if (editing==true) {

            //Send Intent with note and Information, that something was edited (editing == true)
            EditNote editnote = new EditNote(notebuffer, true);
            Intent myIntent = new Intent(MainActivity.this, ShowMe.class);
            myIntent.putExtra(parKEY, editnote);
            startActivity(myIntent);
            Toast.makeText(this, "Changes discarded...", Toast.LENGTH_SHORT).show();

        } else {

            Intent intent = new Intent(this, ShowMe.class);
            startActivity(intent);
        }
    }




}
