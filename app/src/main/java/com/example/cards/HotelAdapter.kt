package com.example.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*

class HotelAdapter(private val exampleList: List<HotelItem>, private var clickListener
    : OnExampleClickListener) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_example, parent, false)
       return HotelViewHolder(itemView)
    }

    override fun getItemCount() = exampleList.size

    class HotelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var photo: ImageView = itemView.hotelImage
        private var titleText: TextView = itemView.hotelTitle
        private var descriptionText: TextView = itemView.hotelDescription

        fun initialize(item: HotelItem, action:OnExampleClickListener) {
            titleText.text = item.title
            descriptionText.text = item.description
            photo.setImageResource(item.imageResource)
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }

    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
         holder.initialize(exampleList[position], clickListener)
    }
}

interface OnExampleClickListener {
    fun onItemClick(item: HotelItem, position: Int)
}