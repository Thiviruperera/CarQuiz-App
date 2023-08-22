package com.example.thiviruapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IdentifyCarMake extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    ArrayList<CarData> testData;
    ImageView imageView8;
    Button button7;
    Spinner spinner;
    boolean initialLaunch;
    ArrayList<String> modelNames;
    int[] resIds;
    CarData randomInstance;
    CarData selectedInstance;
    ResultDialog dialog;
    CountDownTimer cTimer = null;
    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_make);
        //Initializations
        button7 = findViewById(R.id.button7);
        imageView8 = findViewById(R.id.imageView8);
        spinner = findViewById(R.id.spinner);
        textView11 = findViewById(R.id.textView11);
        button7.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);

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

        //fill
        int i = 0;
        modelNames = new ArrayList<>();
        resIds = new int[testData.size()];
        for (CarData car : testData){
            if(!modelNames.contains(car.getCarMake())){
                modelNames.add(car.getCarMake());
            }
            resIds[i] = car.getImageId();
            i++;
        }



        //Spinner Init
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,modelNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        //getRandomCar OBJ
        randomInstance = testData.get(1);

        dialog = new ResultDialog(this);

        //set img
        imageView8.setImageResource(testData.get(1).getImageId());
    }

    @Override
    public void onClick(View view) {
        if(initialLaunch){
            if(randomInstance.getCarMake().equals(selectedInstance.getCarMake()))
                dialog.showCorrect1();
            else{
                dialog.showWrong1(randomInstance.getCarMake());
            }
            button7.setText("Next");
            initialLaunch = false;
            System.out.println("init LAUCH");
        }else{
            System.out.println("NOT init LAUCH");

            initialLaunch = true;
            Intent i = getIntent();
            i.putExtra("initialLaunch",true);
            finish();
            startActivity(i);
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        selectedInstance = testData.get(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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