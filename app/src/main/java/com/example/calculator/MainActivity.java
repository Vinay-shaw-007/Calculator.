package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot,btnEqual,btnPercentage,btnAdd,btnSub,btnMultiply,btnDivide,btnClear,btnBack;
    private TextView tv_input,tv_output,tv_cal;
    private String process="",get_val="";
    private Double val1,val2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIviwes();
//        tv_cal.setcolor(R.color.gradient1,R.color.gradient2);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="0";
                tv_input.setText(tv_input.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="1";
                tv_input.setText(tv_input.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="2";
                tv_input.setText(tv_input.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                process+="3";
                tv_input.setText(tv_input.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="4";
                tv_input.setText(tv_input.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="5";
                tv_input.setText(tv_input.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="6";
                tv_input.setText(tv_input.getText()+"6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="7";
                tv_input.setText(tv_input.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process+="8";
                tv_input.setText(tv_input.getText()+"8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process +="9";
                tv_input.setText(tv_input.getText()+"9");

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process +=".";
                tv_input.setText(tv_input.getText()+".");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(tv_input.getText().toString()==""){
                    tv_output.setText("");
                }
                else{
                    solve();
                    if(tv_output.getText().toString()!=""){
                        tv_input.setText(process);
                        tv_output.setText("");
                    }
                    process=process+"+";
                    tv_input.setText(tv_input.getText().toString()+"+");
                }


            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_input.getText().toString()==""){
                    tv_output.setText("");
                }
                else{
                    solve();
                    if(tv_output.getText().toString()!=""){
                        tv_input.setText(process);
                        tv_output.setText("");
                    }
                    process=process+"-";
                    tv_input.setText(tv_input.getText().toString()+"-");
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_input.getText().toString()==""){
                    tv_output.setText("");
                }
                else{
                    solve();
                    if(tv_output.getText().toString()!=""){
                        tv_input.setText(process);
                        tv_output.setText("");
                    }
                    process=process+"/";
                    tv_input.setText(tv_input.getText().toString()+"/");
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_input.getText().toString()==""){
                    tv_output.setText("");
                }
                else{
                    solve();
                    if(tv_output.getText().toString()!=""){
                        tv_input.setText(process);
                        tv_output.setText("");
                    }
                    process=process+"*";
                    tv_input.setText(tv_input.getText().toString()+"*");
                }
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_input.getText().toString()==""){
                    tv_output.setText("");
                }
                else {
                    val1 = (Double.parseDouble(tv_input.getText().toString()))/100;
                    tv_input.setText(tv_input.getText() + "%");
                    process=String.valueOf(val1);
                    tv_output.setText(process);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process="";
                tv_input.setText("");
                tv_output.setText("");

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(tv_input.getText().toString().equals(""))){
                    int length=tv_input.getText().toString().length();
                    String name=tv_input.getText().toString().substring(0,length-1);
                    process=name;
                    tv_input.setText(process);

                }
                else{
                    tv_output.setText("");
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                tv_output.setText(process);
            }
        });
    }
    void solve(){
        if(process.split("\\*").length==2)
        {
            String number[]=process.split("\\*");
            try {
                result=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                process=result+"";
            }
            catch (Exception e){
            }
        }
        else if(process.split("\\+").length==2)
        {
            String number[]=process.split("\\+");
            try {
                result=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                process=result+"";
            }
            catch (Exception e){
            }
        }
        else if(process.split("/").length==2)
        {
            String number[]=process.split("/");
            try {
                result=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                process=result+"";
            }
            catch (Exception e){
            }
        }
        else if(process.split("-").length==2)
        {
            String number[]=process.split("-");
            if(number[0]==""&&number.length>1){
                number[0]=0+"";
            }
            try {
                if(number.length==2){
                    result=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    result=Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                }
                process=result+"";
            }
            catch (Exception e){
            }
        }
        String n[]=process.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                process=n[0];
            }
        }
//        tv_input.setText(process);
    }

    void setupUIviwes(){
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnEqual=findViewById(R.id.btnEqual);
        btnPercentage=findViewById(R.id.btnPercentage);
        btnDot=findViewById(R.id.btnDot);

        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);

        btnClear=findViewById(R.id.btnClear);
        btnBack=findViewById(R.id.btnBack);

        tv_input=findViewById(R.id.tv_input);
        tv_output=findViewById(R.id.tv_output);
        tv_cal=findViewById(R.id.tv_cal);

    }

}