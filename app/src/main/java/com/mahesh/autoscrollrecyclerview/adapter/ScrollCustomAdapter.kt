package com.mahesh.autoscrollrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.mahesh.autoscrollrecyclerview.R
import com.mahesh.autoscrollrecyclerview.model.Fruit

import java.util.ArrayList

abstract class ScrollCustomAdapter(ctx: Context,
                                   private val imageModelArrayList: ArrayList<Fruit>) :
    RecyclerView.Adapter<ScrollCustomAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater

    val onItemClickListener: AdapterView.OnItemClickListener
        get() = onItemClickListener

    init {
        inflater = LayoutInflater.from(ctx)
    }


    abstract fun load()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrollCustomAdapter.MyViewHolder {

        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScrollCustomAdapter.MyViewHolder, position: Int) {

        holder.iv.setImageResource(imageModelArrayList[position].imgRes)
        holder.time.setText(imageModelArrayList[position].name)

    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: TextView
        var iv: ImageView

        init {
            time = itemView.findViewById(R.id.txtName) as TextView
            iv = itemView.findViewById(R.id.imageView) as ImageView
        }

    }
}
