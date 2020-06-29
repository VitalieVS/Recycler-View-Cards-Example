package com.example.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*

class ExampleAdapter(private val exampleList: List<ExampleItem>, private var clickListener : OnExampleClickListener) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_example, parent, false)
       return ExampleViewHolder(itemView)
    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var imageView: ImageView = itemView.image_view
        private var textView1: TextView = itemView.text_view_1
        private var textView2: TextView = itemView.text_view_2

        fun initialize(item: ExampleItem, action:OnExampleClickListener) {
            textView1.text = item.text1
            textView2.text = item.text2
            imageView.setImageResource(item.imageResource)
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }

    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
         holder.initialize(exampleList[position], clickListener)
    }
}

interface OnExampleClickListener {
    fun onItemClick(item: ExampleItem, position: Int)
}