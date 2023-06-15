package com.example.slotallotment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Viewfac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfac);
        Button b = findViewById(R.id.viewsort);
        Dbhelper2 d = new Dbhelper2(this);
        Dbmaths DB = new Dbmaths(this);
        Button b1 = findViewById(R.id.viewsortsasl);
        Button b2 = findViewById(R.id.update_scse);
        Button b3 = findViewById(R.id.update_mat);
        Button b4 = findViewById(R.id.update_eee);
        Button b5 = findViewById(R.id.s1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = d.getsortdata();
                if(res.getCount()==0){
                    Toast.makeText(Viewfac.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ClassNo: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Viewfac.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getsortdata();
                if(res.getCount()==0){
                    Toast.makeText(Viewfac.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Viewfac.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), update_scse.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), updatemaths.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),update_interim_fall_seee.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = d.getsortdatabyslot();
                if(res.getCount()==0){
                    Toast.makeText(Viewfac.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Viewfac.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}