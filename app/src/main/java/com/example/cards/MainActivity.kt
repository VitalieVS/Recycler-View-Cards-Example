package com.example.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateList(20)
        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }
    private fun generateList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_foreground
            }
            val item = ExampleItem(drawable, "item $i", "Random description $i")
            list += item
        }
        return list
    }
}