package com.example.firebasedatabaseandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        editText3 = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button);

        databaseReference = FirebaseDatabase.getInstance().getReference("details");
        
        /* FirebaseDatabase is a class and when we call the getInstance() method on it, this method fetches the object of the Firebase database. On this object 
          of Firebase database when we call the getReference() method it gets the reference or memory address of the child location named "details" inside the Firebase
          Database. If such a child location does not already exist then it creates such a child location by the name "details" inside the firebase database and returns
          its reference or memory address*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addData();
            }
        });
    }

    public void addData() {

        //fetch data from all 3 edit texts 

        String name = editText1.getText().toString().trim();
        String game = editText2.getText().toString().trim();
        String country = editText3.getText().toString().trim();

        //validate that no edit text has been left empty by user

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(game) && !TextUtils.isEmpty(country)) {
            String id = databaseReference.push().getKey();
            Player player = new Player(name, game, country, id);
            databaseReference.child(id).setValue(player);

            //remove data entered by user from the 3 edit texts
            editText1.setText("");
            editText2.setText("");
            editText3.setText("");

            Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Please do not leave any field empty !! ", Toast.LENGTH_SHORT).show();
        }


    }
}