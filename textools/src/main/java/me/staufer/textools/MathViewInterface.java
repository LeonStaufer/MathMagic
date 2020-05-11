package me.staufer.textools;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Javascript Interface for MathView
 */
public class MathViewInterface {
    private static String TAG = "MathViewInterface";

    private Context context;
    private int height;

    /**
     * MathViewInterface constructor that takes context of the interface
     *
     * @param c Context
     */
    public MathViewInterface(Context c) {
        context = c;
    }

    /**
     * @param height
     */
    @JavascriptInterface
    public void updateHeight(int height) {
        this.height = height;
    }

    /**
     * JavaScript interface that allows Android logging
     *
     * @param msg to be logged
     */
    @JavascriptInterface
    public void log(String msg) {
        Log.i(TAG, msg);
    }

    /**
     * JavaScript interface that allows Android logging
     */
    @JavascriptInterface
    public void warn(String errorCode, String errorMessage) {
        Log.w(TAG, errorCode + ": " +errorMessage);
    }

    public int getHeight() {
        return height;
    }
}
