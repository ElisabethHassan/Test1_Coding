package com.example.test1_coding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView headline;
    ListView listview;
    Button addButton;

    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, FunkoPopActivity.class);
            startActivity(intent);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funko_pop);

        listview = findViewById(R.id.listview_id);
        addButton = findViewById(R.id.button2);
        headline = findViewById(R.id.headline3_id);

        addButton.setOnClickListener(addListener);


    }
}