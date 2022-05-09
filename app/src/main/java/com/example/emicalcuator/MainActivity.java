package com.example.emicalcuator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cal_btn,reset_btn;
    EditText amount_edt, interst_edt, year_edt, month_edt;
    String amount, intrest, year;
    String month = "" + 0;
    int f_amount = 0;
    int f_interest = 0;
    int f_year = 0;
    int f_month = 0;
    float final_interest = 0;
    int year_month = 0;
    int total_month = 0;
    float fil_interest = 0;
    float final_monthel = 0;
    float final_emi = 0;
    private TextView emi_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Binding();

        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = amount_edt.getText().toString();
                intrest = interst_edt.getText().toString();
                year = year_edt.getText().toString();
                month = month_edt.getText().toString();
                f_amount = Integer.parseInt(amount);
                f_interest = Integer.parseInt(intrest);
                f_year = Integer.parseInt(year);


                if (month_edt.getText().toString().length() == 0) {
                    year_month = f_year * 12;
                    total_month = year_month;

                    final_interest = (f_amount * f_interest) / 100;
                    fil_interest = final_interest / total_month;

                    final_monthel = f_amount / total_month;
                    final_emi = fil_interest + final_monthel;
                    emi_text.setText("" + final_emi);

                    month_edt.setText("0");

                } else {

                    year_month = f_year * 12;
                    total_month = year_month + f_month;


                    final_interest = (f_amount * f_interest) / 100;
                    fil_interest = final_interest / total_month;
                    f_month = Integer.parseInt(month);
                    final_monthel = f_amount / total_month;
                    final_emi = fil_interest + final_monthel;
                    emi_text.setText("" + final_emi);
                }


                Toast.makeText(MainActivity.this, "" + final_emi, Toast.LENGTH_SHORT).show();
//


            }
        });

    }


    private void Binding() {
        cal_btn = findViewById(R.id.cal_btn);
        amount_edt = findViewById(R.id.amount_edt);
        interst_edt = findViewById(R.id.interst_edt);
        year_edt = findViewById(R.id.year_edt);
        month_edt = findViewById(R.id.month_edt);
        emi_text = findViewById(R.id.emi_text);
    }
}