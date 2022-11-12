package com.example.apptender1.view.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender1.R
import com.example.apptender1.view.adapter.LibraryAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView


class tiendaFragment : Fragment() {

    lateinit var recyclerLib: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_tienda, container, false)
        recyclerLib=view.findViewById(R.id.recyclerview)
        val adapter=LibraryAdapter()
        recyclerLib.layoutManager=LinearLayoutManager(context)
        recyclerLib.adapter=adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm=view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId){
                R.id.home -> findNavController().navigate(R.id.action_tiendaFragment_to_homeFragment)
                R.id.perfil ->findNavController().navigate(R.id.action_tiendaFragment_to_misdatosFragment)
                R.id.carro ->findNavController().navigate(R.id.action_tiendaFragment_to_mipedidoFragment)
            }
        }

    }


    }

