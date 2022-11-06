package com.example.calculadorav2;

import static com.example.calculadorav2.Operation.ADD;
import static com.example.calculadorav2.Operation.DIVIDE;
import static com.example.calculadorav2.Operation.MULTIPLY;
import static com.example.calculadorav2.Operation.SUBTRACT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult, tvOperation;

    private double result;
    private String screen_number;
    private boolean isDecimal;
    private boolean numReady;
    private boolean opReady;
    private Operation op;

    private DecimalFormat df = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        tvOperation = findViewById(R.id.tvOperation);

        screen_number = "0";
        isDecimal = false;
        numReady = false;
        opReady = false;

        result = 0.0;
        op = ADD;
    }

    public void onClick(View view){
        Button button = (Button) view;
        if(screen_number.contains("∞") || screen_number.contains("N/A"))
            clearAll();

        if(button.getText().toString().matches("[\\d||.]")) {
            if(numReady){
                screen_number="0";
                numReady = false;
            }
            addDigit(button.getText().toString());
            opReady = true;
        }else if(button.getId()==R.id.button_change_sign){
            changeSign();
        }else if(button.getId()==R.id.button_clear){
            clearAll();
        }else{
            if(opReady) {
                calculate();
                opReady = false;
            }
            switch (button.getId()){
                case R.id.button_add: op = ADD; break;
                case R.id.button_subtract: op = SUBTRACT; break;
                case R.id.button_multiply: op = MULTIPLY; break;
                case R.id.button_divide: op = DIVIDE; break;
            }
            isDecimal = false;
            numReady = true;
        }
        updateOperationView();
    }

    private void updateOperationView() {
        String operation = "";
        switch (op){
            case MULTIPLY: operation=getResources().getString(R.string.multiply); break;
            case DIVIDE: operation=getResources().getString(R.string.divide); break;
            case ADD: operation=getResources().getString(R.string.plus); break;
            case SUBTRACT: operation=getResources().getString(R.string.minus); break;
            case PERCENT: operation=getResources().getString(R.string.percent); break;
        }
        tvOperation.setText(df.format(result) + " " + operation);
    }

    private void calculate(){
        if(screen_number.contains("∞") || screen_number.contains("N/A"))
            return;

        switch (op){
            case MULTIPLY: result*=Double.parseDouble(screen_number); break;
            case DIVIDE: result/=Double.parseDouble(screen_number); break;
            case ADD: result+=Double.parseDouble(screen_number); break;
            case SUBTRACT: result-=Double.parseDouble(screen_number); break;
            case PERCENT: result=Double.parseDouble(screen_number)/100.0; break;
        }
        screen_number = df.format(result);
        printNumber();
    }

    private void addDigit(String digit) {
        if(screen_number.contains("∞") || screen_number.contains("N/A"))
            return;

        if(digit.equals(".")){
            if(!screen_number.contains(".")){
                isDecimal=true;
                screen_number+=".";
            }
        }else{
            if (!isDecimal)
                screen_number = df.format(Double.parseDouble(screen_number + digit));
            else
                screen_number = screen_number + digit;

            printNumber();
        }

    }

    private void printNumber() {
        tvResult.setText(screen_number);
    }


    private void changeSign() {
        if(screen_number.contains("∞") || screen_number.contains("N/A"))
            return;

        double num = Double.parseDouble(screen_number);
        num = -num;
        screen_number = df.format(num);
        printNumber();
    }

    private void clearAll(){
        screen_number = "0";
        isDecimal = false;
        numReady = false;

        result = 0.0;
        op = ADD;
        printNumber();
    }
}