package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Change_number extends AppCompatActivity implements View.OnClickListener {
    private EditText input_number,output_number;
    private Button b_enter;
    private String[] nc={"2","8","10","16"};
    private int sure_start=0;
    private int sure_goal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_number);
        input_number=(EditText) findViewById(R.id.input_number);
        output_number=(EditText) findViewById(R.id.output_number);
        b_enter=(Button)findViewById(R.id.button_enter);
        b_enter.setOnClickListener(this);
        ArrayAdapter<String> adapter_start=new ArrayAdapter<String >(Change_number.this,android.R.layout.simple_list_item_1,nc);
        ListView list_numberstart=(ListView)findViewById(R.id.list_numberstart);
        ArrayAdapter<String>adapter_goal=new ArrayAdapter<String >(Change_number.this,android.R.layout.simple_list_item_1,nc);
        ListView list_numbergoal=(ListView)findViewById(R.id.list_numbergoal);
        list_numberstart.setAdapter(adapter_start);
        list_numbergoal.setAdapter(adapter_goal);
        list_numberstart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sure_start=position;
            }
        });
        list_numbergoal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sure_goal=position;
            }
        });
    }

    @Override
    public void onClick(View view) {
        int i=0;
        if(view.getId()==R.id.button_enter)
        {
            int jinzhi=0,ten=0;
            char[] num_o= input_number.getText().toString().toCharArray();
            switch (sure_start)
            {
                case 0:jinzhi=2;break;
                case 1:jinzhi=8;break;
                case 2:jinzhi=10;break;
                case 3:jinzhi=16;break;
                default:break;
            }
            while(i<num_o.length)
            {
                switch (num_o[i])
                {
                    case '0':ten=ten+0;break;
                    case '1':ten= ten+(int) (1*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '2':ten= ten+(int) (2*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '3':ten= ten+(int) (3*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '4':ten= ten+(int) (4*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '5':ten= ten+(int) (5*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '6':ten= ten+(int) (6*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '7':ten= ten+(int) (7*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '8':ten= ten+(int) (8*Math.pow(jinzhi,num_o.length-1-i));break;
                    case '9':ten= ten+(int) (9*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'A':ten= ten+(int) (10*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'B':ten= ten+(int) (11*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'C':ten= ten+(int) (12*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'D':ten= ten+(int) (13*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'E':ten= ten+(int) (14*Math.pow(jinzhi,num_o.length-1-i));break;
                    case 'F':ten= ten+(int) (15*Math.pow(jinzhi,num_o.length-1-i));break;
                    default:break;
                }
                    i++;
            }
            switch (sure_goal)
            {
                case 0:;output_number.setText(Integer.toBinaryString(ten));break;
                case 1:output_number.setText(Integer.toOctalString(ten));break;
                case 2:output_number.setText(Integer.toString(ten));break;
                case 3:output_number.setText(Integer.toHexString(ten));break;
                default:break;
            }
        }
    }
}
