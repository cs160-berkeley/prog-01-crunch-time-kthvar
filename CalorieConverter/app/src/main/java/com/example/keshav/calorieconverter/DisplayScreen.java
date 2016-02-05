package com.example.keshav.calorieconverter;

import android.os.Bundle;
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
import android.widget.ListView;


public class DisplayScreen extends AppCompatActivity {
    private Button button3;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        listview=(ListView) findViewById(R.id.list);
        button3=(Button) findViewById(R.id.button3);

        String[] values=getIntent().getExtras().getStringArray("listo");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1, values);
        listview.setAdapter(adapter);



        // ListView Item Click Listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition= position;

                // ListView Clicked item value
                String  itemValue    = (String) listview.getItemAtPosition(position);

            }
    });
                button3.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        finish();

                    }


                });

}
}
