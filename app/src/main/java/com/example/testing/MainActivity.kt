package com.example.testing

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val  button1 : MaterialButton =  findViewById(R.id.button1)

       // val textview1 : TextView = findViewById(R.id.textview1)
        button1.setOnClickListener {

            supportFragmentManager.beginTransaction().add(R.id.containerview,LoginFragment.newInstance(),"LoginFragment").addToBackStack("LoginFragment").commit()
        }

        val  button2 : MaterialButton =  findViewById(R.id.button2)

        button2.setOnClickListener {

            supportFragmentManager.beginTransaction().add(R.id.containerview,RegisterFragment.newInstance(),"RegisterFragement").addToBackStack("RegisterFragment").commit()
        }

      //  supportFragmentManager.beginTransaction().add(R.id.initial,LoginFragment.newInstance(),"LoginFragment").addToBackStack("LoginFragment").commit()
    }
}