package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Aflevering01_GetStarted extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, okButton;
    WebView webView;
    TextView velkommen, browserReq;
    String userName, browserSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set default view til starting screen
        setContentView(R.layout.activity_get_started);

        //opret reference til TextView ved indtastning af navn og browser
        velkommen = (EditText) findViewById(R.id.velkommenText);
        browserReq = (EditText) findViewById(R.id.browserReq);

        //opret reference til knapperne på app'n
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        okButton = (Button) findViewById(R.id.okButton);

        //opret listners til knapper som bliver sendt til switchcase længere nede
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        okButton.setOnClickListener(this);

        //Create webview som default går til Google.com
        webView= (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        //tillad javascript i browser
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Toast.makeText(this, "Textchange knappen er blevet klikket", Toast.LENGTH_SHORT).show();
                System.out.println("Textchange knappen er blevet klikket");
                button1.setText("Hej. Jeg er ny :)");
                break;
            case R.id.button2:
                Intent i = new Intent(this,TestIntent.class);
                startActivity(i);
                Toast.makeText(this, "New activity started", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                browserSet=browserReq.getText().toString();
                webView.loadUrl(browserSet);
                Toast.makeText(this, "Browser knappen er blevet klikket", Toast.LENGTH_SHORT).show();
                System.out.println("Browser knappen er blevet klikket");
                break;
            case R.id.okButton:
                userName=velkommen.getText().toString();
                Toast.makeText(this, "Velkommen, " + userName, Toast.LENGTH_SHORT).show();
                System.out.println("Velkommen knappen er blevet klikket");
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //Checker hvis vi er i et webview så vi kan bruge backknappen på webpagen
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}