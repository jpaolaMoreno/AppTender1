package com.example.apptender1.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apptender1.model.compras
import com.example.apptender1.model.frutas
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class repo {
    fun getlibraryData(): LiveData<MutableList<frutas>> {
        val mutabledata = MutableLiveData<MutableList<frutas>>()

        FirebaseFirestore.getInstance().collection("frutas").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<frutas>()
                for (document in result) {
                    val titulo = document.getString("titulo")
                    val precio = document.getString("precio")
                    val image = document.getString("image")
                    val descripcion = document.getString("descripcion")
                    val fruta = frutas(titulo!!, precio!!, image!!, descripcion!!)
                    listData.add(fruta)
                }
                mutabledata.value = listData
            }
        return mutabledata
    }

    fun getComprasData(): LiveData<MutableList<compras>> {
        val mutabledata = MutableLiveData<MutableList<compras>>()
        FirebaseFirestore.getInstance().collection("compras")
            .get().addOnSuccessListener { result ->
                val listData = mutableListOf<compras>()
                for (document in result) {
                    val titulo = document.getString("titulo")
                    val precio = document.getString("precio")
                    val image = document.getString("image")
                    val descripcion = document.getString("descripcion")
                    val compra = compras(titulo!!, precio!!, image!!, descripcion!!)
                    listData.add(compra)
                }
                mutabledata.value = listData
            }
        return mutabledata
    }
}