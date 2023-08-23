package com.aj_puzon.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Slide extends AppCompatActivity {

    Intent Slide;
    ConstraintLayout SlideLayout;
    int currentIndex = 0;
    View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        Intent intent = getIntent();
        int currentIndex = intent.getIntExtra("currentIndex", 0);
        int[] images = intent.getIntArrayExtra("images");

        // detect if we're on the last slide
        if (images.length == currentIndex + 1) {
            finish();
        }

        // instantiate a new Slide
        // and inject our variables to it
        Slide = new Intent(".Slide");
        Slide.putExtra("currentIndex", currentIndex+1);
        Slide.putExtra("images", images);

        container = findViewById(R.id.slide);
        container.setBackgroundResource(images[currentIndex]);

        Thread tmr = new Thread() {
            public void run() {
                try {
                    sleep(2000);
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