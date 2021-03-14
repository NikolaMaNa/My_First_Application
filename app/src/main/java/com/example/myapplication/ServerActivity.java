package com.example.myapplication;

import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerActivity extends AppCompatActivity {

    private Socket socket;
    Thread thread;
    private BufferedReader in = null;
    private DataOutputStream out;
    String retValue;

    public String serverThread(String studentID) {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("se2-isys.aau.at", 53212);
                    out = new DataOutputStream(socket.getOutputStream());
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out.writeBytes(studentID + '\n');
                    retValue = in.readLine();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return retValue;
    }
}
