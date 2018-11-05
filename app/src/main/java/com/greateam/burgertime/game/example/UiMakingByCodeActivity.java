package com.greateam.burgertime.game.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.greateam.burgertime.R;

public class UiMakingByCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView t1 = new TextView(this);
        t1.setTextSize(30);
        t1.setText("코드로 화면 구성.");
        layout.addView(t1);

        ImageView i1 = new ImageView(this);
        i1.setImageResource(R.drawable.spaceship);
        layout.addView(i1);
        setContentView(layout);
    }
}
