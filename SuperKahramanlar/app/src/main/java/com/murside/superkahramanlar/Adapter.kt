package com.murside.superkahramanlar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murside.superkahramanlar.databinding.ActivityMainBinding
import com.murside.superkahramanlar.databinding.RecycleRowBinding

class Adapter(val superKahramanList:ArrayList<superKahraman> ):RecyclerView.Adapter<Adapter.superKahramanViewHolder>() {
    class superKahramanViewHolder(val binding: RecycleRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): superKahramanViewHolder {
        val binding=RecycleRowBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return superKahramanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return superKahramanList.size
    }

    override fun onBindViewHolder(holder: superKahramanViewHolder, position: Int) {


        holder.binding.RecycletextView.text=superKahramanList[position].isim
        holder.itemView.setOnClickListener {

            val intent= Intent(holder.itemView.context,MainActivity2::class.java)
           MySingelton.secilensuperKahraman=superKahramanList[position]
            // intent.putExtra("secilenKahraman",superKahramanList[position])
            holder.itemView.context.startActivity(intent)
        }


    }
}