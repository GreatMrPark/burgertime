package com.greateam.burgertime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.setAnimation("lottie/rejection.json");
        animationView.loop(true);
        animationView.playAnimation();
    }
}
