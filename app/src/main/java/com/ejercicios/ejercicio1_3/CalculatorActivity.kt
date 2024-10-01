package com.ejercicios.ejercicio1_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ejercicios.ejercicio1_3.MainActivity.Companion.username

class CalculatorActivity : AppCompatActivity() {
    companion object{
        lateinit var firstFactor : String
        lateinit var secondFactor : String
        lateinit var result : String
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        addFunction()
        subtractFunction()
        multiplyFunction()
        divideFunction()
        val username = intent.getStringExtra("username")
        var calculatorLabel = findViewById<TextView>(R.id.calculatorLabel)
        calculatorLabel.text = calculatorLabel.text.toString() + username

        findViewById<Button>(R.id.backButton)
            .setOnClickListener{
                val backIngham = Intent(this, MainActivity::class.java)
                startActivity(backIngham)
            }
    }

    private fun getFactors() {
        firstFactor = findViewById<EditText>(R.id.firstFactorEdit).text.toString()
        secondFactor = findViewById<EditText>(R.id.secondFactorEdit).text.toString()
    }

    private fun addFunction() {
        findViewById<Button>(R.id.addButton)
            .setOnClickListener {
                getFactors()
                result = (firstFactor.toInt() + secondFactor.toInt()).toString()
                Log.d(":::Operando", firstFactor)
                updateResult()
            }
    }

    private fun subtractFunction() {
        findViewById<Button>(R.id.subtractButton)
            .setOnClickListener {
                getFactors()
                result = (firstFactor.toInt() - secondFactor.toInt()).toString()
                updateResult()
            }
    }

    private fun multiplyFunction() {
        findViewById<Button>(R.id.multiplyButton)
            .setOnClickListener {
                getFactors()
                result = (firstFactor.toInt() * secondFactor.toInt()).toString()
                updateResult()
            }
    }

    private fun divideFunction() {
        findViewById<Button>(R.id.divideButton)
            .setOnClickListener {
                getFactors()
                if(secondFactor.toInt() != 0) {
                    result = (firstFactor.toInt() / secondFactor.toInt()).toString()
                    updateResult()
                }else{
                    val text = "We can't divide by zero"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this, text, duration)
                    toast.show()
                }
            }
    }

    private fun updateResult(){
        findViewById<TextView>(R.id.resultLabel).text = Companion.result
    }

    }
