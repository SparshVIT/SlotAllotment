package com.example.slotallotment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SCSE_interim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scse_interim);
        ArrayList<String> morning = new ArrayList<>();
        morning.add("A11+D11+A12+D12+A13+D13");
        morning.add("B11+E11+B12+E12+B13+E13");
        morning.add("C11+F11+C12+F12+C13+F13");
        //morning.add("A21+D21+A22+D22+A23+D23");
        ArrayList<String> evening = new ArrayList<>();
        evening.add("A21+D21+A22+D22+A23+D23");
        //evening.add("C11+F11+C12+F12+C13+F13");
        evening.add("B21+F21+B22+F22+B23+E13");
        evening.add("C21+E21+C22+E22+C23+E23");
        HashMap<String,Integer> h = new HashMap<>();
        EditText e = findViewById(R.id.teachers);
        EditText e1 = findViewById(R.id.subject);
        EditText e2 = findViewById(R.id.credit);
        CheckBox c1,c2,c3;
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);

        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Data Structure and Algorithm");
        subjects.add("Computer Architecture and Organisation");
        subjects.add("Operating System");
        subjects.add("Software Engineering");
        subjects.add("Introduction to Problem Solving and Programming");
        subjects.add("Fundamental of AI & ML");
        Button b1 = findViewById(R.id.a);
        Button b2 = findViewById(R.id.allot);
        Button b4 = findViewById(R.id.clear);
        Button b3 = findViewById(R.id.view);
        EditText sl = findViewById(R.id.slot);
        CheckBox r1 = findViewById(R.id.r1);
        CheckBox r2 = findViewById(R.id.r2);
        EditText cnint = findViewById(R.id.cnint);
        HashMap<String, ArrayList<String>> f = new HashMap<>();
        Random random_method = new Random();
        ArrayList<String> morningfac = new ArrayList<>();
        ArrayList<String> eveningfac = new ArrayList<>();
        Dbint db = new Dbint(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked()){
                    String s = e.getText().toString();
                    morningfac.add(s);
                    if(h.containsKey(s)==false){
                        h.put(s,3);
                        Toast.makeText(SCSE_interim.this, "added", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(c2.isChecked()){
                    String s = e.getText().toString();
                    eveningfac.add(s);
                    if(h.containsKey(s)==false){
                        h.put(s,3);
                        Toast.makeText(SCSE_interim.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    int index1 = random_method.nextInt(morning.size());
                    int index2 = random_method.nextInt(morningfac.size());
                    String slot = morning.get(index1);
                    String facname = morningfac.get(index2);
                    String subject = e1.getText().toString();
                    if (h.get(facname) > 0) {
                        if (f.containsKey(facname) == false) {
                            ArrayList<String> a = new ArrayList<>();
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,18);
                            }
                            String checkstring = slot.substring(0,2);
                            a.add(checkstring);
                            f.put(facname, a);
                            String c = cnint.getText().toString();
                            Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                            if (checkinsert) {
                                h.put(facname, h.get(facname) - 2);
                                Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,18);
                            }
                            String checkstring = slot.substring(0,2);
                            boolean t = f.get(facname).contains(checkstring);
                            if (t == false) {
                                if(checkstring.equals("A2")){
                                    int t1 = f.get(facname).indexOf("C1");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cnint.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 2);
                                            Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if(checkstring.equals("C1")){
                                    int t1 = f.get(facname).indexOf("A2");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cnint.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 2);
                                            Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    f.get(facname).add(checkstring);
                                    String c = cnint.getText().toString();
                                    Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 2);
                                        Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                } else if (r2.isChecked()) {
                    int index1 = random_method.nextInt(evening.size());
                    int index2 = random_method.nextInt(eveningfac.size());
                    String slot = evening.get(index1);
                    String facname = eveningfac.get(index2);
                    String subject = e1.getText().toString();
                    if (h.get(facname) > 0) {
                        if (f.containsKey(facname) == false) {
                            ArrayList<String> a = new ArrayList<>();
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,18);
                            }
                            String checkstring = slot.substring(0,2);
                            a.add(checkstring);
                            f.put(facname, a);
                            String c = cnint.getText().toString();
                            Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                            if (checkinsert) {
                                h.put(facname, h.get(facname) - 2);
                                Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,18);
                            }
                            String checkstring = slot.substring(0,2);
                            boolean t = f.get(facname).contains(checkstring);
                            if (t == false) {
                                if(checkstring.equals("A2")){
                                    int t1 = f.get(facname).indexOf("C1");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cnint.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 2);
                                            Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if(checkstring.equals("C1")){
                                    int t1 = f.get(facname).indexOf("A2");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cnint.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 2);
                                            Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    f.get(facname).add(checkstring);
                                    String c = cnint.getText().toString();
                                    Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 2);
                                        Toast.makeText(SCSE_interim.this, "Good to go", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(SCSE_interim.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(SCSE_interim.this);
                builder.setCancelable(true);
                builder.setTitle("Choice");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.clear();
            }
        });

    }
}