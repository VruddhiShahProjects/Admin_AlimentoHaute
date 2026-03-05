package com.example.admin_alimentohaute

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.admin_alimentohaute.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {
    private val binding: ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.selectimage.setOnClickListener {
            pickImage.launch("image/*")
        }
        binding.backButton.setOnClickListener {
            finish()
        }

        binding.AdditemButton.setOnClickListener {
            if (isValidInput()) {
                // Perform the action to add the item (you can replace this with your logic)
                showSuccessMessage()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidInput(): Boolean {
        // Perform validation for each input field
        val itemName = binding.enterFoodName.text.toString().trim()
        val itemPrice = binding.enterFoodPrice.text.toString().trim()

        return itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemPrice.isNotEmpty()
    }

    private fun showSuccessMessage() {
        Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show()
        // You can add further actions here if needed
        finish() // Finish the activity after success
    }

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                binding.selectedImage.setImageURI(uri)
            }
        }
}
