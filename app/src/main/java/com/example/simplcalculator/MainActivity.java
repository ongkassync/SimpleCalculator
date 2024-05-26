package com.example.simplcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView displayTextView;
    private Button Back,column,percent,divide,seven,eight,nine,multiply,four,five,six,add,one,two,three,subtract,Ac,zero,point,equal;
    private String input,answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.textView_display);
        Back = findViewById(R.id.back);
        column = findViewById(R.id.column);
        percent = findViewById(R.id.percent);
        divide = findViewById(R.id.divide);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
       multiply = findViewById(R.id.multiply);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        add = findViewById(R.id.add);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        subtract = findViewById(R.id.subtract);
        Ac = findViewById(R.id.Ac);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);

    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "Ac":
                input="";
                break;
            case "ans":
                input+=answer;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "=":
                Solve();
                answer=input;
                break;
            case "←":
                String newText = input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input == null) {
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input+=data;
        }
        displayTextView.setText(input);
    }


    public void Solve() {
        if (input.split("\\*").length == 2) {
            String number[]=input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input=mul+"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("/").length == 2) {
            String number[]=input.split("/");
            try{
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){

            }

        }
        else if (input.split("-").length == 2) {
            String number[]=input.split("-");
            if(number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try{
                double sub =0;
                if(number.length==2){
                    sub=Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    sub=Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                input=sub+"";

            }
            catch (Exception e){

            }

        }
        else if (input.split("\\+").length == 2) {
            String number[]=input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input=sum+"";
            }
            catch (Exception e){

            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        displayTextView.setText(input);
    }
}

