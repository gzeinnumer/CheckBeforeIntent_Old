package com.gzeinnumer.checkbeforeintent_old;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.ed1);
        editText2 = findViewById(R.id.ed2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            if (check()) //true -> free to lease
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            else { //false -> not free to leave
                Toast.makeText(MainActivity.this, "Are you sure leave the activity", Toast.LENGTH_SHORT).show();
                //show confirm dialod and move to new activity if user choise YES
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private boolean check() {
        if (editText1.getText().toString().length()>0 || editText2.getText().toString().length()>0){
            return false;
        }
        else return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (check()) //true -> free to lease
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        else { //false -> not free to leave
            Toast.makeText(MainActivity.this, "Are you sure leave the activity", Toast.LENGTH_SHORT).show();
            //show confirm dialod and move to new activity if user choise YES
            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}