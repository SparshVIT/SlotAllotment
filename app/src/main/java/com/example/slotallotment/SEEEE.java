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

public class SEEEE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeee);
        ArrayList<String> morning = new ArrayList<>();
        morning.add("A11+A12+A13");
        morning.add("B11+B12+B13");
        morning.add("D11+D12+D13");
        morning.add("E11+E12+E13");
        morning.add("A21+A22+A23");
        morning.add("C11+C12+C13");
        ArrayList<String> evening = new ArrayList<>();
        evening.add("F11+F12+F13");
        evening.add("D21+D22+D23");
        evening.add("B21+B22+B23");
        evening.add("E21+E22+E23");
        evening.add("C21+C22+C23");
        evening.add("A21+A22+A23");
        HashMap<String,Integer> h = new HashMap<>();
        EditText e = findViewById(R.id.teachers);
        EditText e1 = findViewById(R.id.subject);
        EditText e2 = findViewById(R.id.credit);
        EditText sl = findViewById(R.id.slot);
        EditText d = findViewById(R.id.duty);
        EditText cn = findViewById(R.id.classno);
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
        Button b5 = findViewById(R.id.update);
        CheckBox r1 = findViewById(R.id.r1);
        CheckBox r2 = findViewById(R.id.r2);
        HashMap<String, ArrayList<String>> f = new HashMap<>();
        Random random_method = new Random();
        ArrayList<String> morningfac = new ArrayList<>();
        ArrayList<String> eveningfac = new ArrayList<>();
        Dbelectrical db = new Dbelectrical(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked()){
                    String s = e.getText().toString();
                    int classes = Integer.parseInt(d.getText().toString());
                    morningfac.add(s);
                    if(h.containsKey(s)==false){
                        h.put(s,classes);
                        Toast.makeText(SEEEE.this, "added", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(c2.isChecked()){
                    String s = e.getText().toString();
                    int classes = Integer.parseInt(d.getText().toString());
                    eveningfac.add(s);
                    if(h.containsKey(s)==false){
                        h.put(s,classes);
                        Toast.makeText(SEEEE.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = e.getText().toString();
                int classes = Integer.parseInt(d.getText().toString());
                if(h.containsKey(s)){
                    h.put(s,h.get(s)+classes);
                    Toast.makeText(SEEEE.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    h.put(s,classes);
                    Toast.makeText(SEEEE.this, "No faculty found with this name", Toast.LENGTH_SHORT).show();
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
                                slot = slot.substring(0,7);
                            }
                            String checkstring = slot.substring(0,2);
                            a.add(checkstring);
                            f.put(facname, a);
                            String c = cn.getText().toString();
                            Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                            if (checkinsert) {
                                h.put(facname, h.get(facname) - 1);
                                Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,7);
                            }
                            String checkstring = slot.substring(0,2);
                            boolean t = f.get(facname).contains(checkstring);
                            if (t == false) {
                                if(checkstring.equals("A2")){
                                    int t1 = f.get(facname).indexOf("C1");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cn.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 1);
                                            Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if(checkstring.equals("C1")){
                                    int t1 = f.get(facname).indexOf("A2");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cn.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 1);
                                            Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    f.get(facname).add(checkstring);
                                    String c = cn.getText().toString();
                                    Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 1);
                                        Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
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
                                slot = slot.substring(0,7);
                            }
                            String checkstring = slot.substring(0,2);
                            a.add(checkstring);
                            f.put(facname, a);
                            String c = cn.getText().toString();
                            Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                            if (checkinsert) {
                                h.put(facname, h.get(facname) - 1);
                                Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            String s = e2.getText().toString();
                            int credit = Integer.parseInt(s);
                            if(credit==3){
                                slot = slot.substring(0,7);
                            }
                            String checkstring = slot.substring(0,2);
                            boolean t = f.get(facname).contains(checkstring);
                            if (t == false) {
                                if(checkstring.equals("F1")){
                                    int t1 = f.get(facname).indexOf("D2");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cn.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 1);
                                            Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else if(checkstring.equals("D2")){
                                    int t1 = f.get(facname).indexOf("F1");
                                    if(t1<0){
                                        f.get(facname).add(checkstring);
                                        String c = cn.getText().toString();
                                        Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                        if (checkinsert) {
                                            h.put(facname, h.get(facname) - 1);
                                            Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else{
                                    f.get(facname).add(checkstring);
                                    String c = cn.getText().toString();
                                    Boolean checkinsert = db.insertdata(c,slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 1);
                                        Toast.makeText(SEEEE.this, "Good to go", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(SEEEE.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(SEEEE.this);
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