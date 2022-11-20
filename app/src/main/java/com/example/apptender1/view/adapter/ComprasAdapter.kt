package com.example.apptender1.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender1.R
import com.example.apptender1.model.compras
import com.example.apptender1.model.frutas
import com.squareup.picasso.Picasso

class ComprasAdapter(private val context: Context, var clickListener: OnComprasItemClickListener):
    RecyclerView.Adapter<ComprasAdapter.ViewHolder>(){

    private var frutaslista= mutableListOf<compras>()

    fun setListData(data:MutableList<compras>){
        frutaslista=data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v= LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_compras, viewGroup, false)
        return ViewHolder(v)

    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        fun binWew(fruta: compras, action: OnComprasItemClickListener) {

            itemView.findViewById<TextView>(R.id.tittle).text = fruta.titulo
            itemView.findViewById<TextView>(R.id.precio).text = fruta.precio
            Picasso.with(context).load(fruta.image).into(itemView.findViewById<ImageView>(R.id.image))
            itemView.findViewById<TextView>(R.id.descripcion).text = fruta.descripcion
            val btneliminar=itemView.findViewById<ImageButton>(R.id.eliminar)
            btneliminar.setOnClickListener {
                action.onItemclick(fruta, adapterPosition)
            }

        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val fruta=frutaslista[i]
        viewHolder.binWew(fruta,clickListener)
    }

    override fun getItemCount(): Int {
        return if(frutaslista.size >0){
            frutaslista.size
        }else{
            0
        }

    }
}

interface OnComprasItemClickListener{
    fun onItemclick(fruta: compras, position: Int)
}
