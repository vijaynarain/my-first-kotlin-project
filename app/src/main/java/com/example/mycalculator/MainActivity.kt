package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()
        calculateButton.setOnClickListener(){

            val firstNumberString = numberOneEditText.text.toString()
            val secoundNumberString = numberOneEditText.text.toString()

            if(firstNumberString.isEmpty()){
                Toast.makeText(this,"Enter the first number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(secoundNumberString.isEmpty()){
                Toast.makeText(this,"Enter the secound number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val firstNumber = numberOneEditText.text.toString().toDouble()
            val secoundNumber = numberOneEditText.text.toString().toDouble()

            val operation = operatorSpinner.selectedItem.toString()

            val result: Double? = when(operation){

                ADD  -> firstNumber + secoundNumber
                Substract  -> firstNumber - secoundNumber
                Multiply  -> firstNumber * secoundNumber
                Division  -> firstNumber / secoundNumber
                else -> null
            }

            resultTextView.text = if(result != null)("Result: $result")else("Invalid Operation")

        }
    }

    private fun setupSpinner() {

        val operators = listOf(ADD, Substract, Multiply, Division)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, operators)

        operatorSpinner.adapter = adapter
    }

    companion object {

        const val ADD = "Add"
        const val Substract = "Substraction"
        const val Multiply = "Multiplication"
        const val Division = "Division"

    }

}

