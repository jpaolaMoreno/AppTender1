package com.example.apptender1.view.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageView
import android.widget.TextView
import com.example.apptender1.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apptender1.model.frutas
import com.squareup.picasso.Picasso

class LibraryAdapter(private val context:Context):RecyclerView.Adapter<LibraryAdapter.ViewHolder>(){

    private var frutaslista= mutableListOf<frutas>()

    fun setListData(data:MutableList<frutas>){
        frutaslista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.car_view_librery, viewGroup, false)
        return ViewHolder(v)

    }

    inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        fun binWew(fruta: frutas) {

            itemView.findViewById<TextView>(R.id.tittle).text = fruta.titulo
            itemView.findViewById<TextView>(R.id.precio).text = fruta.precio
            Picasso.with(context).load(fruta.image).into(itemView.findViewById<ImageView>(R.id.image))
            itemView.findViewById<TextView>(R.id.descripcion).text = fruta.descripcion
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val fruta=frutaslista[i]
        viewHolder.binWew(fruta)
    }

    override fun getItemCount(): Int {
        return if(frutaslista.size >0){
         frutaslista.size
        }else{
            0
        }

    }
}


