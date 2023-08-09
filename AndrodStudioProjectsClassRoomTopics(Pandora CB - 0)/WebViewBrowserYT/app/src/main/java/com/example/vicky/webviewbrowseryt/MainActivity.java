package com.example.vicky.webviewbrowseryt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());  //by doing this now the app will open in our own webView rather in other browser;
                                                        //still now onclicking the back button after searching the app closes instead going to back;
                                                        //so we need to resolve this ; by using below onBackPressed();

        webView.loadUrl("https://www.google.com");  //now by doing just this it will open in an external browser and not in our app;
                                                    //so go up and do something;
                                                    //yes whenever you search anything in that google it will open in some other app;


        //if you want to have some web settings in your app then;

        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);   //here after dot . you can access whichever WebSettings you want in your app;



    }


    @Override
    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();  //this command code will directly close the app; so we modify above;before this;

        }

    }
}
