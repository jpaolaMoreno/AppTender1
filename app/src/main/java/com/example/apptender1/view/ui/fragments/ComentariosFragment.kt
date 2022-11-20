package com.example.apptender1.view.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apptender1.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class comentariosFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_comentarios, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm = view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> findNavController().navigate(R.id.action_comentariosFragment_to_homeFragment)
                R.id.perfil -> findNavController().navigate(R.id.action_comentariosFragment_to_misdatosFragment)
                R.id.carro -> findNavController().navigate(R.id.action_comentariosFragment_to_comprasFragment)
            }
        }

    }

}
