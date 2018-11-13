package com.greateam.burgertime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.firebase.messaging.FirebaseMessaging;
import com.greateam.burgertime.common.log.Dlog;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    Button closePopupBtn;
    PopupWindow popupWindow;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dlog.d("Burger TIME Start");

        FirebaseMessaging.getInstance().subscribeToTopic("ALL");

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

        Button buttonLottie = findViewById(R.id.buttonLottie); /*페이지 전환버튼*/
        buttonLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LottieActivity.class);
                startActivity(intent);
            }
        });

        Button buttonDataBase = findViewById(R.id.buttonDataBase); /*페이지 전환버튼*/
        buttonDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DataBaseActivity.class);
                startActivity(intent);
            }
        });

        mainLayout = findViewById(R.id.mainLayout);

        Button buttonPopup = findViewById(R.id.buttonPopup); /*페이지 전환버튼*/
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.activity_popup,null);

                closePopupBtn = customView.findViewById(R.id.closePopupBtn);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                //display the popup window
                popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

                //close the popup window on button click
                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });

        Button buttonFullscreen = findViewById(R.id.buttonFullscreen); /*페이지 전환버튼*/
        buttonFullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FullscreenActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCoverFlow = findViewById(R.id.buttonCoverFlow); /*페이지 전환버튼*/
        buttonCoverFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CoverFlowActivity.class);
                startActivity(intent);
            }
        });
    }
}
