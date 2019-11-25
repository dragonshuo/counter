package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.Stack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import java.util.zip.DeflaterOutputStream;

public class counterface extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b_add, b_minus, b_cheng, b_chu, b_delete, b_equal,b_left,b_right,b_point,b_sin,b_cos,b_tan,b_sqrt;
    private EditText show;
    private String num1 = "0", num2 = "0";
    public int mark = 0;
    private StringBuilder text=new StringBuilder();
    public char[][] law= {{'>','>','<','<','<','>','>'},
            {'>','>','<','<','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'<','<','<','<','<','=',0},
            {'>','>','>','>',0,'>','>'},
            {'<','<','<','<','<',0,'='}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        setContentView(R.layout.counterface);
        setTitle("计算器");
        //获取控件
        show = (EditText) findViewById(R.id.edit_text);
        b1 = (Button) findViewById(R.id.button_1);
        b2 = (Button) findViewById(R.id.button_2);
        b3 = (Button) findViewById(R.id.button_3);
        b4 = (Button) findViewById(R.id.button_4);
        b5 = (Button) findViewById(R.id.button_5);
        b6 = (Button) findViewById(R.id.button_6);
        b7 = (Button) findViewById(R.id.button_7);
        b8 = (Button) findViewById(R.id.button_8);
        b9 = (Button) findViewById(R.id.button_9);
        b0 = (Button) findViewById(R.id.button_0);
        b_add = (Button) findViewById(R.id.button_add);
        b_minus = (Button) findViewById(R.id.button_minus);
        b_cheng = (Button) findViewById(R.id.button_cheng);
        b_chu = (Button) findViewById(R.id.button_chu);
        b_delete = (Button) findViewById(R.id.button_delete);
        b_equal = (Button) findViewById(R.id.button_equal);
        b_left = (Button) findViewById(R.id.button_left);
        b_right = (Button) findViewById(R.id.button_right);
        b_point = (Button) findViewById(R.id.button_point);
        b_sin=(Button) findViewById(R.id.button_sin);
        b_cos=(Button) findViewById(R.id.button_cos);
        b_tan=(Button) findViewById(R.id.button_tan);
        b_sqrt=(Button) findViewById(R.id.button_sqrt);
//配置监听器
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        b_add.setOnClickListener(this);
        b_minus.setOnClickListener(this);
        b_cheng.setOnClickListener(this);
        b_chu.setOnClickListener(this);
        b_delete.setOnClickListener(this);
        b_equal.setOnClickListener(this);
        b_left.setOnClickListener(this);
        b_right.setOnClickListener(this);
        b_point.setOnClickListener(this);
        b_sin.setOnClickListener(this);
        b_cos.setOnClickListener(this);
        b_tan.setOnClickListener(this);
        b_sqrt.setOnClickListener(this);
    }

    public void onClick(View v) {
        StringBuilder mark_delete=new StringBuilder();
        switch (v.getId()) {
            case R.id.button_0:
                show.append("0");
                text.append("0");
                mark_delete.append("1");
                break;
            case R.id.button_1:
                show.append("1");
                text.append("1");
                mark_delete.append("1");
                break;
            case R.id.button_2:
                show.append("2");
                text.append("2");
                mark_delete.append("1");
                break;
            case R.id.button_3:
                show.append("3");
                text.append("3");
                mark_delete.append("1");
                break;
            case R.id.button_4:
                show.append("4");
                text.append("4");
                mark_delete.append("1");
                break;
            case R.id.button_5:
                show.append("5");
                text.append("5");
                mark_delete.append("1");
                break;
            case R.id.button_6:
                show.append("6");
                text.append("6");
                mark_delete.append("1");
                break;
            case R.id.button_7:
                show.append("7");
                text.append("7");
                break;
            case R.id.button_8:
                show.append("8");
                text.append("8");
                break;
            case R.id.button_9:
                show.append("9");
                text.append("9");
                break;
            case R.id.button_add:
                show.append("+");
                text.append("|+|");
                break;
            case R.id.button_minus:
                show.append("-");
                text.append("|-|");
                break;
            case R.id.button_cheng:
                show.append("*");
                text.append("|*|");
                break;
            case R.id.button_chu:
                show.append("/");
                text.append("|/|");
                break;
            case R.id.button_left:
                show.append("(");
                text.append("|(|");
                break;
            case R.id.button_right:
                show.append(")");
                text.append("|)|");
                break;
            case R.id.button_point:
                show.append(".");
                text.append(".");
                break;
                //--------------------------------------------
            case R.id.button_sin:
                show.append("sin");
                text.append("|sin|");break;
            case R.id.button_cos:
                show.append("cos");
                text.append("|cos|");break;
            case R.id.button_tan:
                show.append("tan");
                text.append("|tan|");break;
            case R.id.button_sqrt:
                show.append("sqrt");
                text.append("|sqrt|");break;
            //-------------------------------------------------
            case R.id.button_equal:
                show.append("#");
                text.append("|#|");
                int i=0;
                String all=text.toString();
                text=new StringBuilder();
                String [] a= all.split("[|]");
                for (i=0;i<a.length;i++)
                {
                    System.out.println("第"+i+"个："+a[i]);
                }
                i=0;
                Stack stack_mark=new Stack();
                Stack stack_num=new Stack();
                stack_mark.push("#");
                int xl=0,yl=0;
                Double jie=0.00;
                String x = "";
                String theta="";
                System.out.println(xl);
                System.out.println(yl);
                System.out.println(jie);
                System.out.println(x);
                System.out.println(theta);
                System.out.println("-----------------------------------------");
               while(i<a.length) {System.out.println("第"+i+"个："+a[i]);
                    if(a[i].equals("+")||a[i].equals("-")||a[i].equals("*")||a[i].equals("/")||a[i].equals("(")||a[i].equals(")")||a[i].equals("#"))
                    {
                        String e = (String) stack_mark.pop();//------------
                        stack_mark.push(e);
                        System.out.println("e="+e);
                        switch(e)
                        {
                            case "+":xl=0;break;
                            case "-":xl=1;break;
                            case "*":xl=2;break;
                            case "/":xl=3;break;
                            case "(":xl=4;break;
                            case ")":xl=5;break;
                            case "#":xl=6;break;
                            default:break;
                        }
                        switch(a[i])
                        {
                            case "+":yl=0;break;
                            case "-":yl=1;break;
                            case "*":yl=2;break;
                            case "/":yl=3;break;
                            case "(":yl=4;break;
                            case ")":yl=5;break;
                            case "#":yl=6;break;
                            default:break;
                        }
                        System.out.println(xl);
                        System.out.println(yl);
                        System.out.println(law[xl][yl]);
                        switch (law[xl][yl])
                        {
                            
                            case '<':stack_mark.push(a[i]);break;
                            case '=':x=(String)stack_mark.pop();break;
                            case '>':
                                theta=(String)stack_mark.pop();
                                System.out.println("theta="+theta);
                                num2=(String)stack_num.pop();
                                System.out.println("num2="+num2);
                                num1=(String)stack_num.pop();
                                System.out.println("num1="+num1);
                                i=i-1;
                                switch(theta)
                                {
                                    case "+":jie=Double.parseDouble(num1)+Double.parseDouble(num2);break;//a big
                                    case "-":
                                        BigDecimal a1= new BigDecimal(num1+"");
                                        BigDecimal b1=new BigDecimal(num2+"");
                                        jie=a1.subtract(b1).doubleValue();break;//jie=Double.parseDouble(num1)-Double.parseDouble(num2);break;
                                    case "*":jie=Double.parseDouble(num1)*Double.parseDouble(num2);break;//b big
                                    case "/":jie=Double.parseDouble(num1)/Double.parseDouble(num2);break;
                                    default:break;
                                }
                                System.out.println("jie="+jie);
                                stack_num.push(jie.toString());
                                break;
                                default:break;
                        }
                    }
                    else if(a[i].equals(""))
                    {

                    }
                    else if(a[i].equals("sin")||a[i].equals("cos")||a[i].equals("tan")||a[i].equals("sqrt"))
                    {
                        Double triangle =0.00;
                        switch (a[i])
                        {
                            case "sin":triangle=Math.sin(Double.parseDouble(a[i+1]));break;
                            case "cos":triangle=Math.cos(Double.parseDouble(a[i+1]));break;
                            case "tan":triangle=Math.tan(Double.parseDouble(a[i+1]));break;
                            case "sqrt":triangle=Math.sqrt(Double.parseDouble(a[i+1]));break;
                            default:break;
                        }
                        a[i+1]=triangle.toString();
                    }
                    else
                    {
                        stack_num.push(a[i]);
                        System.out.println("数字："+a[i]);
                    }
                    i++;
                }
                show.setText((String)stack_num.pop());
               i=0;
                break;
            case R.id.button_delete:
                //mark=0;
                num1="0";
                num2="0";
                show.setText("");
                text=new StringBuilder();
                //text.deleteCharAt(text.length()-1);
                break;
            default:break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);
       return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.change_unit:
                Intent intent =new Intent(counterface.this,Change_nuit.class);
                startActivity(intent);
                break;
            case R.id.change_number:
                Intent intent1=new Intent(counterface.this,Change_number.class);
                startActivity(intent1);
                break;
            case R.id.help:
                AlertDialog.Builder dialog_help= new AlertDialog.Builder(counterface.this);
                dialog_help.setTitle("help");
                dialog_help.setMessage("");//-------------------------
                dialog_help.setCancelable(false);
                dialog_help.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog_help.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog_help.show();
            default:break;
        }
        return  true;
    }
}
