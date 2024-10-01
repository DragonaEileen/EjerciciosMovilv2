package com.ejercicios.ejercicio1_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    companion object {
        lateinit var username: EditText
        lateinit var password: EditText
        var contentView: Int = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeContentView(R.layout.activity_main)
        login()
        Log.d(":::Vida", "Acabo de crear la aplicacion")
        }

    private fun login() {
        //Username
        username = findViewById<EditText>(R.id.usernameEdit)
        //Password
        password = findViewById<EditText>(R.id.editTextTextPassword3)
        //Button
        findViewById<Button>(R.id.enterButton)
            .setOnClickListener {
                if((username.text.toString() == "LaDaniWapa") && password.text.toString() == "LinuxMapache"){
                    val myIntention = Intent(this, HomeActivity::class.java)
                    myIntention.putExtra("username", username.text.toString())
                    startActivity(myIntention)
                    finish()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        Log.d(":::Vida", "Acaba de empezar la aplicacion")
        }
    override fun onResume(){
        super.onResume()
        //Toasty
        if (contentView == R.layout.welcome_view) {
            val text = "Welcome Back, " + username.text
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)
            toast.show()
        }
        Log.d(":::Vida", "La aplicacion continua")
        }
    override fun onPause(){
        super.onPause()
        var lauraPausini = findViewById<LinearLayout>(R.id.PauseLayout)
        lauraPausini.visibility = View.VISIBLE
        findViewById<Button>(R.id.unpauseButton)
            .setOnClickListener {
                lauraPausini.visibility = View.GONE
            }
        Log.d(":::Vida", "Acabo de pausar la aplicacion")
        }
    override fun onStop(){
        super.onStop()
        val text = "Se ha cerrado la sesión de " + username.text
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, text, duration)
        toast.show()
        Log.d(":::Vida", "Acabo de parar la aplicacion")
        }

    private fun changeContentView(view: Int) {
        setContentView(view)
        contentView = view
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(":::Vida", "Acabo de DESTRUIR la aplicacion")
        }

}