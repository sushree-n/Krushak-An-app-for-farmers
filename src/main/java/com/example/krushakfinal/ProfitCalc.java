package com.example.krushakfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.internal.StringResourceValueReader;

public class ProfitCalc extends AppCompatActivity {

    TextView Result;
    EditText CP, SP, Kg;
    Button Calc;

    float total_prof,CostP, SellP,weight_kg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_calc);
        CP = findViewById(R.id.cost_price);
        SP = findViewById(R.id.selling_price);
        Kg = findViewById(R.id.no_of_kg);
        Calc = findViewById(R.id.calc_button);
        Result = findViewById(R.id.profit);

        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CostP = Float.parseFloat(CP.getText().toString());
                SellP = Float.parseFloat(SP.getText().toString());
                weight_kg = Float.parseFloat(Kg.getText().toString());
                total_prof = (SellP-CostP)*weight_kg;
                Result.setText(String.valueOf(total_prof));
            }
        });

    }
}