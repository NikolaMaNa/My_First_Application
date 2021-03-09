package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    EditText studentID;
    TextView answerFromServer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentID = (EditText) findViewById(R.id.input_Matrikelnummer);
        btn = findViewById(R.id.abschicken_Button);
        answerFromServer = findViewById(R.id.text_fromServer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numb = Integer.valueOf(studentID.getText().toString());
                String res = String.valueOf(numb);
                answerFromServer.setText(res);
            }
        });
    }


}