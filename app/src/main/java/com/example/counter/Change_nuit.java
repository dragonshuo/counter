package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Change_nuit extends AppCompatActivity implements View.OnClickListener{
    private EditText input_unit,output_unit;
    private Button b_sure;
    private String[] Long={"mm","cm","dm","m","km"};
    private String[] sort={"long","volume"};
    private Double[][] change={{1.0,0.1,0.01,0.001,0.000001},
                                {10.0,1.0,0.1,0.01,0.00001},
                                {100.0,10.0,1.0,0.1,0.0001},
                                {1000.0,100.0,10.0,1.0,0.001},
                                {1000000.0,100000.0,10000.0,1000.0,1.0}};
   private int sure_sort=0;
    private int sure_start=0;
    private int sure_goal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nuit);
        input_unit=(EditText) findViewById(R.id.input_unit);
        output_unit=(EditText) findViewById(R.id.output_nuit);
        b_sure=(Button)findViewById(R.id.button_ok);
        b_sure.setOnClickListener(this);
        ArrayAdapter<String>adapter_start=new ArrayAdapter<String >(Change_nuit.this,android.R.layout.simple_list_item_1,Long);
        ListView list_unitstart=(ListView)findViewById(R.id.list_unitstart);
        ArrayAdapter<String>adapter_sort=new ArrayAdapter<String >(Change_nuit.this,android.R.layout.simple_list_item_1,sort);
        ListView list_unitsort=(ListView)findViewById(R.id.list_unitsort);
        ArrayAdapter<String>adapter_goal=new ArrayAdapter<String >(Change_nuit.this,android.R.layout.simple_list_item_1,Long);
        ListView list_unitgoal=(ListView)findViewById(R.id.list_unitgoal);
        list_unitsort.setAdapter(adapter_sort);
        list_unitstart.setAdapter(adapter_start);
        list_unitgoal.setAdapter(adapter_goal);
        list_unitsort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 sure_sort=position;
            }
        });
        list_unitstart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sure_start=position;
            }
        });
        list_unitgoal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sure_goal=position;
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button_ok)
        {
            Double answer=Double.parseDouble(input_unit.getText().toString());
            if (sure_sort==1)
            {
                answer=answer*change[sure_start][sure_goal]*change[sure_start][sure_goal]*change[sure_start][sure_goal];
                output_unit.setText(answer.toString());
            }
            else {
                answer=answer*change[sure_start][sure_goal];
                output_unit.setText(answer.toString());
            }
        }
    }

    }

