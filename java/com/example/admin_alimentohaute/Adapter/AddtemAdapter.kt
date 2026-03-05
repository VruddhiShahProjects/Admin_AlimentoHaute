package com.example.admin_alimentohaute.Adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.admin_alimentohaute.databinding.ItemItemBinding

class AddtemAdapter(private val MenuItemName:ArrayList<String>, private val MenuItemPrice:ArrayList<String>, private val MenuItemImage:ArrayList<Int>) : RecyclerView.Adapter<AddtemAdapter.AddItemViewHolder>() {
    private val itemQuantities = IntArray(MenuItemName.size) { 1 }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemName.size


    inner class AddItemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantityq = itemQuantities[position]
                foodnametext.text = MenuItemName[position]
                Foodprice.text = MenuItemPrice[position]
                foodImageView.setImageResource(MenuItemImage[position])
                quantity.text =quantity.toString()


                minusbtn.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusbtn.setOnClickListener {
                    increaseQuantity(position)
                }
                trash.setOnClickListener {
                    deleteQuantity(position)
                }

            }

        }


        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.quantity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.quantity.text = itemQuantities[position].toString()
            }        }

        private fun deleteQuantity(position: Int) {
            MenuItemName.removeAt(position)
            MenuItemName.removeAt(position)
            MenuItemName.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,MenuItemName.size)

        }
        }


    }
