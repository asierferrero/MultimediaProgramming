package eus.asier.multicounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int counter1 = 0; // Kontagailua 1
    private int counter2 = 0; // Kontagailua 2
    private int counter3 = 0; // Kontagailua 3
    private int counter4 = 0; // Kontagailua 4
    private TextView counterTextView0, counterTextView1, counterTextView2, counterTextView3, counterTextView4; // Kontagailuen TextView
    private int counterAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resetButton1 = findViewById(R.id.reset1);
        Button resetButton2 = findViewById(R.id.reset2);
        Button resetButton3 = findViewById(R.id.reset3);
        Button resetButton4 = findViewById(R.id.reset4);

        Button resetAllButton = findViewById(R.id.resetAll);

        Button sumButton1 = findViewById(R.id.sum1);
        Button sumButton2 = findViewById(R.id.sum2);
        Button sumButton3 = findViewById(R.id.sum3);
        Button sumButton4 = findViewById(R.id.sum4);

        counterTextView0 = findViewById(R.id.counterAll);
        counterTextView1 = findViewById(R.id.counter1);
        counterTextView2 = findViewById(R.id.counter2);
        counterTextView3 = findViewById(R.id.counter3);
        counterTextView4 = findViewById(R.id.counter4);

        // Botoien klik-ak hasieratu
        sumButton1.setOnClickListener(view -> {
            counter1++;
            update();
        });

        sumButton2.setOnClickListener(view -> {
            counter2++;
            update();
        });

        sumButton3.setOnClickListener(view -> {
            counter3++;
            update();
        });

        sumButton4.setOnClickListener(view -> {
            counter4++;
            update();
        });

        // Berrezartzeko botoien klik-ak hasieratu
        resetButton1.setOnClickListener(view -> {
            counter1 = 0;
            update();
        });

        resetButton2.setOnClickListener(view -> {
            counter2 = 0;
            update();
        });

        resetButton3.setOnClickListener(view -> {
            counter3 = 0;
            update();
        });

        resetButton4.setOnClickListener(view -> {
            counter4 = 0;
            update();
        });

        // Guztien berrezartzeko botoiaren klik-a hasieratu
        resetAllButton.setOnClickListener(view -> {
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            counter4 = 0;
            update();
        });
    }

    // Kontagailuak eguneratu
    private void update() {
        // Kontagailu guztien batura
        int counterAll = counter1 + counter2 + counter3 + counter4;

        counterTextView1.setText(String.valueOf(counter1));
        counterTextView2.setText(String.valueOf(counter2));
        counterTextView3.setText(String.valueOf(counter3));
        counterTextView4.setText(String.valueOf(counter4));

        counterTextView0.setText(String.valueOf(counterAll));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counterAll", counterAll);
        outState.putInt("counter1", counter1);
        outState.putInt("counter2", counter2);
        outState.putInt("counter3", counter3);
        outState.putInt("counter4", counter4);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counterAll = savedInstanceState.getInt("counterAll");
        counter1 = savedInstanceState.getInt("counter1");
        counter2 = savedInstanceState.getInt("counter2");
        counter3 = savedInstanceState.getInt("counter3");
        counter4 = savedInstanceState.getInt("counter4");
        update();
    }

}