package com.feetconnect.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.feetconnect.R
import com.feetconnect.replaceFragment

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    // Create the view fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Define the variable with id layout
        val act = activity as AppCompatActivity
        val btn_connect: Button = view.findViewById(R.id.btn_connect)
        val btn_clear: Button = view.findViewById(R.id.btn_clear)
        val edit_email: EditText = view.findViewById(R.id.edit_email)
        val edit_password: EditText = view.findViewById(R.id.edit_password)

        // Define the functions
        btn_connect.setOnClickListener() {
            Toast.makeText(context, edit_email.getText(), Toast.LENGTH_SHORT).show()
            act.replaceFragment(MainFragment())
        }

        btn_clear.setOnClickListener(){
            edit_email.text.clear()
            edit_password.text.clear()
            edit_email.requestFocus()
        }

        // Return the view
        return view
    }


}
