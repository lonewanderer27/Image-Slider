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
            R.drawable.ayumi_yoshida,
            R.drawable.genta_kojima,
            R.drawable.haibara_ai,
            R.drawable.heiji,
            R.drawable.hiroshi_agasa,
            R.drawable.kogoro_mouri,
            R.drawable.mitsuhiko_tsuburaya,
            R.drawable.ran_mouri,
            R.drawable.shinichi_kudo,
            R.drawable.sonoko_suzuki
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