package com.greateam.burgertime.game.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.greateam.burgertime.R;

public class UimakingByCodeXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimaking_by_code_xml);

        TextView t1 = (TextView) findViewById(R.id.t1);
        t1.setTextSize(30);
        t1.setText("Success!");
    }
}
