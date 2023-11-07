package com.example.test1_coding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class FunkoPopActivity extends AppCompatActivity {
    EditText name, number, type, fandom, ultimate, price;
    TextView headline;
    Button saveButton;
    Switch aSwitch;

    View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nameStr = name.getText().toString();
            Integer numberInt = Integer.parseInt(number.getText().toString());
            String typeStr = type.getText().toString();
            String fandomStr = fandom.getText().toString();
            String ultimateStr = ultimate.getText().toString();
            Double priceD = Double.parseDouble(price.getText().toString());
            boolean switchResult = aSwitch.isChecked();


            ContentValues values = new ContentValues();
            values.put(MyContentProvider.COLUMN1_NAME, nameStr);
            values.put(MyContentProvider.COLUMN2_NAME, numberInt);
            values.put(MyContentProvider.COLUMN3_NAME, typeStr);
            values.put(MyContentProvider.COLUMN4_NAME, fandomStr);
            values.put(MyContentProvider.COLUMN5_NAME, switchResult);
            values.put(MyContentProvider.COLUMN6_NAME, ultimateStr);
            values.put(MyContentProvider.COLUMN7_NAME, priceD);

            Uri uri = getContentResolver().insert(MyContentProvider.contentURI, values);;

            if (uri != null) {
                // Successfully added the figure
                Toast.makeText(FunkoPopActivity.this, "FunkoPop figure added", Toast.LENGTH_SHORT).show();
            } else {
                // Failed to add the figure
                Toast.makeText(FunkoPopActivity.this, "Failed to add FunkoPop figure", Toast.LENGTH_SHORT).show();
            }

            Intent intent = new Intent(FunkoPopActivity.this, MainActivity.class );
            Bundle bundle = new Bundle();
            bundle.putString("name", nameStr);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_figure);

        name = findViewById(R.id.name_et);
        number = findViewById(R.id.numberEt_id);
        type = findViewById(R.id.typeEt_id);
        fandom = findViewById(R.id.fandomEt_id);
        ultimate = findViewById(R.id.ultimateEt_id);
        price = findViewById(R.id.priceEt_tv);
        saveButton = findViewById(R.id.button);
        headline = findViewById(R.id.headline2_id);
        aSwitch = findViewById(R.id.onSwitch_id);

        saveButton.setOnClickListener(saveListener);


    }
}