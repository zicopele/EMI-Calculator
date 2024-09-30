package com.example.assignment1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mortgageAmount;
    private EditText tenure;
    private EditText interestRate;
    private Button calculateButton;
    private TextView emiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mortgageAmount = findViewById(R.id.mortgageAmount);
        tenure = findViewById(R.id.tenure);
        interestRate = findViewById(R.id.interestRate);
        calculateButton = findViewById(R.id.calculateButton);
        emiResult = findViewById(R.id.emiResult);

        calculateButton.setOnClickListener(v -> {
            calculateEMI();
        });
    }

    private void calculateEMI() {
        double principal = Double.parseDouble(mortgageAmount.getText().toString());
        double tenureInYears = Double.parseDouble(tenure.getText().toString());
        double rateInMonths = Double.parseDouble(interestRate.getText().toString()) / 12 / 100;
        double emi = principal * (rateInMonths * Math.pow(1 + rateInMonths, tenureInYears * 12)) / (Math.pow(1 + rateInMonths, tenureInYears * 12) - 1);
        emiResult.setText("Monthly EMI: $" + String.format("%.2f", emi));
    }
}