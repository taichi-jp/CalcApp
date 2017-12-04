package taichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Float value = intent.getFloatExtra("VALUE", 0);

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(value));
    }
}
