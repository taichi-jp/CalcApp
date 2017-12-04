package taichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);

        Button buttonTimes = findViewById(R.id.buttonTimes);
        buttonTimes.setOnClickListener(this);

        Button buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        Float val1 = Float.valueOf(editText1.getText().toString());
        Float val2 = Float.valueOf(editText2.getText().toString());
        if (v.getId() == R.id.buttonPlus) {
            intent.putExtra("VALUE", val1 + val2);
        } else if (v.getId() == R.id.buttonMinus) {
            intent.putExtra("VALUE", val1 - val2);
        } else if (v.getId() == R.id.buttonTimes) {
            intent.putExtra("VALUE", val1 * val2);
        } else if (v.getId() == R.id.buttonDiv) {
            intent.putExtra("VALUE", val1 / val2);
        } else {
            Log.d("UI_PARTS", "エラー！");
        }
        startActivity(intent);
    }
}
