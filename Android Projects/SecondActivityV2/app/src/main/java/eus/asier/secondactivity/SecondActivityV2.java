package eus.asier.secondactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class SecondActivityV2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondv2);

        Intent intent2 = getIntent();
        String message2 = intent2.getStringExtra("reply");

        TextView textView = findViewById(R.id.textView3);
        textView.setText(message2);
    }
}
