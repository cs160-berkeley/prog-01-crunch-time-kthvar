package com.example.keshav.calorieconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.app.Activity;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;


public class CalorieConverter extends AppCompatActivity {
//    Button button;
//    EditText txtCTime;
//    View rootView;
    private Spinner spinner;
    private EditText editText;
    private EditText textView6;
    private HashMap<String, Integer> calorierepratios;
    private HashMap<String, Integer> calorieminratios;
    public ArrayList<String> arrayList;
    TextView pushup_text_view, situp_text_view, squats_text_view, leglift_text_view, jumpingjacks_text_view,plank_text_view,
            stairclimb_text_view, pullup_text_view, cycling_text_view, walking_text_view, jogging_text_view, swimming_text_view;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_converter);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        calorierepratios=new HashMap();
        calorieminratios=new HashMap();
        calorierepratios.put("Pushup",350);
        calorierepratios.put("Situp",200);
        calorierepratios.put("Squats",225);
        calorieminratios.put("Leg-lift",25);
        calorieminratios.put("Plank",25);
        calorieminratios.put("Jumping Jacks",10);
        calorierepratios.put("Pullup",100);
        calorieminratios.put("Cycling", 12);
        calorieminratios.put("Walking", 20);
        calorieminratios.put("Jogging", 12);
        calorieminratios.put("Swimming", 13);
        calorieminratios.put("Stair-Climbing", 15);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemselected = parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), itemselected + " is selected", Toast.LENGTH_LONG).show();
                if (calorieminratios.containsKey(itemselected)) {
                    ((TextView) findViewById(R.id.textView2)).setText("         ⇈⇈⇈⇈MINS⇈⇈⇈⇈");
                } else {
                    ((TextView) findViewById(R.id.textView2)).setText("         ⇈⇈⇈⇈REPS⇈⇈⇈⇈");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.button);
        Button button2=(Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Integer equiva;
                EditText input = ((EditText) findViewById((R.id.editText)));
                EditText weight=((EditText)findViewById(R.id.textView6));
                Integer weightint=Integer.parseInt(weight.getText().toString());
               String a = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
                if(calorieminratios.containsKey(a)) {
                    equiva = calorieminratios.get(a);
                }
                else{
                    equiva=calorierepratios.get(a);
                }
                Integer repmincount =  (Integer) (100*weightint*Integer.parseInt(input.getText().toString())/(equiva*150));
                ((TextView) findViewById(R.id.textView5)).setText(Integer.toString(repmincount));

            }


        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                arrayList=new ArrayList<String>();
                Integer equiva;
                EditText input = ((EditText) findViewById((R.id.editText)));
                EditText weight=((EditText)findViewById(R.id.textView6));
                Integer weightint=Integer.parseInt(weight.getText().toString());
                String a = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
                if(calorieminratios.containsKey(a)) {
                    equiva = calorieminratios.get(a);
                }
                else{
                    equiva=calorierepratios.get(a);
                }
                Integer repmincount =  (Integer) (100*weightint*Integer.parseInt(input.getText().toString())/(equiva*150));
                for(String k : calorieminratios.keySet()){
                    double indexer=150*repmincount/(100*weightint);
                    double ratio=(double) (calorieminratios.get(k));
                    Integer number= (int) (ratio*indexer);
                    arrayList.add(k+": "+number.toString()+" mins");
                }
                for(String k : calorierepratios.keySet()){
                    double indexer=150*repmincount/(100*weightint);
                    double ratio=(double) (calorierepratios.get(k));
                    Integer number= (int) (ratio*indexer);
                    arrayList.add(k+": "+number.toString()+" reps");
                }
                String[] array=new String[arrayList.size()];
                array=arrayList.toArray(array);
                Intent myintent = new Intent("com.example.keshav.calorieconverter.Display");
                myintent.putExtra("listo",array);
                startActivity(myintent);

            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calorie_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
