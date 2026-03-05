package com.example.admin_alimentohaute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.admin_alimentohaute.Adapter.DeliveryAdapter
import com.example.admin_alimentohaute.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private val binding:ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
            }
        val customerName = arrayListOf(
            "Vruddhi Shah",
            "Mann Choksi",
            "Jainam Shah",
        )
        val moneyStatus = arrayListOf(
            "received",
            "notReceived",
            "Pending",
        )
        val adapter=DeliveryAdapter(customerName,moneyStatus)
        binding.deliveryRecyclerView.adapter=adapter
        binding.deliveryRecyclerView.layoutManager= LinearLayoutManager(this)

    }
}