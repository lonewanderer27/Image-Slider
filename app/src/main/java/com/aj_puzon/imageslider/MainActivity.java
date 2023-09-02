package com.aj_puzon.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    int currentIndex = 0;
    int[] images = {
            R.drawable.k_2,
            R.drawable.k_3,
            R.drawable.k_4,
            R.drawable.k_5,
            R.drawable.k_6,
            R.drawable.k_7,
            R.drawable.k_8,
            R.drawable.k_9,
            R.drawable.k_10,
            R.drawable.k_11
    };
    Intent Slide;
    ConstraintLayout SlideLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slide = new Intent(".Slide");
        Slide.putExtra("currentIndex", currentIndex);
        Slide.putExtra("images", images);

        Thread tmr = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    startActivity(Slide);
                    finish();
                }
            }
        };
        tmr.start();
    }
}