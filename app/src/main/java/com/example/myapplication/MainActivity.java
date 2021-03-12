package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    //from Interface
    //private EditText studentID;
    private TextView answerFromServer;
    private Button btn;
    EditText studentID;

    // calling serverActivity;
    ServerActivity serverActivity = new ServerActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn = findViewById(R.id.abschicken_Button);
        answerFromServer = findViewById(R.id.text_fromServer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentID = (EditText) findViewById(R.id.input_Matrikelnummer);
                String str = studentID.getText().toString();
                answerFromServer.setText((serverActivity.serverThread(str)));

            }
        });

        }



}