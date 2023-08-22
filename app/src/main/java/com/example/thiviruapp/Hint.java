package com.example.thiviruapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Hint extends AppCompatActivity implements View.OnClickListener{
    ArrayList<CarData> testData;
    EditText editTextTextPersonName4;
    TextView textView3,textView11;
    Button button8;
    ImageView imageView9;
    CarData randomInstance;
    CarData selectedInstance;
    ResultDialog dialog;
    String[] correctModelName;
    int wrongCounter;
    boolean initialLaunch,isTimerOn;
    CountDownTimer cTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        textView3 = findViewById(R.id.textView3);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        imageView9 = findViewById(R.id.imageView9);
        textView11 = findViewById(R.id.textView11);

        initialLaunch = getIntent().getBooleanExtra("initialLaunch",true);
        isTimerOn = getIntent().getBooleanExtra("isTimerOn",false);

        if(isTimerOn){
            System.out.println("HALLO"+isTimerOn);

            textView11.setVisibility(View.VISIBLE);
            startTimer();
        }

        //Adding Sample data
        testData = new ArrayList<>();
        testData.add(new CarData(R.drawable.audi, "audi"));
        testData.add(new CarData(R.drawable.audi1, "audi"));
        testData.add(new CarData(R.drawable.audi2, "audi"));
        testData.add(new CarData(R.drawable.audi3, "audi"));
        testData.add(new CarData(R.drawable.audi4, "audi"));
        testData.add(new CarData(R.drawable.audi5, "audi"));

        testData.add(new CarData(R.drawable.mercedes, "mercedes"));
        testData.add(new CarData(R.drawable.mercedes1, "mercedes"));
        testData.add(new CarData(R.drawable.mercedes2, "mercedes"));
        testData.add(new CarData(R.drawable.mercedes3, "mercedes"));
        testData.add(new CarData(R.drawable.mercedes4, "mercedes"));
        testData.add(new CarData(R.drawable.mercedes5, "mercedes"));

        testData.add(new CarData(R.drawable.nissan, "nissan"));
        testData.add(new CarData(R.drawable.nissan1, "nissan"));
        testData.add(new CarData(R.drawable.nissan2, "nissan"));
        testData.add(new CarData(R.drawable.nissan3, "nissan"));
        testData.add(new CarData(R.drawable.nissan4, "nissan"));
        testData.add(new CarData(R.drawable.nissan5, "nissan"));

        testData.add(new CarData(R.drawable.volvo, "volvo"));
        testData.add(new CarData(R.drawable.volvo1, "volvo"));
        testData.add(new CarData(R.drawable.volvo2, "volvo"));
        testData.add(new CarData(R.drawable.volvo3, "volvo"));
        testData.add(new CarData(R.drawable.volvo4, "volvo"));
        testData.add(new CarData(R.drawable.volvo5, "volvo"));
        testData.add(new CarData(R.drawable.volvo6, "volvo"));

        testData.add(new CarData(R.drawable.toyota, "toyota"));
        testData.add(new CarData(R.drawable.toyota1, "toyota"));
        testData.add(new CarData(R.drawable.toyota2, "toyota"));
        testData.add(new CarData(R.drawable.toyota3, "toyota"));
        testData.add(new CarData(R.drawable.toyota4, "toyota"));
        testData.add(new CarData(R.drawable.toyota5, "toyota"));

        testData.add(new CarData(R.drawable.suzuki, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki1, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki2, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki3, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki4, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki5, "suzuki"));
        testData.add(new CarData(R.drawable.suzuki6, "suzuki"));
        //Shuffle after
        Collections.shuffle(testData);

        dialog = new ResultDialog(this);

        //getRandomCar OBJ
        randomInstance = testData.get(1);


        imageView9.setImageResource(randomInstance.getImageId());
        //Generating dasshes
        correctModelName = new String[randomInstance.getCarMake().length()];
        for(int i=0;i<randomInstance.getCarMake().length();i++){
            correctModelName[i] = "-";
        }

        //adding them
        textView3.setText(TextUtils.join("",correctModelName));
    }

    @Override
    public void onClick(View view) {
        //Reference - https://stackoverflow.com/questions/55091793/using-string-replace-method-in-a-for-loop-for-one-string

        if(button8.getText().equals("NEXT")){

            initialLaunch = true;
            Intent i = getIntent();
            i.putExtra("initialLaunch",true);
            finish();
            startActivity(i);
        }

        char inputWord = ' ';
        try{
            inputWord = editTextTextPersonName4.getText().toString().toLowerCase().charAt(0);
        }catch (Exception e){
            return;
        }
        
        if(wrongCounter < 2){
            StringBuilder sb = new StringBuilder( textView3.getText().toString());
            for (int i = 0; i < correctModelName.length; i++) {
                char toBeGuessedChar = randomInstance.getCarMake().charAt(i);
                char c = Character.toLowerCase(toBeGuessedChar);
                if (c == inputWord) {
                    sb.setCharAt(i, toBeGuessedChar);
                }
            }
            textView3.setText(sb.toString());

            if(randomInstance.getCarMake().equalsIgnoreCase(textView3.getText().toString())){
                dialog.showCorrect1();
                button8.setText("NEXT");


            }else if(!randomInstance.getCarMake().contains(Character.toString(inputWord))){
                wrongCounter++;
            }

        }else {
            button8.setText("NEXT");
            dialog.showWrong1(randomInstance.getCarMake());
        }


        editTextTextPersonName4.setText("");
    }

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView11.setText("Timer : "+ millisUntilFinished / 1000);
            }

            public void onFinish() {
                if(button8.getText().equals("NEXT")){

                    initialLaunch = true;
                    Intent i = getIntent();
                    i.putExtra("initialLaunch",true);
                    finish();
                    startActivity(i);
                }

                char inputWord = ' ';
                try{
                    inputWord = editTextTextPersonName4.getText().toString().toLowerCase().charAt(0);
                }catch (Exception e){
                    return;
                }

                if(wrongCounter < 3){
                    StringBuilder sb = new StringBuilder( textView3.getText().toString());
                    for (int i = 0; i < correctModelName.length; i++) {
                        char toBeGuessedChar = randomInstance.getCarMake().charAt(i);
                        char c = Character.toLowerCase(toBeGuessedChar);
                        if (c == inputWord) {
                            sb.setCharAt(i, toBeGuessedChar);
                        }
                    }
                    textView3.setText(sb.toString());

                    if(randomInstance.getCarMake().equalsIgnoreCase(textView3.getText().toString())){
                        dialog.showCorrect1();
                    }else{
                        wrongCounter++;
                        if(isTimerOn){
                            System.out.println("HALLO"+isTimerOn);

                            textView11.setVisibility(View.VISIBLE);
                            startTimer();
                        }
                    }
                }else {
                    button8.setText("NEXT");
                    dialog.showWrong1(randomInstance.getCarMake());
                }

            }
        };
        cTimer.start();
    }

    public void onStop () {
        cancelTimer();
        super.onStop();
    }

    //cancel timer
    void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }
}