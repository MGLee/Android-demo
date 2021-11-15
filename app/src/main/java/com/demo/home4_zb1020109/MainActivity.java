package com.demo.home4_zb1020109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
    }

    public void start(View view) {
        button.setBackgroundColor(Color.rgb(0,220,120));
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void end(View view) {
        button2.setBackgroundColor(Color.rgb(120,210,230));
        finish();
    }
}