package com.greateam.burgertime;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.greateam.burgertime.common.db.DBHelper;
import com.greateam.burgertime.common.log.Dlog;
import com.greateam.burgertime.common.utils.AndroidBridge;

import static com.greateam.burgertime.common.utils.CommonUtils.getWhatKindOfNetwork;


public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView = null;
    private String myUrl = "file:///android_asset/www/";
    private boolean newtwork = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBook.db", null, 1);

        // 앱 실행시 체크
        String getNetwork =  getWhatKindOfNetwork(getApplication());
        if(getNetwork.equals("NONE")){
            newtwork = false;
        }
        Dlog.d("newtwork : " + newtwork);

        //이전 액티비티에서 수신할 데이터를 받기위해 선언
        Intent intent = getIntent();

        //호출한 액티비티에서 String 이라는 키 값을 가진 데이터 로드
        String url = intent.getStringExtra("url");
        Dlog.d("myUrl : " + myUrl);
        Dlog.d("url : " + url);

        if (!"".equals(url)) {
            myUrl +=  url;
        }
        Dlog.d("myUrl : " + myUrl);

        // 웹뷰 셋팅팅
        final Context BurgerTimeApp = this;
        mWebView = findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(myUrl); // 접속 URL
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result) {
                new AlertDialog.Builder(BurgerTimeApp)
                        .setTitle("AlertDialog")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok,
                                new AlertDialog.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        result.confirm();
                                    }
                                })
                        .setCancelable(false)
                        .create()
                        .show();

                return true;
            };

        });
        mWebView.setWebViewClient(new WebViewClientClass());

        // Bridge 인스턴스 등록
        mWebView.addJavascriptInterface(new AndroidBridge(mWebView, dbHelper, newtwork), "BurgerTimeApp");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Dlog.d("url : " + url);
            view.loadUrl(url);
            return true;
        }
    }

}
