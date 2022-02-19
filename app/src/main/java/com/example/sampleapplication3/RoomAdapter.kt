package com.example.sampleapplication3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RoomAdapter(
    private val isByRoom: Boolean
) : RecyclerView.Adapter<RoomAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = if (isByRoom) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_room, parent, false)
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rates, parent, false)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return 5
    }
}
