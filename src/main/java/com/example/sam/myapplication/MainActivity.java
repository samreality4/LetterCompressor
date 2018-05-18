package com.example.sam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    String enteredText;
    String result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.hello_world);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enteredText = String.valueOf(editText.getText());
                textView.setText(compress(enteredText));

            }
        });
    }

    public static String compress(String input) {
        String output;
        int originaLength = input.length();
        int letterPosition = 0;
        int count = 0;

        StringBuilder stringBuilder = new StringBuilder();


            while (letterPosition < originaLength) {
                count = 0;

                while (letterPosition + count < originaLength && input.charAt(letterPosition + count) == input.charAt(letterPosition)) {
                    count++;
                }

                stringBuilder.append(input.charAt(letterPosition));
                if (count >= 1) {
                    stringBuilder.append(count);
                }
                letterPosition = letterPosition + count;

                }

        output = stringBuilder.toString();
        if (output.length() < originaLength) {
            return output;
        } else {
            return input;
        }


    }
}