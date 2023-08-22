package com.example.thiviruapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;


public class ResultDialog {

    private Activity context;

    public ResultDialog(Activity context){
        this.context = context;
    }

    public void showWrong1(String correctModel){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.wrong_screen1, null);
        builder.setView(dialogLayout);

        final AlertDialog ad = builder.show();
        TextView txt = dialogLayout.findViewById(R.id.textView5);
        txt.setText("Car is a "+correctModel);
        dialogLayout.findViewById(R.id.rateHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

    }

    public void showWrong3(String correctModel1,String correctModel2,String correctModel3){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.wrong_screen3, null);
        builder.setView(dialogLayout);

        final AlertDialog ad = builder.show();
        TextView txt = dialogLayout.findViewById(R.id.textView5);
        TextView txt2 = dialogLayout.findViewById(R.id.textView6);
        TextView txt3 = dialogLayout.findViewById(R.id.textView7);

        txt.setText("Image 1 : "+correctModel1);
        txt2.setText("Image 2 : "+correctModel2);
        txt3.setText("Image 3 : "+correctModel3);


        dialogLayout.findViewById(R.id.rateHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

    }

    public void showWrong2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.wrong_screen2, null);
        builder.setView(dialogLayout);

        final AlertDialog ad = builder.show();
        dialogLayout.findViewById(R.id.rateHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

    }

    public void showCorrect1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.correct_screen1, null);
        builder.setView(dialogLayout);

        final AlertDialog ad = builder.show();
        dialogLayout.findViewById(R.id.rateHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });
    }
}
