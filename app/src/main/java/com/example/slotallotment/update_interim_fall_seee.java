package com.example.slotallotment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_interim_fall_seee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_interim_fall_seee);
        EditText e1 = findViewById(R.id.e1);
        EditText e2 = findViewById(R.id.e2);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Dbelectrical d = new Dbelectrical(this);
        Dbint d1 = new Dbint(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                d1.updateData(s1);
                Toast.makeText(update_interim_fall_seee.this, "Record Deleated", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2 = e2.getText().toString();
                d.updateData(s2);
                Toast.makeText(update_interim_fall_seee.this, "Record Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = d1.getdata();
                if(res.getCount()==0){
                    Toast.makeText(update_interim_fall_seee.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(update_interim_fall_seee.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = d.getdata();
                if(res.getCount()==0){
                    Toast.makeText(update_interim_fall_seee.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(update_interim_fall_seee.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}