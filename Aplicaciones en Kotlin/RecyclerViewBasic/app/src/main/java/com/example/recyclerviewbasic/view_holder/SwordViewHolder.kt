package com.example.recyclerviewbasic.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasic.R
import com.example.recyclerviewbasic.model.Sword

class SwordViewHolder(view: View, private val onClick: (Sword) -> Unit) : RecyclerView.ViewHolder(view) {
    private val txViewName = view.findViewById<TextView>(R.id.tx_view_name)
    private val txViewOrigin = view.findViewById<TextView>(R.id.tx_view_origin)
    private val txViewDamage = view.findViewById<TextView>(R.id.tx_view_damage)
    private val imgSword = view.findViewById<ImageView>(R.id.img_sword)


    fun build(sword: Sword, onClick: (Sword) -> Unit) {
        txViewName.text = sword.name
        txViewOrigin.text = sword.origin
        txViewDamage.text = sword.damage.toString()
        imgSword.setImageResource(sword.image)
        itemView.setOnClickListener {
            onClick(sword)
        }
    }
}