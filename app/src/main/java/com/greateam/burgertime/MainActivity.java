package com.greateam.burgertime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.greateam.burgertime.common.log.Dlog;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dlog.d("Burger TIME Start");

        editUrl = findViewById(R.id.editUrl);

        Button buttonNavigation = findViewById(R.id.buttonNavigation); /*페이지 전환버튼*/
        buttonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonWebView = findViewById(R.id.buttonWebView); /*페이지 전환버튼*/
        buttonWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = editUrl.getText().toString();

                Intent intent = new Intent(getApplicationContext(),WebViewActivity.class);
                intent.putExtra("url",url);

                startActivity(intent);
            }
        });
    }
}
