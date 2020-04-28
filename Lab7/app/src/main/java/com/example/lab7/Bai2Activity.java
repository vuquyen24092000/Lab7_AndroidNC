package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Bai2Activity extends AppCompatActivity {
    Button btnAll, btnNobita, btnDoraemon;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        btnAll = findViewById(R.id.btnAll);
        btnNobita = findViewById(R.id.btnNobita);
        btnDoraemon = findViewById(R.id.btnDoraemon);
        img = findViewById(R.id.image);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("All");
            }
        });
        btnNobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("Nobita");
            }
        });
        btnDoraemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("Doraemon");
            }
        });
    }

    private void showImage(String image) {
        //ẩn ảnh
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img, "translationX", 0f, 500f);
        objectAnimator.setDuration(2000);

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f);
        objectAnimator.setDuration(2000);

        //show ảnh, ngược lại với ẩn ảnh
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(img, "translationX", -500f, 0f);
        objectAnimator.setDuration(2000);

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(img, "alpha", 0f, 1f);
        objectAnimator.setDuration(2000);

        //show những hình ảnh tiếp theo
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator2).with(objectAnimator3).after(objectAnimator).after(objectAnimator1);
        animatorSet.start();

        final String imageName = image;
        objectAnimator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (imageName == "Nobita") {
                    img.setImageResource(R.drawable.nobita);
                }
                if (imageName == "Doraemon") {
                    img.setImageResource(R.drawable.doraemon);
                }
                if (imageName == "All") {
                    img.setImageResource(R.drawable.all);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
