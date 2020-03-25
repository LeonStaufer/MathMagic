package me.staufer.mathmagic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MathView extends WebView {
    private final JSONObject options;

    @SuppressLint("SetJavaScriptEnabled")
    public MathView(Context context, AttributeSet attrs) {
        super(context, attrs);

        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);

        this.addJavascriptInterface(new MathViewInterface(context), "MathViewInterface");
        this.loadUrl("file:///android_asset/index.html");

        options = new JSONObject();
        try {
            options.put("throwOnError", false);
            options.put("displayMode", true);
            options.put("color", "white");
            options.put("background", "black");
            //TODO fix newlines https://katex.org/docs/options.html, see trust
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final MathView mathView = this;

        this.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                //TODO might cause flash of unstyled document
                mathView.loadUrl("javascript:init("+options.toString() + ")");
            }
        });
    }

    public void render(String tex) {
        this.render(tex, this.options);
    }

    public void render(String tex, JSONObject options) {
        tex = Html.escapeHtml(tex);
        tex = StringEscapeUtils.escapeEcmaScript(tex);
        this.loadUrl("javascript:update('" + tex + "'," + options.toString() + ")");
    }
}
