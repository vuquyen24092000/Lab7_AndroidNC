package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Bai1Activity extends AppCompatActivity {
    Button btnRotation, btnMoving, btnZoom;
    ImageView img;
    float dest;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        btnMoving = findViewById(R.id.btnMoving);
        btnRotation = findViewById(R.id.btnRotation);
        btnZoom = findViewById(R.id.btnZoom);
        img = findViewById(R.id.image);

        btnRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest = 360;
                if (img.getRotation() == 360) {
                    System.out.println(img.getAlpha());
                    dest = 0;
                }
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "rotation", dest);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
            }
        });

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Bai1Activity.this, R.anim.zoom);
                img.startAnimation(animation);
            }
        });

        btnMoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "translationX", 0f, 200f);
                objectAnimator.setDuration(2000);
                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator.start();
            }
        });
    }
}
