package com.example.testing.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.R
import com.example.testing.domain.UserData
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    val arraylist = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val  button1 : MaterialButton =  findViewById(R.id.button1)

       // val textview1 : TextView = findViewById(R.id.textview1)
        button1.setOnClickListener {

            supportFragmentManager.beginTransaction().add(
                R.id.containerView,
                LoginFragment.newInstance(),"LoginFragment").addToBackStack("LoginFragment").commit()
        }

        val  button2 : MaterialButton =  findViewById(R.id.button2)

        button2.setOnClickListener {

            supportFragmentManager.beginTransaction().add(
                R.id.containerView,
                RegisterFragment.newInstance(),"RegisterFragement").addToBackStack("RegisterFragment").commit()
        }

      //  supportFragmentManager.beginTransaction().add(R.id.initial,LoginFragment.newInstance(),"LoginFragment").addToBackStack("LoginFragment").commit()
    }
}