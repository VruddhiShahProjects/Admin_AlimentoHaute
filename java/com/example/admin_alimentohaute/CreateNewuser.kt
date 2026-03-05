package com.example.admin_alimentohaute

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateNewuser : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonCreateUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_newuser)

        editTextUsername = findViewById(R.id.Name)
        editTextEmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.Password)
        buttonCreateUser = findViewById(R.id.createUserButton)

        buttonCreateUser.setOnClickListener {
            // Get user input
            val username = editTextUsername.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Check if any field is empty
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@CreateNewuser, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Perform your user creation logic here
            // For this example, we'll just display a Toast message
            val message = "User created: $username\nEmail: $email"
            Toast.makeText(this@CreateNewuser, message, Toast.LENGTH_SHORT).show()

            // Redirect to main page
            val intent = Intent(this@CreateNewuser, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Close this activity to prevent going back to it using the back button
        }
    }
}
