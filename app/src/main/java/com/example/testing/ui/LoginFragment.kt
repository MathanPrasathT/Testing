package com.example.testing.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.testing.R
import com.example.testing.data.EmployeeDatabaseHelper
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    var signinUserName: String = ""
    var signinPassword: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val signinButton: MaterialButton = view.findViewById(R.id.signinButton)

        signinButton.setOnClickListener {

            val editText1: EditText = view.findViewById(R.id.editText1)
            signinUserName = editText1.text.toString()
            val editText2: EditText = view.findViewById(R.id.editText2)
            signinPassword = editText2.text.toString()

            /*  (requireActivity() as MainActivity).arraylist.forEach {

                  if (it.userName.equals(signinUserName) && it.password.equals(signinPassword)) {

                      val displayTextView: TextView = view.findViewById(R.id.displayTextView)
                      displayTextView.text = "SuccessFully"

                  } else {

                      val displayTextView: TextView = view.findViewById(R.id.displayTextView)
                      displayTextView.text = "UserName And Password Wrong"
                  }*/
            val userdata = EmployeeDatabaseHelper.getData(signinUserName, signinPassword)

            if(userdata != null) {
                val displayTextView: TextView = view.findViewById(R.id.displayTextView)
                displayTextView.text = "User signed in successfully ${userdata.userName} ${userdata.password}"
            } else {
                val displayTextView: TextView = view.findViewById(R.id.displayTextView)
                displayTextView.text = "Incorrect username and password"
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}