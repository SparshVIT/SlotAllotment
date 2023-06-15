package com.example.slotallotment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updatemaths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemaths);
        EditText e = findViewById(R.id.cnm);
        Button b1 = findViewById(R.id.b1);
        Dbmaths db = new Dbmaths(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = e.getText().toString();
                db.updateData(s);
                Toast.makeText(updatemaths.this, "Record deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}