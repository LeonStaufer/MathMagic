package me.staufer.mathmagic;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Javascript Interface for MathView
 */
public class MathViewInterface {
    private Context context;
    private int height;

    /**
     * MathViewInterface constructor that takes context of the interface
     * @param c Context
     */
    public MathViewInterface(Context c) {
        context = c;
    }

    /**
     * @param height
     */
    @JavascriptInterface
    public void updateHeight(int height){
        this.height = height;
    }

    /**
     * JavaScript interface that allows Android logging
     * @param msg to be logged
     */
    @JavascriptInterface
    public void log(String msg){
        Log.i("MathViewInterface", msg);
    }

    public int getHeight() {
        return height;
    }
}
