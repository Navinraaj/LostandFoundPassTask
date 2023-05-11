
package com.example.lostandfoundpasstask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lostandfoundpasstask.Database;
import com.example.lostandfoundpasstask.Item;

public class ItemDetails extends AppCompatActivity {
    TextView NameofItem,Phoneofitem,Descofitem,Locationofitem,Dateofitem;
    int id;
    Database Database;
    Item item;
    Button btnDeleteitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        NameofItem = findViewById(R.id.NameofItem);
        Dateofitem = findViewById(R.id.Dateofitem);
        Descofitem = findViewById(R.id.Descofitem);
        Locationofitem = findViewById(R.id.Locationofitem);
        Phoneofitem = findViewById(R.id.Phoneofitem);

        Intent i = getIntent();
        id = i.getIntExtra("item id",0);

        Database = new Database(this);
        item = Database.fetchItem(id);

        NameofItem.setText(item.getName());
        Phoneofitem.setText(item.getPhone());
        Descofitem.setText(item.getDescription());
        Dateofitem.setText(item.getDate());
        Locationofitem.setText(item.getLocation());

        btnDeleteitem = findViewById(R.id.btnDeleteitem);
        btnDeleteitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.deleteItem(id);
                Intent i = new Intent(getApplicationContext(),ShowItems.class);
                startActivity(i);
                finish();
            }
        });

    }
}