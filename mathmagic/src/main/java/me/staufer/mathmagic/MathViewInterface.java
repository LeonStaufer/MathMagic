package me.staufer.mathmagic;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MathViewInterface {
    private Context context;
    private int height;

    public MathViewInterface(Context c) {
        context = c;
    }

    @JavascriptInterface
    public void updateHeight(int height){
        this.height = height;
    }

    @JavascriptInterface
    public void log(String msg){
        Log.i("MathViewInterface", msg);
    }

    public int getHeight() {
        return height;
    }
}
