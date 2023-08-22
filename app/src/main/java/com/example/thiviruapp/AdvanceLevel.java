package com.example.thiviruapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AdvanceLevel extends AppCompatActivity implements View.OnClickListener {

    ArrayList<CarData> testData;
    ImageView imageView2,imageView3,imageView4;
    Button button5;
    EditText editTextTextPersonName,editTextTextPersonName2,editTextTextPersonName3;
    CarData randomCarInstance, randomCarInstance2, randomCarInstance3;
    int index,score,tries;
    TextView textView8,textView9,textView, textView10;
    boolean isCorrect1,isCorrect2,isCorrect3;
    ResultDialog dialog;
    boolean initialLaunch,isTimerOn;
    CountDownTimer cTimer = null;
    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_level);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);

        textView = findViewById(R.id.textView);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);

        initialLaunch = getIntent().getBooleanExtra("initialLaunch",true);
        isTimerOn = getIntent().getBooleanExtra("isTimerOn",false);
        if(isTimerOn){
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


        randomCarInstance = testData.get(index);
        index++;
        randomCarInstance2 = testData.get(index);
        index++;
        randomCarInstance3 = testData.get(index);
        index++;


        dialog = new ResultDialog(this);



        //getRandomCar OBJ
        imageView2.setImageResource(randomCarInstance.getImageId());
        imageView3.setImageResource(randomCarInstance2.getImageId());
        imageView4.setImageResource(randomCarInstance3.getImageId());
    }

    @Override
    public void onClick(View view) {


        String car1EnteredName = editTextTextPersonName.getText().toString();
        String car2EnteredName = editTextTextPersonName2.getText().toString();
        String car3EnteredName = editTextTextPersonName3.getText().toString();


        if(button5.getText().equals("NEXT")){
            initialLaunch = true;
            Intent i = getIntent();
            i.putExtra("initialLaunch",true);
            finish();
            startActivity(i);
        }


        if(tries < 2 ){

            if(car1EnteredName.equalsIgnoreCase(randomCarInstance.getCarMake()) && !isCorrect1) {
                editTextTextPersonName.setText(car1EnteredName);
                editTextTextPersonName.setEnabled(false);
                score++;
                textView.setText("Score : "+score);
                editTextTextPersonName.setTextColor(Color.GREEN);
                isCorrect1 = true;
            }else if (!car1EnteredName.equalsIgnoreCase(randomCarInstance.getCarMake())){
                editTextTextPersonName.setTextColor(Color.RED);

            }

            if(car2EnteredName.equalsIgnoreCase(randomCarInstance2.getCarMake()) && !isCorrect2) {
                editTextTextPersonName2.setText(car2EnteredName);
                editTextTextPersonName2.setEnabled(false);
                score++;
                textView.setText("Score : "+score);
                editTextTextPersonName2.setTextColor(Color.GREEN);
                isCorrect2 = true;
            }else if (!car2EnteredName.equalsIgnoreCase(randomCarInstance2.getCarMake())){
                editTextTextPersonName2.setTextColor(Color.RED);
            }

            if(car3EnteredName.equalsIgnoreCase(randomCarInstance3.getCarMake()) && !isCorrect3) {
                editTextTextPersonName3.setText(car3EnteredName);
                editTextTextPersonName3.setEnabled(false);
                score++;
                textView.setText("Score : "+score);
                editTextTextPersonName3.setTextColor(Color.GREEN);
                isCorrect3 = true;
            }else if (!car3EnteredName.equalsIgnoreCase(randomCarInstance3.getCarMake())){
                editTextTextPersonName3.setTextColor(Color.RED);
            }


            tries++;
        }else if(!button5.getText().equals("NEXT")){
            button5.setText("NEXT");
            String wrong = getColoredSpanned("*WRONG*","#FF0000");
            if(editTextTextPersonName.getCurrentTextColor() == Color.RED){
                String ans = getColoredSpanned("This car is a "+randomCarInstance.getCarMake(),"#CCCC00");
                textView8.setVisibility(View.VISIBLE);
                textView8.setTextColor(Color.YELLOW);
                textView8.setText(Html.fromHtml(wrong+" "+ans));
            }

            if(editTextTextPersonName2.getCurrentTextColor() == Color.RED){
                String ans = getColoredSpanned("This car is a "+randomCarInstance2.getCarMake(),"#CCCC00");
                textView9.setVisibility(View.VISIBLE);
                textView9.setTextColor(Color.YELLOW);
                textView9.setText(Html.fromHtml(wrong+" "+ans));
            }

            if(editTextTextPersonName3.getCurrentTextColor() == Color.RED){
                String ans = getColoredSpanned("This car is a "+randomCarInstance3.getCarMake(),"#CCCC00");
                textView10.setVisibility(View.VISIBLE);
                textView10.setTextColor(Color.YELLOW);
                textView10.setText(Html.fromHtml(wrong+" "+ans));
            }
        }

        if(isTimerOn && (!isCorrect1 || !isCorrect2 || !isCorrect3)){
            textView11.setVisibility(View.VISIBLE);
            startTimer();
        }else if (isCorrect1 && isCorrect2 && isCorrect3){
            button5.setText("NEXT");
            cancelTimer();
        }

    }

    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView11.setText("Timer : "+ millisUntilFinished / 1000);
            }
            public void onFinish() {
                onClick(null);
            }
        };
        cTimer.start();
    }


    //cancel timer
    void cancelTimer() {
        if(cTimer!=null) {
            System.out.println("CLLEED");
            cTimer.cancel();
        }
    }

    public void onStop () {
        cancelTimer();
        super.onStop();
    }
}