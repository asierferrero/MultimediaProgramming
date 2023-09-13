package eus.asier.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter;
    Button incrementButton;
    TextView counterTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //This call sets the layout to activity_main.xml

        incrementButton = findViewById(R.id.increaseCounterBtn);
        counterTextView = findViewById(R.id.couterClicksText);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // increase the counter
                // set the counter into the TextView
                counter++;
                counterTextView.setText("You have clicked " + counter + " times");
            }
        });
    }
}