package eus.asier.multicounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter1 = 0; // Kontagailua 1
    private int counter2 = 0; // Kontagailua 2
    private int counter3 = 0; // Kontagailua 3
    private int counter4 = 0; // Kontagailua 4
    private int counterAll = 0; // Kontagailu guztien batura
    private Button sumButton1, sumButton2, sumButton3, sumButton4; // Gehitzeko botoiak
    private Button resetButton1, resetButton2, resetButton3, resetButton4, resetAllButton; // Berrezartzeko botoiak
    private TextView counterTextView0, counterTextView1, counterTextView2, counterTextView3, counterTextView4; // Kontagailuen TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botoiak eta testu-koadroak hasieratu
        resetButton1 = findViewById(R.id.reset1);
        resetButton2 = findViewById(R.id.reset2);
        resetButton3 = findViewById(R.id.reset3);
        resetButton4 = findViewById(R.id.reset4);
        resetAllButton = findViewById(R.id.resetAll);

        sumButton1 = findViewById(R.id.sum1);
        sumButton2 = findViewById(R.id.sum2);
        sumButton3 = findViewById(R.id.sum3);
        sumButton4 = findViewById(R.id.sum4);

        counterTextView0 = findViewById(R.id.counterAll);
        counterTextView1 = findViewById(R.id.counter1);
        counterTextView2 = findViewById(R.id.counter2);
        counterTextView3 = findViewById(R.id.counter3);
        counterTextView4 = findViewById(R.id.counter4);

        // Botoien klik-ak hasieratu
        sumButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter1++;
                update();
            }
        });

        sumButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter2++;
                update();
            }
        });

        sumButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter3++;
                update();
            }
        });

        sumButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter4++;
                update();
            }
        });

        // Berrezartzeko botoien klik-ak hasieratu
        resetButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter1 = 0;
                update();
            }
        });

        resetButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter2 = 0;
                update();
            }
        });

        resetButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter3 = 0;
                update();
            }
        });

        resetButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter4 = 0;
                update();
            }
        });

        // Guztien berrezartzeko botoiaren klik-a hasieratu
        resetAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter1 = 0;
                counter2 = 0;
                counter3 = 0;
                counter4 = 0;
                update();
            }
        });
    }

    // Kontagailuak eguneratu
    private void update() {
        counterAll = counter1 + counter2 + counter3 + counter4;

        counterTextView1.setText(String.valueOf(counter1));
        counterTextView2.setText(String.valueOf(counter2));
        counterTextView3.setText(String.valueOf(counter3));
        counterTextView4.setText(String.valueOf(counter4));

        counterTextView0.setText(String.valueOf(counterAll));
    }
}
