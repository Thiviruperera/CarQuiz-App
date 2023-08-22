package com.example.thiviruapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button,button4,button2,button3;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        switch1 = findViewById(R.id.switch1);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.button){
            Intent intent = new Intent(this,IdentifyCarMake.class);
            intent.putExtra("isTimerOn",switch1.isChecked() ? true : false);
            startActivity(intent);
        }else if(id == R.id.button2){
            Intent intent = new Intent(this,Hint.class);
            intent.putExtra("isTimerOn",switch1.isChecked() ? true : false);
            startActivity(intent);
        }else if(id == R.id.button3){
            Intent intent = new Intent(this,IdentifyCarImage.class);
            intent.putExtra("isTimerOn",switch1.isChecked() ? true : false);
            startActivity(intent);
        }else if(id == R.id.button4){
            Intent intent = new Intent(this,AdvanceLevel.class);
            intent.putExtra("isTimerOn",switch1.isChecked() ? true : false);
            startActivity(intent);
        }
    }
}