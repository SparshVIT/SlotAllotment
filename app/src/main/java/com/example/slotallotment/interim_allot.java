package com.example.slotallotment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class interim_allot extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interim_allot);
        EditText e1 = findViewById(R.id.e1);
        EditText e2 = findViewById(R.id.e2);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.cl);
        EditText e3 = findViewById(R.id.e3);
        Random random_method = new Random();
        Dbscseinterim d = new Dbscseinterim(this);
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> h = new HashSet<>();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = e1.getText().toString();
                arr.add(s);
                Toast.makeText(interim_allot.this, "Added", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(e2.getText().toString());
                String s2 = e3.getText().toString();
                while(i<=count){
                    int index = random_method.nextInt(arr.size());
                    String s1 = arr.get(index);

                    if(h.add(s1)==true){
                        arr.remove(s1);
                        Boolean checkinsert = d.insertdata(s2, s1);
                        if(checkinsert==true){
                            Toast.makeText(interim_allot.this, "Assigned", Toast.LENGTH_SHORT).show();
                            i++;
                        }
                    }
                }
                h.clear();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = d.getdata();
                if(res.getCount()==0){
                    Toast.makeText(interim_allot.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Semester: "+res.getString(0)+"\n");
                    buffer.append("Faculty: "+res.getString(1)+"\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(interim_allot.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.clear();
            }
        });
    }
}