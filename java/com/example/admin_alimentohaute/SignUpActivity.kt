package com.example.admin_alimentohaute

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.admin_alimentohaute.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var userName: String
    private lateinit var nameOfRestaurant: String
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.createAccount.setOnClickListener {
            signUp()
        }

        binding.alreadyhaveaccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val locationList = arrayOf("Ahmedabad", "Maharashtra", "Madhya Pradesh", "Delhi")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        binding.ListOfLocation.setAdapter(adapter)
    }

    private fun signUp() {

        email = binding.editTextTextEmailAddress.text.toString().trim()
        password = binding.editTextTextPassword.text.toString().trim()
        userName = binding.editTextTextPersonName.text.toString().trim()
        nameOfRestaurant = binding.ResturantName.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty() && userName.isNotEmpty() && nameOfRestaurant.isNotEmpty()) {
            // Save user data to SQLite database
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(DatabaseHelper.COLUMN_EMAIL, email)
                put(DatabaseHelper.COLUMN_PASSWORD, password)
                put(DatabaseHelper.COLUMN_USERNAME, userName)
                put(DatabaseHelper.COLUMN_RESTAURANT_NAME, nameOfRestaurant)
            }

            db.insert(DatabaseHelper.TABLE_NAME, null, values)
            db.close()

            // Redirect to the main activity or any other desired activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        }
    }
}
