package com.example.vicky.lec3hwownbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

     WebView myWebView ;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);

        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());  //by doing this now the app will open in our own webView rather in other browser;
        myWebView.loadUrl("https://www.google.com/");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editText.getText().toString();

                myWebView.setWebViewClient(new WebViewClient());  //by doing this now the app will open in our own webView rather in other browser;
                myWebView.loadUrl(name);

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (myWebView.canGoBack()){
            myWebView.goBack();
        }
        else {
            super.onBackPressed();  //this command code will directly close the app; so we modify above;before this;

        }

    }
}
