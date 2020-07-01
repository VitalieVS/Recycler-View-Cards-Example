package com.example.cards

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnHotelClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = generateList(20)
        recycler_view.adapter = HotelAdapter(exampleList, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(item: HotelItem, position: Int) {
        val intent = Intent(applicationContext, ViewCard::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("title", item.title)
        intent.putExtra("description", item.description)
        intent.putExtra("resId", item.imageResource);
        applicationContext.startActivity(intent)
    }

    private fun generateList(size: Int): List<HotelItem> {
        val list = ArrayList<HotelItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_foreground
            }
            val item = HotelItem(drawable, "Hotel $i", "Descrierea hotelului $i")
            list += item
        }
        return list
    }
}



