
package com.example.lostandfoundpasstask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createNewad,showAllitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNewad = findViewById(R.id.createNewad);
        createNewad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NewAdvertActivity.class);
                startActivity(i);
            }
        });
        showAllitem = findViewById(R.id.showAllitem);
        showAllitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ShowItems.class);
                startActivity(i);
            }
        });
    }
}
