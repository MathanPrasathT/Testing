package com.example.testing.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.testing.R
import com.example.testing.data.EmployeeDatabaseHelper
import com.example.testing.domain.UserData
import com.google.android.material.button.MaterialButton


class RegisterFragment : Fragment() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signupsubmitbutton : MaterialButton = view.findViewById(R.id.signupSubmitButton)

        signupsubmitbutton.setOnClickListener{

            val userData : UserData

            val userNameEditText : EditText = view.findViewById(R.id.userNameEditText)
            val userName = userNameEditText.text.toString()
            val passwordEditText : EditText = view.findViewById(R.id.passwordEditText)
            val password = passwordEditText.text.toString()
            val emailEditText : EditText = view.findViewById(R.id.emailEditText)
            val email = emailEditText.text.toString()
            val numberEditText : EditText = view.findViewById(R.id.numberEditText)
            val number = numberEditText.text.toString()

            userData = UserData(userName,password,email,number)

            //(requireActivity() as MainActivity).arraylist.add(userData)

            EmployeeDatabaseHelper.createSQLiteHelper(requireContext()) //create a table
            EmployeeDatabaseHelper.insertData(userData)
        }
    }
/*
    private fun UserData(userName: Editable?): UserData {

    }*/

    companion object {

        @JvmStatic
        fun newInstance() = RegisterFragment()
                }

    }

