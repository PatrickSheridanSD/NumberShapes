package com.bignerdranch.android.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String message = "";

    class Number {

        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;

            int triangular = 1;

            while (triangular < number) {
                x++;

                triangular = triangular + x;
            }

            if (triangular == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {

        EditText input = (EditText) findViewById(R.id.input);

        if (input.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {


            Number one = new Number();

            one.number = Integer.parseInt(input.getText().toString());



            if (one.isSquare()) {
                if (one.isTriangular()) {
                    message = one.number + " is both triangular and square!";
                } else {
                    message = one.number + " square but not triangular.";
                }
            } else {
                if (one.isTriangular()) {
                    message = one.number + " is triangular but not square!";
                } else {
                    message = one.number + " is neither.";
                }
            }

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
