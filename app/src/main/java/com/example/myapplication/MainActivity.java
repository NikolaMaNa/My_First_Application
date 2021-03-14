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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //from Interface
    //private EditText studentID;
    private TextView answerFromServer,result;
    private Button btn,btn2;
    EditText studentID;

    // calling serverActivity;
    ServerActivity serverActivity = new ServerActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variables for server
        btn = findViewById(R.id.abschicken_Button);
        btn.setOnClickListener(this);
        answerFromServer = findViewById(R.id.text_fromServer);

        //variables for divisor excercise
        btn2 = findViewById(R.id.berechnen_Button);
        btn2.setOnClickListener(this);
        result = findViewById(R.id.resultOfDivisor);

    }

    @Override
    public void onClick(View view) {
        studentID = (EditText) findViewById(R.id.input_Matrikelnummer);
        String str = studentID.getText().toString();
        switch (view.getId()){
            case R.id.abschicken_Button:
                answerFromServer.setText((serverActivity.serverThread(str)));
                break;
            case R.id.berechnen_Button:
                String[] arrayString = str.split("");
                int[] arrayInt = converStringArrayToIntArray(arrayString);
                result.setText(calculate(arrayInt));
                break;
            default:
                answerFromServer.setText("Something went wrong!");
        }
    }



    public String calculate(int[] array) {
        String result = "";
        int firstDividend = 0;
        int secondDividend = 0;
        int divisor = 2;
        int count=0;
        while (count<1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 1 && array[i] % divisor == 0) {
                    if (firstDividend == 0) {firstDividend = i;}
                    else if (secondDividend == 0) {
                        secondDividend = i;
                        result ="First dividend at index: " + firstDividend + '\n' +
                                "Second dividend at index: " + secondDividend + '\n' +
                                "Divisor: " + divisor;
                        count++;
                    }
                }
            }
            divisor++;
            firstDividend = 0;
            secondDividend = 0;
        }
        return result;
    }

    public int[] converStringArrayToIntArray(String[] str){
        int[] array = new int[str.length];

        for (int i = 0; i<str.length;i++){
            array[i]= Integer.parseInt(str[i]);
        }

        return array;

    }



}