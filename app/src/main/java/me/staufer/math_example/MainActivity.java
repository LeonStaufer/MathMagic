package me.staufer.math_example;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import me.staufer.textools.MathView;

/**
 * Basic example to show how MathView works
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get MathView component
        final MathView mathView = findViewById(R.id.mathview);
        //render TeX, backslashes need to be escaped
        mathView.render("x \\times x = x^2 \\\\ \\text{Example in Java}");

        //get components for interactive MathView
        final MathView mathViewInteractive = findViewById(R.id.mathview_interactive);
        final EditText input = findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mathViewInteractive.render(s.toString());
            }
        });
    }
}
