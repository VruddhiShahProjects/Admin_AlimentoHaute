package com.example.admin_alimentohaute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.admin_alimentohaute.Adapter.AddtemAdapter
import com.example.admin_alimentohaute.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding:ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val menuFoodName = listOf("Pizza","pasta","Burger","Waffle","momo")
        val menuItemPrice = listOf("₹200","₹250","₹50","₹80","₹100")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.wafflw,
            R.drawable.menu4
        )
        binding.backButton.setOnClickListener {
            finish()
        }
        val adapter = AddtemAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage))
        binding.MenuRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.MenuRecyclerView.adapter=adapter
    }

}