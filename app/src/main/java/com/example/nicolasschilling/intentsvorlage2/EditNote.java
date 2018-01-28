package com.example.nicolasschilling.intentsvorlage2;


import java.io.Serializable;

/**
 * Created by nicolasschilling on 27.01.18.
 */

public class EditNote implements Serializable {

private String note;
private Boolean editing;

    //Konstruktor
EditNote(String editnote, boolean editing){
    this.note = editnote;
    this.editing=editing;
}


    public boolean getEditing(){
        return editing;
    }


    public String getNote(){
    return note;
}


}
