package com.mahesh.autoscrollrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mahesh.autoscrollrecyclerview.R
import com.mahesh.autoscrollrecyclerview.model.Fruit
import java.util.*

abstract class FruitAdapter(var context: Context, var imageArrayList: ArrayList<Fruit>?) :
    RecyclerView.Adapter<FruitAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater? = null

    public abstract fun loadItems(): Unit

    override fun getItemCount(): Int {
        return imageArrayList?.size!!
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {
        val view = inflater?.inflate(R.layout.recycler_item, viewGroup, false)
        return FruitAdapter.MyViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        var fruit: Fruit? = imageArrayList?.get(holder.adapterPosition)

        fruit?.name.let { holder.txtName?.setText(it)}
        fruit?.imgRes?.let { holder.imageView?.setImageResource(it) }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView? = null
        var imageView: ImageView? = null

        init {
            txtName = itemView.findViewById(R.id.txtName)
            imageView = itemView.findViewById(R.id.imageView)
        }

    }
}