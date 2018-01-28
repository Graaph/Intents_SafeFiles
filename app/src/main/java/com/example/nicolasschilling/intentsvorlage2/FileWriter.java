package com.example.nicolasschilling.intentsvorlage2;

import android.os.Environment;
import android.util.Log;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


import static android.content.ContentValues.TAG;

/**
 * Created by nicolasschilling on 28.12.17.
 */

public class FileWriter {
    final static String fileName = "file.txt";
    final static String path = "NotizAppDirectory";


    public boolean saveFile(String filedata) {


        try {

            File directory = new File(Environment.getExternalStorageDirectory(), this.path);


            //Checking for existing directory, else constructing one
            if (!directory.mkdirs()) {
                System.out.println("Created a Directory ...");
            }


            File file = new File(directory, this.fileName);

            //Create File if needed
            try {
                file.createNewFile();
                System.out.println("Created File!");
            } catch (Exception e) {
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

        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
            return false;
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
            return false;
        }
        return true;
    }


    String readFile(String fileName) {

        StringBuilder sb = new StringBuilder();

        try {

            File directory = new File(Environment.getExternalStorageDirectory(), this.path);
            File txt_file = new File(directory, fileName);

            BufferedReader br = new BufferedReader(new FileReader(txt_file));

            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public void delete(int positon) {
        try {
            File directory = new File(Environment.getExternalStorageDirectory(), this.path);
            File file = new File(directory, fileName);
            File nfile = new File(directory, "nfile.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nfile)));
            int counter = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                if (counter != positon) {
                    bw.write(line);
                    bw.newLine();

                }
                counter++;
            }
            bw.close();
            br.close();
            file.delete();
            nfile.renameTo(file);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
