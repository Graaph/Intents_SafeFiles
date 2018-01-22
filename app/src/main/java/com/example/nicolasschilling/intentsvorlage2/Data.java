package com.example.nicolasschilling.intentsvorlage2;



import java.io.Serializable;

/**
 * Created by nicolasschilling on 27.12.17.
 */


public class Data implements Serializable {

    private String daten;

//Konstruktor
    Data(String data){
        this.daten = data;
    }




    public String describeContents() {
        return daten;
        }

    public String getDaten(){
        return daten;
    }
}


