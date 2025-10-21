package com.example.recyclerviewbasic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasic.R
import com.example.recyclerviewbasic.model.Sword
import com.example.recyclerviewbasic.view_holder.SwordViewHolder

class SwordAdapter(private val dataSet: List<Sword>,private val onClick: (Sword) -> Unit) : RecyclerView.Adapter<SwordViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SwordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_sword, parent, false)
        return SwordViewHolder(layoutInflater, onClick)
    }

    override fun onBindViewHolder(holder: SwordViewHolder, position: Int) {
        val topic = dataSet[position]
        holder.build(topic,onClick)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}