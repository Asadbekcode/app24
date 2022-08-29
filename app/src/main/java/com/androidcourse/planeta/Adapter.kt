package com.androidcourse.planeta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import android.content.Intent as Intent1

class Adapter(var planet:List<PlanetData>): RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title=view.title
        var planetimg=view.planet_img
        var galaxy =view.galaxy
        var distance=view.distance
        var gravity=view.gravity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.view,parent,false)

        return  myViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage:Int?=null
        holder.itemView.setOnClickListener{
            val intent= Intent1(holder.itemView.context,PlanetDetail::class.java)

            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text=planet[position].title
        holder.galaxy.text=planet[position].galaxy
        holder.distance.text=planet[position].distance+"m km"
        holder.gravity.text=planet[position].gravity+"m/ss"

        when(planet[position].title!!.toLowerCase()){

            "mars"->{
                dummyImage=R.drawable.mars
            }"earth"->{
            dummyImage=R.drawable.mars
        }"nepture"->{
            dummyImage=R.drawable.mars
        }"moon"->{
            dummyImage=R.drawable.mars
        }"sun"->{
            dummyImage=R.drawable.mars
        }"saturn"->{
            dummyImage=R.drawable.mars
        }"yupiter"->{
            dummyImage=R.drawable.mars
        }"uran"->{
            dummyImage=R.drawable.mars
        }
        }


            holder.planetimg.setImageResource(dummyImage!!)

    }


    override fun getItemCount(): Int {

        return planet.size
    }


}

