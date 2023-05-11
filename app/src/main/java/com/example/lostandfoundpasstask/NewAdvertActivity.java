
package com.example.lostandfoundpasstask;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lostandfoundpasstask.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class NewAdvertActivity extends AppCompatActivity {
    EditText NameItem,PhoneItem,DescItem,DateItem,LocationItem;
    Button SaveItem;
    MaterialRadioButton na_Lost,na_Found;
    Database Database;
    String checkedStatus = "",item_name,item_phone,item_desc,item_date,item_location;
    @SuppressLint("WrongViewCast")
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



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        if (view.getId() == R.id.na_Lost) {
            if (checked)
                checkedStatus = "lost";
        } else if (view.getId() == R.id.na_Found) {
            if (checked)
                checkedStatus = "found";
        }

    }


}