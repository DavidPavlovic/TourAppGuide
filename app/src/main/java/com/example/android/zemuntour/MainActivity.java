package com.example.android.zemuntour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.start_btn);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tabCat = new Intent(MainActivity.this, TabCategory.class);
                startActivity(tabCat);
            }
        });
    }
}
