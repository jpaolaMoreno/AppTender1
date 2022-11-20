package com.example.apptender1.view.ui.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender1.R
import com.example.apptender1.model.compras
import com.example.apptender1.view.adapter.ComprasAdapter
import com.example.apptender1.view.adapter.OnComprasItemClickListener
import com.example.apptender1.viewmodel.ComprasViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

//

class ComprasFragment : Fragment(), OnComprasItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComprasAdapter
    val database: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var precioT:TextView
    lateinit var compraT:TextView
    private val viewModel by lazy { ViewModelProvider(this).get(ComprasViewModel::class.java) }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compras, container, false)
        recyclerView = view.findViewById(R.id.recyclerviewcompra)
        precioT=view.findViewById(R.id.preciototal)
        compraT=view.findViewById(R.id.realizar)
        adapter = ComprasAdapter(requireContext(), this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        observeData()
        preciototal()
        compraT.setOnClickListener {
            realizarcompra()
        }
        return view
    }

    private fun observeData() {
        viewModel.fetchComprasData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun preciototal() {
        database.collection("compras")
            .get()
            .addOnSuccessListener {
                result ->
                val preciounitario = mutableListOf<String>()
                for (document in result) {
                    val precio = document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciototal =  preciounitario.mapNotNull { it.toIntOrNull() }.sum()
                precioT.setText(Integer.toString(preciototal))
            }
        }
    private fun realizarcompra(){
        val builder=AlertDialog.Builder(requireContext())
        builder.setTitle("compraApptender")
        builder.setMessage("¿Desea realizar esta compra?")
        builder.setPositiveButton("Aceptar"){
            dialog, which ->
            findNavController().navigate(R.id.action_comprasFragment_to_homeFragment)

    }
        builder.setNegativeButton("Cancelar", null)
        builder.show()


    }

    override fun onItemclick(fruta: compras, position: Int) {
        database.collection("compras")
            .document(fruta.titulo)
            .delete()

    }
}


