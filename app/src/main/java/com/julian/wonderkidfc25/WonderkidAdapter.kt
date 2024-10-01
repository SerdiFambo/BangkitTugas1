package com.julian.wonderkidfc25

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WonderkidAdapter (private val context: Context, private val wonderkid: List<Wonderkid>, val listener: (Wonderkid) -> Unit)
    : RecyclerView.Adapter<WonderkidAdapter.WonderkidViewHolder>() {

    class WonderkidViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgWonderkid: ImageView = view.findViewById(R.id.img_item_photo)
        val nameWonderkid: TextView = view.findViewById(R.id.rv_item_name)
        val descWonderkid: TextView = view.findViewById(R.id.rv_item_description)

        fun bindView(wonderkid: Wonderkid, listener: (Wonderkid) -> Unit) {
            imgWonderkid.setImageResource(wonderkid.imgWonderkid)
            nameWonderkid.text = wonderkid.nameWonderkid

            // Check if descWonderkid is not null and join it into a single string
            descWonderkid.text = (wonderkid.descWonderkid ?: arrayOf("Deskripsi tidak tersedia")).joinToString("\n")

            itemView.setOnClickListener {
                listener(wonderkid)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WonderkidViewHolder {
        return  WonderkidViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_wonderkid, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WonderkidViewHolder, position: Int) {
        holder.bindView(wonderkid[position], listener)
    }

    override fun getItemCount(): Int = wonderkid.size
}