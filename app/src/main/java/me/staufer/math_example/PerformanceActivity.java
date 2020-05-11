package me.staufer.math_example;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import me.staufer.textools.MathView;

public class PerformanceActivity extends AppCompatActivity {
    private static final String[] symbols = new String[]{"\\sum", "+", "\\frac", "-", "\\times", "\\text{ lol }", "\\int", "\\pi"};
    private static final List colors = Arrays.asList(
            0xfff44336, 0xffe91e63, 0xff9c27b0, 0xff673ab7,
            0xff3f51b5, 0xff2196f3, 0xff03a9f4, 0xff00bcd4,
            0xff009688, 0xff4caf50, 0xff8bc34a, 0xffcddc39,
            0xffffeb3b, 0xffffc107, 0xffff9800, 0xffff5722,
            0xff795548, 0xff9e9e9e, 0xff607d8b, 0xff333333
    );
    private static final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        ViewGroup layout = findViewById(R.id.layout);

        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> options = new HashMap<String, Object>();
            options.put("tex", randomTex());
            options.put("backgroundColor", randomColor());
            MathView mathView = new MathView(getApplicationContext(), options);
            mathView.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    100)
            );
            layout.addView(mathView);
        }
    }

    private String randomTex() {
        StringBuffer buffer = new StringBuffer();

        int length = rnd.nextInt(5);
        for (int i = 0; i < length; i++) {
            buffer.append(rnd.nextInt(200));
            buffer.append(symbols[rnd.nextInt(symbols.length)]);
        }
        buffer.append(rnd.nextInt(200));

        return buffer.toString();
    }

    private int randomColor() {
        return (int) colors.get(rnd.nextInt(colors.size()));
    }
}
