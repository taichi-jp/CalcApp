package taichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import android.widget.Toast;

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
        String editText1Str = editText1.getText().toString();
        String editText2Str = editText2.getText().toString();
        if (TextUtils.isEmpty(editText1Str) || TextUtils.isEmpty(editText2Str)) { return; }

        List<String> invalidList = new ArrayList<>(Arrays.asList("-", "."));
        if (invalidList.contains(editText1Str) || invalidList.contains(editText2Str)) {
            Toast.makeText(this, "不正な値です", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Integer.valueOf(editText2Str) == 0) {
            Toast.makeText(this, "0で割り算はできません", Toast.LENGTH_SHORT).show();
            return;
        }
//        API Level 24以上
//        if (Arrays.asList(editText1Str, editText2Str).stream().anyMatch(str -> str == "+" || str == "-")) {
//            Toast.makeText(this, "不正な値です", Toast.LENGTH_SHORT).show();
//        }
        Float val1 = Float.valueOf(editText1Str);
        Float val2 = Float.valueOf(editText2Str);

        Intent intent = new Intent(this, ResultActivity.class);
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
