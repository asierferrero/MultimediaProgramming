package eus.asier.secondactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        final EditText editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(view -> {
            String message2 = editText2.getText().toString();

            Intent intent2 = new Intent(this, SecondActivityV2.class);
            intent2.putExtra("reply", message2);

            startActivity(intent2);
        });
    }
}

