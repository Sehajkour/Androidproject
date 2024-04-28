package com.example.sk

// Inside your LoginFragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {
    // Define the SharedPreferences file name
    private val PREFS_NAME = "MyPrefsFile"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Get reference to SharedPreferences
        val sharedPrefs = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Assuming you have EditTexts for email and password
        val email = view.findViewById(R.id.et_email) as EditText
        val password = view.findViewById(R.id.et_password) as EditText

        // Assuming you have a button for login
        val loginButton = view.findViewById<Button>(R.id.btn_login)

        loginButton.setOnClickListener {
            // Retrieve user input
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            // Retrieve stored email and password from SharedPreferences
            val storedEmail = sharedPrefs?.getString("email", "")
            val storedPassword = sharedPrefs?.getString("password", "")

            // Check if the entered credentials match the stored ones
            if (emailText == storedEmail && passwordText == storedPassword) {
                if (!emailText.endsWith("@gmail.com")) {
                    Toast.makeText(activity, "Please enter a valid Gmail address", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(activity, "No account found", Toast.LENGTH_SHORT).show()
            }
        }

        return view
}}