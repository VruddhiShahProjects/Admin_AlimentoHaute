package com.example.admin_alimentohaute

import android.net.Uri

object ItemRepository {
    val itemList: MutableList<Item> = mutableListOf()
}

data class Item(val name: String, val price: String, val imageUri: Uri?)
