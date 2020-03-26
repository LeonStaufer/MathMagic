package me.staufer.math_example;

import androidx.appcompat.app.AppCompatActivity;
import me.staufer.mathmagic.MathView;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Basic example to show how MathView works
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get MathView Elemenet
        final MathView mathView = findViewById(R.id.mathview);
        mathView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //render TeX once MathView has loaded
                //backslashes need to be escaped
                mathView.render("x \\times x = x^2 \\ \\ \\text{Example}");
            }
        });
    }
}
