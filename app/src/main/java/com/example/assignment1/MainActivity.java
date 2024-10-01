package com.example.assignment1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText MortgageAmount;
    private EditText TenureAmount;
    private EditText InterestRate;
    private Button CalculateButton;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MortgageAmount = findViewById(R.id.MortgageAmount);
        TenureAmount = findViewById(R.id.TenureAmount);
        InterestRate = findViewById(R.id.InterestRate);
        CalculateButton = findViewById(R.id.CalculateButton);
        Result = findViewById(R.id.Result);

        calculateButton.setOnClickListener(v -> {
            calculateEMI();
        });
    }

    private void calculateEMI() {
        double principal = Double.parseDouble(MortgageAmount.getText().toString());
        double tenureInYears = Double.parseDouble(TenureAmount.getText().toString());
        double rateInMonths = Double.parseDouble(InterestRate.getText().toString()) / 12 / 100;
        double emi = principal * (rateInMonths * Math.pow(1 + rateInMonths, tenureInMonths * 12)) / (Math.pow(1 + rateInMonths, tenureInMonths * 12) - 1);
        Result.setText("Monthly EMI: $" + String.format("%.2f", emi));
    }
}
