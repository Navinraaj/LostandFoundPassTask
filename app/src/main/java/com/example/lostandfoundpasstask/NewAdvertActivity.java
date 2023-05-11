
package com.example.lostandfoundpasstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NewAdvertActivity extends AppCompatActivity {
    EditText NameItem,PhoneItem,DescItem,DateItem,LocationItem;
    Button SaveItem;
    CheckBox na_Lost,na_Found;
    Database Database;
    String checkedStatus = "",item_name,item_phone,item_desc,item_date,item_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);
        NameItem = findViewById(R.id.NameItem);
        PhoneItem = findViewById(R.id.PhoneItem);
        DescItem = findViewById(R.id.DescItem);
        DateItem = findViewById(R.id.DateItem);
        LocationItem = findViewById(R.id.LocationItem);
        SaveItem = findViewById(R.id.SaveItem);
        na_Lost = findViewById(R.id.na_Lost);
        na_Found = findViewById(R.id.na_Found);
        Database = new Database(this);
        SaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item_name = NameItem.getText().toString();
                item_location = LocationItem.getText().toString();
                item_date = DateItem.getText().toString();
                item_desc = DescItem.getText().toString();
                item_phone = PhoneItem.getText().toString();
                Item i = new Item();
                i.setDate(item_date);
                i.setDescription(item_desc);
                i.setLocation(item_location);
                i.setName(item_name);
                i.setPhone(item_phone);
                i.setLost(checkedStatus);
                Database.addItem(i);
                finish();
            }
        });

    }


    public void onCheckBoxClicked(View v){
        Boolean checked =((CheckBox) v).isChecked();

        if(v.getId() == R.id.na_Lost){
            if (checked){
                checkedStatus="lost";
                ((CheckBox)findViewById(R.id.na_Found)).setChecked(false);
            }
        } else if(v.getId() == R.id.na_Found) {
            if (checked){
                checkedStatus="found";
                ((CheckBox)findViewById(R.id.na_Lost)).setChecked(false);
            }
        }
    }


}