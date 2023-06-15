package com.example.slotallotment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SCSE extends AppCompatActivity {
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scse);
        ArrayList<String> morning = new ArrayList<>();
        morning.add("A11+A12+A13");
        morning.add("B11+B12+B13");
        morning.add("D11+D12+D13");
        morning.add("E11+E12+E13");
        morning.add("A21+A22+A23");
        morning.add("C11+C12+C13");
        ArrayList<String> evening = new ArrayList<>();
        evening.add("C11+C12+C13");
        evening.add("D21+D22+D23");
        evening.add("B21+B22+B23");
        evening.add("E21+E22+E23");
        evening.add("C21+C22+C23");
        evening.add("A21+A22+A23");
        evening.add("F11+F12+F13");
        ArrayList<String> AfterNoon = new ArrayList<>();
        AfterNoon.add("B11+B12+B13");
        AfterNoon.add("E11+E12+E13");
        AfterNoon.add("F11+F12+F13");
        AfterNoon.add("A21+A22+A23");
        AfterNoon.add("B21+B22+B23");
        AfterNoon.add("C11+C12+C13");
        ArrayList<String> morning_interim = new ArrayList<>();
        ArrayList<String> evening_interim = new ArrayList<>();
        morning_interim.add("A11+A12+A13+A14+A15+A17");
        //morning_interim.add("B11+E11+B12+E12+B13+E13");
        morning_interim.add("C11+C12+C13+C14+C15+C17");
        //morning_interim.add("A21+D21+A22+D22+A23+C23");
        //morning_interim.add("F11+F12+F13+F14+F15+F16");

        //morning_interim.add("B11+B21+B12+B22+B13+B23");
        ArrayList<String> noon_interim = new ArrayList<>();
        noon_interim.add("B11+B12+B13+B14+B15+B17");
        //noon_interim.add("C11+F11+C12+F12+C13+F13");
        //noon_interim.add("A21+D21+A22+D22+A23+C23");
        noon_interim.add("C21+C22+C23+C24+C25+C27");
        //evening_interim.add("C11+F11+C12+F12+C13+F13");
        evening_interim.add("A21+A22+A23+A24+A25+A27");
        //evening_interim.add("B21+E21+B22+E22+B23+E23");
        evening_interim.add("D21+D22+D23+D24+D25+A17");
        //evening_interim.add("F11+F12+F13+F14+F15+F16");
        HashMap<String,Integer> lim = new HashMap<>();
        lim.put("A1",0);
        lim.put("B1",0);
        lim.put("C1",0);
        lim.put("D1",0);
        lim.put("E1",0);
        lim.put("F1",0);
        lim.put("A2",0);
        lim.put("D2",0);
        lim.put("B2",0);
        lim.put("E2",0);
        lim.put("C2",0);
        lim.put("F2",0);
        HashMap<String,String> intSlot = new HashMap<>();
        intSlot.put("A14","D1");
        intSlot.put("B14","E1");
        intSlot.put("C14","F1");
        intSlot.put("A24","D2");
        intSlot.put("C21","B2");
        intSlot.put("C24","E2");
        intSlot.put("D21","C2");
        intSlot.put("D24","F2");
        HashMap<String,Integer> h = new HashMap<>();
        HashMap<String,Integer> classes = new HashMap<>();
        EditText e = findViewById(R.id.teachers);
        EditText e1 = findViewById(R.id.subject);
        EditText e2 = findViewById(R.id.credit);
        EditText d = findViewById(R.id.duty);
        EditText cn = findViewById(R.id.cn);
        EditText count = findViewById(R.id.number);
        CheckBox c1,c2,c3;
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);

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
        Button b5 = findViewById(R.id.interim);
        Button b6 = findViewById(R.id.update);
        CheckBox r1 = findViewById(R.id.r1);
        CheckBox r2 = findViewById(R.id.r2);
        CheckBox r3 = findViewById(R.id.r3);
        HashMap<String, ArrayList<String>> f = new HashMap<>();
        Random random_method = new Random();
        ArrayList<String> morningfac = new ArrayList<>();
        ArrayList<String> eveningfac = new ArrayList<>();
        ArrayList<String> noonfac = new ArrayList<>();
        Dbhelper2 db = new Dbhelper2(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked()){
                    String s = e.getText().toString();
                    int classes = Integer.parseInt(d.getText().toString());
                    morningfac.add(s);
                    if(h.containsKey(s)==false){
                        h.put(s,classes);
                        Toast.makeText(SCSE.this, "added", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(c2.isChecked()){
                    String s = e.getText().toString();
                    noonfac.add(s);
                    int classes = Integer.parseInt(d.getText().toString());
                    if(h.containsKey(s)==false){
                        h.put(s,classes);
                        Toast.makeText(SCSE.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(c3.isChecked()){
                    String s = e.getText().toString();
                    eveningfac.add(s);
                    int classes = Integer.parseInt(d.getText().toString());
                    if(h.containsKey(s)==false){
                        h.put(s,classes);
                        Toast.makeText(SCSE.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int classes = Integer.parseInt(d.getText().toString());
                String s = e.getText().toString();
                if(h.containsKey(s)){
                    h.put(s,h.get(s)+classes);
                    Toast.makeText(SCSE.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    h.put(s,classes);
                    Toast.makeText(SCSE.this, "New Faculty Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
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
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                a.add(checkstring);
                                classes.put(facname, number_class);
                                f.put(facname, a);
                                id++;
                                String num = cn.getText().toString()+String.valueOf(i);
                                if(lim.get(checkstring)<50){
                                    Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 1);
                                        Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        lim.put(checkstring,lim.get(checkstring)+1);
                                        i++;
                                    }
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                boolean t = f.get(facname).contains(checkstring);
                                if (t == false) {
                                    if (checkstring.equals("A2")) {
                                        int t1 = f.get(facname).indexOf("C1");
                                        if (t1 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("C1")) {
                                        int t1 = f.get(facname).indexOf("A2");
                                        int t2 = f.get(facname).indexOf("B1");
                                        if (t1 < 0 && t2 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("A1")) {
                                        int t1 = f.get(facname).indexOf("B1");
                                        if (t1 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("B1")) {
                                        int t1 = f.get(facname).indexOf("A1");
                                        int t2 = f.get(facname).indexOf("C1");
                                        if (t1 < 0 && t2 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("D1")) {
                                        int t1 = f.get(facname).indexOf("E1");
                                        int t2 = f.get(facname).indexOf("A14");
                                        int t3 = f.get(facname).indexOf("B14");
                                        if (t1 < 0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("E1")) {
                                        int t1 = f.get(facname).indexOf("D1");
                                        int t2 = f.get(facname).indexOf("F1");
                                        int t3 = f.get(facname).indexOf("B14");
                                        int t4 = f.get(facname).indexOf("A14");
                                        int t5 = f.get(facname).indexOf("C14");
                                        if (t1 < 0 && t2 < 0 && t3<0 && t4<0 && t5<0){
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else {
                                        f.get(facname).add(checkstring);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);
                                        classes.put(facname, classes.get(facname) + number_class);
                                        if(lim.get(checkstring)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 1);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (r3.isChecked()) {
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
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
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                a.add(checkstring);
                                classes.put(facname, number_class);
                                f.put(facname, a);
                                id++;
                                String num = cn.getText().toString()+String.valueOf(i);
                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                if (checkinsert) {
                                    h.put(facname, h.get(facname) - 1);
                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                    i++;
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                boolean t = f.get(facname).contains(checkstring);
                                if (t == false) {
                                    if (checkstring.equals("F1")) {
                                        int t1 = f.get(facname).indexOf("D2");
                                        int t2 = f.get(facname).indexOf("C14");
                                        int t3 = f.get(facname).indexOf("A24");
                                        if (t1 < 0 && t2<0 && t3<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    } else if (checkstring.equals("D2")) {
                                        int t1 = f.get(facname).indexOf("F1");
                                        int t2 = f.get(facname).indexOf("A24");
                                        int t3 = f.get(facname).indexOf("C14");
                                        if (t1 < 0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("B2")) {
                                        int t1 = f.get(facname).indexOf("C2");
                                        int t2 = f.get(facname).indexOf("D24");
                                        int t3  = f.get(facname).indexOf("A24");
                                        if (t1 < 0 && t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("E2")) {
                                        int t1 = f.get(facname).indexOf("C24");
                                        int t2 = f.get(facname).indexOf("D24");
                                        if (t1<0 && t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("C2")) {
                                        int t1 = f.get(facname).indexOf("B2");
                                        int t2 = f.get(facname).indexOf("D24");
                                        if (t1 < 0 && t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("A2")) {
                                        int t2 = f.get(facname).indexOf("C1");
                                        if (t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("C1")) {
                                        int t2 = f.get(facname).indexOf("A2");
                                        if (t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            classes.put(facname, classes.get(facname) + number_class);
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        f.get(facname).add(checkstring);
                                        classes.put(facname, classes.get(facname) + number_class);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);
                                        if(lim.get(checkstring)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 1);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (r2.isChecked()) {
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
                        int index1 = random_method.nextInt(AfterNoon.size());
                        int index2 = random_method.nextInt(noonfac.size());
                        String slot = AfterNoon.get(index1);
                        String facname = noonfac.get(index2);
                        String subject = e1.getText().toString();
                        if (h.get(facname) > 0) {
                            if (f.containsKey(facname) == false) {
                                ArrayList<String> a = new ArrayList<>();
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                a.add(checkstring);
                                classes.put(facname, number_class);
                                f.put(facname, a);
                                id++;
                                String num = cn.getText().toString()+String.valueOf(i);
                                if(lim.get(checkstring)<50){
                                    Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 1);
                                        Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        lim.put(checkstring,lim.get(checkstring)+1);
                                        i++;
                                    }
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 3;
                                if (credit == 3) {
                                    slot = slot.substring(0, 7);
                                    number_class = 2;
                                }
                                String checkstring = slot.substring(0, 2);
                                boolean t = f.get(facname).contains(checkstring);
                                if (t == false) {
                                    if (checkstring.equals("A2")) {
                                        int t1 = f.get(facname).indexOf("C1");
                                        if (t1 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("C1")) {
                                        int t1 = f.get(facname).indexOf("A2");
                                        int t2 = f.get(facname).indexOf("B1");
                                        if (t1 < 0 && t2 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("B1")) {
                                        int t1 = f.get(facname).indexOf("A1");
                                        int t2 = f.get(facname).indexOf("C1");
                                        if (t1 < 0 && t2 < 0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("E1")) {
                                        int t1 = f.get(facname).indexOf("D1");
                                        int t2 = f.get(facname).indexOf("F1");
                                        int t3 = f.get(facname).indexOf("B14");
                                        int t4 = f.get(facname).indexOf("C14");
                                        int t5 = f.get(facname).indexOf("A14");
                                        if (t1 < 0 && t2 < 0 && t3<0 && t4<0 && t5<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("F1")) {
                                        int t1 = f.get(facname).indexOf("E1");
                                        int t2 = f.get(facname).indexOf("C14");
                                        int t3 = f.get(facname).indexOf("B14");
                                        if (t1 < 0 && t2<0 && t3<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if (checkstring.equals("B2")) {
                                        int t1 = f.get(facname).indexOf("C2");
                                        int t2 = f.get(facname).indexOf("A24");
                                        if (t1 < 0 && t2<0) {
                                            f.get(facname).add(checkstring);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            classes.put(facname, classes.get(facname) + number_class);
                                            if(lim.get(checkstring)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 1);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        f.get(facname).add(checkstring);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);

                                        classes.put(facname, classes.get(facname) + number_class);
                                        if(lim.get(checkstring)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 1);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
                        int index1 = random_method.nextInt(morning_interim.size());
                        int index2 = random_method.nextInt(morningfac.size());
                        String slot = morning_interim.get(index1);
                        String facname = morningfac.get(index2);
                        String subject = e1.getText().toString();
                        if (h.get(facname) > 1) {
                            if (f.containsKey(facname) == false) {
                                ArrayList<String> a = new ArrayList<>();
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class = 5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                a.add(checkstring);
                                a.add(check2);
                                classes.put(facname,number_class);
                                f.put(facname, a);
                                id++;
                                String num = cn.getText().toString()+String.valueOf(i);
                                String c2 = intSlot.get(check2);
                                if(checkstring.equals("C2")){
                                    checkstring = "B2";
                                }
                                else if(checkstring.equals("D2")){
                                    checkstring = "C2";
                                }
                                if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                    Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 2);
                                        Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        lim.put(checkstring,lim.get(checkstring)+1);
                                        lim.put(c2,lim.get(c2)+1);
                                        i++;
                                    }
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class=5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                boolean t = f.get(facname).contains(checkstring);
                                boolean d = f.get(facname).contains(check2);
                                if (t == false && d==false) {
                                    if(checkstring.equals("A2")){
                                        int t1 = f.get(facname).indexOf("C1");
                                        int t2 = f.get(facname).indexOf("F1");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(check2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("C1")){
                                        int t1 = f.get(facname).indexOf("A2");
                                        int t2 = f.get(facname).indexOf("D2");
                                        int t3 = f.get(facname).indexOf("B1");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("B1")){
                                        int t1 = f.get(facname).indexOf("A1");
                                        int t2 = f.get(facname).indexOf("C1");
                                        int t3 = f.get(facname).indexOf("E1");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("A1")){
                                        int t1 = f.get(facname).indexOf("B1");
                                        int t2 = f.get(facname).indexOf("E1");
                                        if(t1<0 && t2<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        f.get(facname).add(checkstring);
                                        f.get(facname).add(check2);
                                        classes.put(facname,classes.get(facname)+number_class);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);
                                        String c2 = intSlot.get(check2);
                                        if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 2);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                lim.put(c2,lim.get(c2)+1);
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (r3.isChecked()) {
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
                        int index1 = random_method.nextInt(evening_interim.size());
                        int index2 = random_method.nextInt(eveningfac.size());
                        String slot = evening_interim.get(index1);
                        String facname = eveningfac.get(index2);
                        String subject = e1.getText().toString();
                        if (h.get(facname) > 1) {
                            if (f.containsKey(facname) == false) {
                                ArrayList<String> a = new ArrayList<>();
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class = 5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                a.add(checkstring);
                                a.add(check2);
                                classes.put(facname,number_class);
                                f.put(facname, a);
                                id++;
                                if(checkstring.equals("C2")){
                                    checkstring = "B2";
                                }
                                else if(checkstring.equals("D2")){
                                    checkstring = "C2";
                                }
                                String num = cn.getText().toString()+String.valueOf(i);
                                String c2 = intSlot.get(check2);
                                if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                    Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 2);
                                        Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        lim.put(checkstring,lim.get(checkstring)+1);
                                        lim.put(c2,lim.get(c2)+1);
                                        i++;
                                    }
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class=5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                boolean t = f.get(facname).contains(checkstring);
                                boolean d = f.get(facname).contains(check2);
                                if (t == false && d==false) {
                                    if(checkstring.equals("A2")){
                                        int t1 = f.get(facname).indexOf("C1");
                                        int t2 = f.get(facname).indexOf("F1");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("C1")){
                                        int t1 = f.get(facname).indexOf("A2");
                                        int t2 = f.get(facname).indexOf("D2");
                                        if(t1<0 && t2<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("C2")){
                                        int t1 = f.get(facname).indexOf("C2");
                                        int t2 = f.get(facname).indexOf("D24");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            checkstring = "B2";
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("D2")){
                                        int t1 = f.get(facname).indexOf("C2");
                                        int t2 = f.get(facname).indexOf("C24");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            checkstring = "C2";
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        f.get(facname).add(checkstring);
                                        f.get(facname).add(check2);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);

                                        classes.put(facname,classes.get(facname)+number_class);
                                        String c2 = intSlot.get(check2);
                                        if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 2);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                lim.put(c2,lim.get(c2)+1);
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if(r2.isChecked()){
                    int number = Integer.parseInt(count.getText().toString());
                    int i = 0;
                    while(i<number){
                        int index1 = random_method.nextInt(noon_interim.size());
                        int index2 = random_method.nextInt(noonfac.size());
                        String slot = noon_interim.get(index1);
                        String facname = noonfac.get(index2);
                        String subject = e1.getText().toString();
                        if (h.get(facname) > 1) {
                            if (f.containsKey(facname) == false) {
                                ArrayList<String> a = new ArrayList<>();
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class = 5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                a.add(checkstring);
                                a.add(check2);
                                classes.put(facname,number_class);
                                f.put(facname, a);
                                id++;
                                String num = cn.getText().toString()+String.valueOf(i);
                                String c2 = intSlot.get(check2);
                                if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                    Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                    if (checkinsert) {
                                        h.put(facname, h.get(facname) - 2);
                                        Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                        lim.put(checkstring,lim.get(checkstring)+1);
                                        lim.put(c2,lim.get(c2)+1);
                                        i++;
                                    }
                                }
                            } else {
                                String s = e2.getText().toString();
                                int credit = Integer.parseInt(s);
                                int number_class = 6;
                                if(credit==3){
                                    slot = slot.substring(0,19);
                                    number_class=5;
                                }
                                String checkstring = slot.substring(0,2);
                                String check2 = slot.substring(12,15);
                                boolean t = f.get(facname).contains(checkstring);
                                boolean d = f.get(facname).contains(check2);
                                if (t == false && d==false) {
                                    if(checkstring.equals("A2")){
                                        int t1 = f.get(facname).indexOf("C1");
                                        int t2 = f.get(facname).indexOf("F1");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("C1")){
                                        int t1 = f.get(facname).indexOf("A2");
                                        int t2 = f.get(facname).indexOf("D2");
                                        int t3 = f.get(facname).indexOf("B1");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("C2")){
                                        int t1 = f.get(facname).indexOf("C2");
                                        int t2 = f.get(facname).indexOf("D24");
                                        int t3 = f.get(facname).indexOf("B2");
                                        if(t1<0 && t2<0 && t3<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            checkstring = "B2";
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("D2")){
                                        int t1 = f.get(facname).indexOf("B2");
                                        int t2 = f.get(facname).indexOf("C2");
                                        int t3 = f.get(facname).indexOf("C24");
                                        if(t1<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            checkstring = "C2";
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else if(checkstring.equals("B1")){
                                        int t1 = f.get(facname).indexOf("C1");
                                        int t2 = f.get(facname).indexOf("E1");
                                        if(t1<0 && t2<0){
                                            f.get(facname).add(checkstring);
                                            f.get(facname).add(check2);
                                            classes.put(facname,classes.get(facname)+number_class);
                                            id++;
                                            String num = cn.getText().toString()+String.valueOf(i);
                                            String c2 = intSlot.get(check2);
                                            if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                                Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                                if (checkinsert) {
                                                    h.put(facname, h.get(facname) - 2);
                                                    Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                    lim.put(checkstring,lim.get(checkstring)+1);
                                                    lim.put(c2,lim.get(c2)+1);
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        f.get(facname).add(checkstring);
                                        f.get(facname).add(check2);
                                        id++;
                                        String num = cn.getText().toString()+String.valueOf(i);

                                        classes.put(facname,classes.get(facname)+number_class);
                                        String c2 = intSlot.get(check2);
                                        if(lim.get(checkstring)<50 && lim.get(c2)<50){
                                            Boolean checkinsert = db.insertdata(num, slot, facname, subject);
                                            if (checkinsert) {
                                                h.put(facname, h.get(facname) - 2);
                                                Toast.makeText(SCSE.this, "Good to go", Toast.LENGTH_SHORT).show();
                                                lim.put(checkstring,lim.get(checkstring)+1);
                                                lim.put(c2,lim.get(c2)+1);
                                                i++;
                                            }
                                        }
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
                    Toast.makeText(SCSE.this, "No entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Class Number: "+res.getString(0)+"\n");
                    buffer.append("Slot: "+res.getString(1)+"\n");
                    buffer.append("Faculty: "+res.getString(2)+"\n");
                    buffer.append("Subject: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(SCSE.this);
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