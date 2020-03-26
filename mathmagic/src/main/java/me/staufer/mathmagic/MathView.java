package me.staufer.mathmagic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * MathView class that can render TeX using KaTeX in WebView
 */
public class MathView extends WebView {
    private final JSONObject options;

    /**
     * constructor for creating a MathView
     *
     * @param context Context of View
     * @param attrs   AttributeSet
     */
    @SuppressLint("SetJavaScriptEnabled")
    public MathView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //enable JavaScript
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //connect MathViewInterface to MathView
        this.addJavascriptInterface(new MathViewInterface(context), "MathViewInterface");

        //create JSON options object
        //TODO take options from attrs
        options = new JSONObject();
        try {
            options.put("throwOnError", false);
            options.put("displayMode", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //default URI
        URI uri = URI.create("file:///android_asset/index.html");
        try {
            //URI with options
            uri = new URI("file", null, "///android_asset/index.html", "options=" + options.toString(), null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //load HTML page with KaTeX
        this.loadUrl(uri.toString());
    }

    /**
     * render a TeX string in the MathView
     *
     * @param tex string using the TeX format
     */
    public void render(String tex) {
        this.render(tex, this.options);
    }

    /**
     * render a TeX string in the MathView with the given options
     *
     * @param tex     string using the TeX format
     * @param options JSONObject with options for MathView and KaTeX
     */
    public void render(String tex, JSONObject options) {
        //sanitize input
        tex = Html.escapeHtml(tex);
        tex = StringEscapeUtils.escapeEcmaScript(tex);
        //call JS update function with tex and options
        this.loadUrl("javascript:update('" + tex + "'," + options.toString() + ")");
    }
}
