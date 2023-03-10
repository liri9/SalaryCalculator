package com.example.salarycalculator;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.salarycalculator.Calculator;
public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_net;
    private MaterialButton main_BTN_education_fund;
    private MaterialButton main_BTN_social_security;
    private MaterialButton main_BTN_health_tax;
    private MaterialButton main_BTN_pension;
    private MaterialButton main_BTN_income_tax;
    private EditText main_EDT_gross;
    private MaterialTextView main_LBL_gross;
    private MaterialTextView main_LBL_result;
    private MaterialTextView main_LBL_submitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_BTN_net = findViewById(R.id.main_BTN_net);
        main_BTN_education_fund = findViewById(R.id.main_BTN_education_fund);
        main_BTN_social_security = findViewById(R.id.main_BTN_social_security);
        main_BTN_health_tax = findViewById(R.id.main_BTN_health_tax);
        main_BTN_pension = findViewById(R.id.main_BTN_pension);
        main_BTN_income_tax = findViewById(R.id.main_BTN_income_tax);
        main_EDT_gross = findViewById(R.id.main_EDT_gross);
        main_LBL_gross= findViewById(R.id.main_LBL_gross);
        main_LBL_result= findViewById(R.id.main_LBL_result);

        String grossSTR = main_EDT_gross.getText().toString();
        int gross =  Integer.valueOf(grossSTR);
        Calculator current = new Calculator(gross);

        double net = current.getNet();
        double EducationFund = current.getEducationFund();
        double incomeTax = current.getIncomeTax();
        double socialSecurity =  current.getSocialSecurity();
        double healthTax =current.getHealthTax();
        double  pension =current.getPensionFund();

        main_BTN_net.setOnClickListener(view -> calculate(net));
        main_BTN_education_fund.setOnClickListener(view -> calculate(EducationFund));
        main_BTN_social_security.setOnClickListener(view -> calculate(socialSecurity));
        main_BTN_health_tax.setOnClickListener(view -> calculate(healthTax));
        main_BTN_pension.setOnClickListener(view -> calculate(pension));
        main_BTN_income_tax.setOnClickListener(view -> calculate(incomeTax));

    }
    private void calculate(double gross){
        main_LBL_result.setText("Result: "+gross);
    }
}