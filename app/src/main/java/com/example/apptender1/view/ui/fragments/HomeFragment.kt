package com.example.apptender1.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.apptender1.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardLib = view.findViewById<ImageView>(R.id.cardTienda)
        cardLib.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tiendaFragment)

        }
        val cardComent = view.findViewById<ImageView>(R.id.cardcomentario)
        cardComent.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_comentariosFragment)
        }
        val cardajust = view.findViewById<ImageView>(R.id.cardAjuste)
        cardajust.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ajustesFragment)

        }
        val cardpedido = view.findViewById<ImageView>(R.id.cardCarro)
        cardpedido.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_comprasFragment)

        }
        val cardatos = view.findViewById<ImageView>(R.id.cardDatos)
        cardatos.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_misdatosFragment)

        }
        val cardmap = view.findViewById<ImageView>(R.id.cardmap)
        cardmap.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapaFragment)

        }
    }
}