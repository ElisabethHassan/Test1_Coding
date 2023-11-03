package com.example.test1_coding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText searchName, searchNumber;
    TextView headline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentValues newValues = new ContentValues();
        if(!newValues.containsKey(searchName.getText().toString()))  {
            newValues.put(MyContentProvider.COLUMN1_NAME, searchName.getText().toString() );
        } else Toast.makeText(getApplicationContext(), "This Funko Pop exits in our database!", Toast.LENGTH_SHORT).show();
        if(!newValues.containsKey(searchNumber.getText().toString())) {
            newValues.put(MyContentProvider.COLUMN2_NAME, searchNumber.getText().toString() );
        } else Toast.makeText(getApplicationContext(), "This Funko Pop exits in our database!", Toast.LENGTH_SHORT).show();

        //inserts data into the database through content URI
        getContentResolver().insert(MyContentProvider.contentURI, newValues);


    }
}