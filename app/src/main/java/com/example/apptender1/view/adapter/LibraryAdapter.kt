package com.example.apptender1.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.apptender1.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class LibraryAdapter: RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    override fun onCreateViewHolder (viewGroup: ViewGroup, i: Int): ViewHolder {

        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.car_view_librery, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        var itemImagen: ImageView
        var itemTitle:  TextView
        var itemprecio: TextView
        var itemCaract: TextView

        init{
            itemImagen=ItemView.findViewById(R.id.image)
            itemTitle=ItemView.findViewById(R.id.tittle)
            itemprecio=ItemView.findViewById(R.id.precio)
            itemCaract=ItemView.findViewById(R.id.comentprod)
        }
    }

    val titles= arrayOf("Banano","Manzana","Mango", "Guanabana","Brocoli", "Tomates")
    val precio= arrayOf("$3.500","$7.800","$5.400", "$8.500","$1.500","$2.500")
    val image= arrayOf(R.drawable.banano, R.drawable.manzanas, R.drawable.mango, R.drawable.guanabana, R.drawable.brocoli, R.drawable.tomates)
    val caract= arrayOf("Precio por kilo","Precio por kilo","Precio por kilo","Precio por kilo","Precio por kilo")

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemprecio.text=precio[i]
        viewHolder.itemImagen.setImageResource(image[i])
        viewHolder.itemCaract.text=caract[i]
    }

    override fun getItemCount(): Int {
        return titles.size

            }
}