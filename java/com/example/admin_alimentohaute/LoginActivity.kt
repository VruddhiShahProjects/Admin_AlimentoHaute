package com.example.admin_alimentohaute


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.admin_alimentohaute.databinding.ActivityLoginBinding
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var email: String
    private lateinit var password: String

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.loginbutton.setOnClickListener {
            login()
        }

        binding.donthaveaccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        email = binding.editTextTextEmailAddress.text.toString().trim()
        password = binding.editTextTextPassword.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            val db = dbHelper.readableDatabase
            val selectionArgs = arrayOf(email, password)

            val cursor = db.query(
                DatabaseHelper.TABLE_NAME,
                null,
                "${DatabaseHelper.COLUMN_EMAIL} = ? AND ${DatabaseHelper.COLUMN_PASSWORD} = ?",
                selectionArgs,
                null,
                null,
                null
            )

            if (cursor.moveToFirst()) {
                Toast.makeText(this, "Logined succesfully", Toast.LENGTH_SHORT).show()

                // Login successful
                cursor.close()
                db.close()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login failed
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
        }
    }
}
