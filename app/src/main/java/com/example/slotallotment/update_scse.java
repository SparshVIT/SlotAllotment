package com.example.slotallotment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_scse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_scse);
        EditText e1,e2,e3,e4;
        e1 = findViewById(R.id.slot);
        e2 = findViewById(R.id.nf);
        e3 = findViewById(R.id.of);
        e4 = findViewById(R.id.subject);
        Dbhelper2 d = new Dbhelper2(this);
        Button b1 = findViewById(R.id.update);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.updateData(e3.getText().toString());
                Toast.makeText(update_scse.this, "Record Deleated", Toast.LENGTH_SHORT).show();

            }
        });
    }
}