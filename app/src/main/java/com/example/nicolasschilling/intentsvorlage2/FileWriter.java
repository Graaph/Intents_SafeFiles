package com.example.nicolasschilling.intentsvorlage2;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by nicolasschilling on 28.12.17.
 */

public class FileWriter {
    final static String fileName ="file2.txt";

        final static String path = "directory";



    public boolean saveFile(String filedata){

        try{
            //Dynamisch "file" generieren

            // "File" Object which contains path
            // new File(Pfad_irgendwo_hin, von_dort_dann_hier_hin)... damit lässt sich schön einfach, aber garantiert richtig ein pfad zum anderen "addieren"
            File directory = new File(Environment.getExternalStorageDirectory(), this.path);


            //Checking for existing directory, else constructing one
            if(!directory.mkdirs())
            {
                System.out.println("Created a Directory ...");
            }


            File file = new File (directory, this.fileName);
            //Create File if needed
            try {
                file.createNewFile();
                System.out.println("Created File!");
            }catch (Exception e){
                System.out.println("Failed to create correct file: " + e);
            }




            System.out.println("Opening file stream");
            //Writing the String filedata on storage
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            System.out.println("Writing bytes");
            fileOutputStream.write((filedata + "\n").getBytes());
            System.out.println("Closing");
            //Closing the file
            fileOutputStream.close();


            System.out.println("Wrote the file");

        }catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
            return false;
        } catch (IOException ex){
            Log.d(TAG, ex.getMessage());
            return false;
        }
        return true;
    }
}
