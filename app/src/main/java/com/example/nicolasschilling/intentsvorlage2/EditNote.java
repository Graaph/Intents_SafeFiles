package com.example.nicolasschilling.intentsvorlage2;


import java.io.Serializable;

/**
 * Created by nicolasschilling on 27.01.18.
 */

public class EditNote implements Serializable {

private String note;

    //Konstruktor
EditNote(String editnote){
    this.note = editnote;
}




public String getNote(){
    return note;
}



}
