package com.example.uravnenie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uravnenie.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final TextView TextView4 = findViewById(R.id.textView4);
        final EditText editText = findViewById(R.id.editText);
        final EditText editText2 = findViewById(R.id.editText2);
        final EditText editText3 = findViewById(R.id.editText3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = editText.getText().toString();
                String g = editText2.getText().toString();
                String m = editText3.getText().toString();
                double a = Double.parseDouble(r);
                double b = Double.parseDouble(g);
                double c = Double.parseDouble(m);

                if ((a == 0) && (b == 0) && (c == 0)) {
                    TextView4.setText("x - любое число");
                } else {
                    if ((a == 0) && (b == 0)) {
                        TextView4.setText("нет рациональных корней");
                    } else {
                        if ((b == 0) && (c == 0)) {
                            TextView4.setText("0 - корень");
                        } else {
                            if (a == 0) {
                                final double x1 = ((-c) / b);
                                final String d = (x1 + " - корень ");
                                TextView4.setText(d);
                            } else {
                                if (b == 0) {
                                    if (((a < 0) && (c > 0)) || ((a > 0) && (c < 0))) {
                                        final double x1 = Math.sqrt((-c) / a);
                                        final double x2 = -Math.sqrt((-c) / a);
                                        final String d = (x1 + " - первый корень ");
                                        final String f = (x2 + " - второй корень");
                                        TextView4.setText(d + f);
                                    }else TextView4.setText("нет рациональных корней");
                                } else {
                                    if (c == 0) {
                                        final double x1 = ((-b) / a);
                                        final String d = (x1 + " - второй корень ");
                                        TextView4.setText("0 - первый корень" + d);
                                    }
                                    if ((b * b - 4 * a * c) < 0)
                                        TextView4.setText("Нет рациональных корней!!!");
                                    else {
                                        if ((b * b - 4 * a * c) == 0) {
                                            final double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                                            final String d = (x1 + " - корень ");
                                            TextView4.setText(d);
                                        } else {
                                            final double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                                            final double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                                            final String d = (x1 + " - первый корень ");
                                            final String f = (x2 + " - второй корень");
                                            TextView4.setText(d + f);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        });
    }

}
