package com.example.thiviruapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class IdentifyCarImage extends AppCompatActivity implements View.OnClickListener {

    ArrayList<CarData> testData;
    ImageView imageView1,imageView2,imageView3;
    CarData randomCarInstance, randomCarInstance2, randomCarInstance3;
    Button button6;
    TextView textView2;
    ResultDialog dialog;
    String selectedName;
    int index;
    boolean initialLaunch;
    CountDownTimer cTimer = null;
    TextView textView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_image);
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView5);
        imageView3 = findViewById(R.id.imageView6);
        textView2 = findViewById(R.id.textView2);
        button6 = findViewById(R.id.button6);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        button6.setOnClickListener(this);
        dialog = new ResultDialog(this);
        textView11 = findViewById(R.id.textView11);

        initialLaunch = getIntent().getBooleanExtra("initialLaunch",true);
        if(getIntent().getBooleanExtra("isTimerOn",false)){
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
        //setting name random

        int no = new Random().nextInt(3);
        if(no == 0) {
            selectedName = randomCarInstance.getCarMake();
            textView2.setText(randomCarInstance.getCarMake());
        }
        else if(no == 1) {
            selectedName = randomCarInstance2.getCarMake();
            textView2.setText(randomCarInstance2.getCarMake());
        }
        else {
            selectedName = randomCarInstance3.getCarMake();
            textView2.setText(randomCarInstance3.getCarMake());
        }



        //getRandomCar OBJ
        imageView1.setImageResource(randomCarInstance.getImageId());
        imageView2.setImageResource(randomCarInstance2.getImageId());
        imageView3.setImageResource(randomCarInstance3.getImageId());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.imageView){
            button6.setText("NEXT");
            if(randomCarInstance.getCarMake().equals(selectedName)){
                dialog.showCorrect1();
            }else{
                dialog.showWrong2();
            }
        }else if(id == R.id.imageView5){
            button6.setText("NEXT");
            if(randomCarInstance2.getCarMake().equals(selectedName)){
                dialog.showCorrect1();
            }else{
                dialog.showWrong2();
            }
        }else if(id == R.id.imageView6){
            button6.setText("NEXT");
            if(randomCarInstance3.getCarMake().equals(selectedName)){
                dialog.showCorrect1();
            }else{
                dialog.showWrong2();
            }
        }else if(id == R.id.button6){
            initialLaunch = true;
            Intent i = getIntent();
            i.putExtra("initialLaunch",true);
            finish();
            startActivity(i);
        }
    }

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView11.setText("Timer : "+ millisUntilFinished / 1000);
            }
            public void onFinish() {
                initialLaunch = true;
                Intent i = getIntent();
                i.putExtra("initialLaunch",true);
                finish();
                startActivity(i);

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