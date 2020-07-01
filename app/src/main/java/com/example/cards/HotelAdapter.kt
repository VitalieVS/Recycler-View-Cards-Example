package com.example.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*

class HotelAdapter(
    private val hotelList: List<HotelItem>,
    private val clickListener: OnHotelClickListener
) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_example, parent, false)
        return HotelViewHolder(itemView)
    }

    override fun getItemCount() = hotelList.size

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun initialize(item: HotelItem, action: OnHotelClickListener) {
            itemView.hotelTitle.text = item.title
            itemView.hotelDescription.text = item.description
            itemView.hotelImage.setImageResource(item.imageResource)
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.initialize(hotelList[position], clickListener)
    }
}

interface OnHotelClickListener {
    fun onItemClick(item: HotelItem, position: Int)
}