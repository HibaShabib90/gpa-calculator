package com.example.gpa_50020948_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate_gpa;
    EditText grade1,grade2,grade3,grade4,grade5;
    TextView gpa;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate_gpa=(Button)findViewById(R.id.calculate_gpa);
        grade1=(EditText)findViewById(R.id.grade1);
        grade2=(EditText)findViewById(R.id.grade2);
        grade3=(EditText)findViewById(R.id.grade3);
        grade4=(EditText)findViewById(R.id.grade4);
        grade5=(EditText)findViewById(R.id.grade5);
        gpa=(TextView)findViewById(R.id.gpa);
        calculate_gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float g1,g2,g3,g4,g5;
                float avarage;
                if(count%2==0){
                    if(grade1.getText().toString().equals("")||grade2.getText().toString().equals("")||
                            grade3.getText().toString().equals("")||grade4.getText().toString().equals("")||
                            grade5.getText().toString().equals("")){
                        gpa.setText("Please Enter all five grades");
                        gpa.setBackgroundColor(Color.RED);
                        gpa.setTextSize(20);
                    }
                    else{
                        g1=Float.parseFloat(grade1.getText().toString());
                        g2=Float.parseFloat(grade2.getText().toString());
                        g3=Float.parseFloat(grade3.getText().toString());
                        g4=Float.parseFloat(grade4.getText().toString());
                        g5=Float.parseFloat(grade5.getText().toString());
                        avarage=(g1+g2+g3+g4+g5)/5;
                        if (avarage<60){
                            gpa.setText(Float.toString(avarage));
                            gpa.setBackgroundColor(Color.RED);
                            gpa.setTextSize(40);
                        }
                        if (avarage>60 && avarage<80){
                            gpa.setText(Float.toString(avarage));
                            gpa.setBackgroundColor(Color.YELLOW);
                            gpa.setTextSize(40);
                        }
                        if (avarage>=80 && avarage <= 100){
                            gpa.setText(Float.toString(avarage));
                            gpa.setBackgroundColor(Color.GREEN);
                            gpa.setTextSize(40);
                        }
                        count++;
                        calculate_gpa.setText("Clear");
                    }
                }
                else{
                    grade1.setText("");
                    grade2.setText("");
                    grade3.setText("");
                    grade4.setText("");
                    grade5.setText("");
                    gpa.setText("");
                    calculate_gpa.setText("Calculate GPA");
                    count++;


                }
            }
        });
    }
}