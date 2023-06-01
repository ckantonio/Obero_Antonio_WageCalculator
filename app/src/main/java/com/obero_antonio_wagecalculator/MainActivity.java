package com.obero_antonio_wagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText hoursWorkedEditText;
    private EditText hourlyRateEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        hoursWorkedEditText = findViewById(R.id.edittext_hours_worked);
        hourlyRateEditText = findViewById(R.id.edittext_hourly_rate);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.textview_result);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateWage();
            }
        });
    }

    private void calculateWage() {
        // Get the input values
        String hoursWorkedStr = hoursWorkedEditText.getText().toString();
        String hourlyRateStr = hourlyRateEditText.getText().toString();

        // Check if the input values are valid
        if (hoursWorkedStr.isEmpty() || hourlyRateStr.isEmpty()) {
            resultTextView.setText("Please enter valid values.");
            return;
        }

        // Parse the input values
        double hoursWorked = Double.parseDouble(hoursWorkedStr);
        double hourlyRate = Double.parseDouble(hourlyRateStr);

        // Calculate the wage
        double wage = hoursWorked * hourlyRate;

        // Format and display the result
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        String resultStr = "Wage: PHP " + decimalFormat.format(wage);
        resultTextView.setText(resultStr);
    }
}
