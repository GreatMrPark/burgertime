package com.greateam.burgertime.game.example;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.greateam.burgertime.MainActivity;
import com.greateam.burgertime.R;

public class ViewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        setContentView(myView);
    }


    class MyView extends View {
        MyView(Context context) {
            super(context);
            setBackgroundColor(Color.GREEN);
        }

        public boolean onTouchEvent(MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(ViewEventActivity.this, "View클래스를 상속받아 만든 이벤트 처리"
                        , Toast.LENGTH_SHORT).show();
            }
            return false;
        }

    }
}
