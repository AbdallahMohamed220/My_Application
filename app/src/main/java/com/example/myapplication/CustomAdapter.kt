package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val array: ArrayList<Person>):RecyclerView.Adapter<CustomAdapter.DataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
      return  DataHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false))

      }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val person:Person=array[position]
        holder.image.setImageResource(person.image)
        holder.name.text=person.name
        holder.des.text=person.des

    }
    override fun getItemCount(): Int {
    return  array.size
    }

    class DataHolder(view: View):RecyclerView.ViewHolder(view){

        val name:TextView = view.findViewById(R.id.TvTitle)
        val des:TextView = view.findViewById(R.id.TvDes)
        val image:ImageView = view.findViewById(R.id.Iv)

    }
}