package com.example.realprojectandroidpertama

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Adapter(private val dataList: ArrayList<Game>): RecyclerView.Adapter<Adapter.ViewHolderClass>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.logo)
        holder.rvTitle.text = currentItem.judul
        holder.rvSinopsis.text = currentItem.sinopsis
        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailPageActivity::class.java)

            intent.putExtra(MainActivity.INTENT_PARCELABLE, currentItem)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.logo)
        val rvTitle:TextView = itemView.findViewById(R.id.title)
        val rvSinopsis:TextView = itemView.findViewById(R.id.sinopsis)

    }

}
