package com.ejercicios.ejercicio1_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val username = intent.getStringExtra("username")
        var welcomeLabel = findViewById<TextView>(R.id.welcomeText)
        welcomeLabel.text = welcomeLabel.text.toString() + username
        toCalculator(username.toString())
        }

    private fun toCalculator(username:String) {
        findViewById<Button>(R.id.calculatorButton)
            .setOnClickListener {
                var myIntention = Intent(this, CalculatorActivity::class.java)
                myIntention.putExtra("username", username)
                startActivity(myIntention)
            }
    }

}