package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Bai3Activity extends AppCompatActivity {
    ImageView imgHour, imgMinute, imgSecond;
    Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imgHour = findViewById(R.id.imgHour);
        imgMinute = findViewById(R.id.imgMinute);
        imgSecond = findViewById(R.id.imgSecond);
        btnRun = findViewById(R.id.btnRun);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objSecond = ObjectAnimator.ofFloat(imgSecond, "rotation", 0, 360);
                objSecond.setDuration(36000);
                objSecond.start();

                ObjectAnimator objMinute = ObjectAnimator.ofFloat(imgMinute, "rotation", 0, 360);
                objMinute.setDuration(360000);
                objMinute.start();

                ObjectAnimator objHour = ObjectAnimator.ofFloat(imgHour, "rotation", 0, 360);
                objHour.setDuration(3600000);
                objHour.start();

            }
        });
    }
}
