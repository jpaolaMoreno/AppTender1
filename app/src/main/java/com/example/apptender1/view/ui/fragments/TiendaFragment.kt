package com.example.apptender1.view.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender1.R
import com.example.apptender1.model.frutas
import com.example.apptender1.view.adapter.LibraryAdapter
import com.example.apptender1.view.adapter.OnBookItemClickListener
import com.example.apptender1.viewmodel.LibraryViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class tiendaFragment : Fragment(), OnBookItemClickListener {

    lateinit var recyclerLib: RecyclerView
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var adapter: LibraryAdapter
    val database:FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewmodel by lazy{ViewModelProvider(this).get(LibraryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth= Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_tienda, container, false)
        recyclerLib=view.findViewById(R.id.recyclerview)
        adapter=LibraryAdapter(requireContext(), this)
        recyclerLib.layoutManager=LinearLayoutManager(context)
        recyclerLib.adapter=adapter
        observeData()
        return view
    }
    fun observeData(){
        viewmodel.libraryData().observe(viewLifecycleOwner, Observer{
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm=view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId){
                R.id.home -> findNavController().navigate(R.id.action_tiendaFragment_to_homeFragment)
                R.id.perfil ->findNavController().navigate(R.id.action_tiendaFragment_to_misdatosFragment)
                R.id.carro ->findNavController().navigate(R.id.action_tiendaFragment_to_comprasFragment)
                R.id.cerrarsesion ->{
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.action_tiendaFragment_to_loginActivity)
                    true
                }

            }
        }

    }

    override fun onItemclick(fruta: frutas, position: Int) {
        val titulo:String= fruta.titulo
        val precio:String= fruta.precio
        val image:String=fruta.image
        val descripcion:String=fruta.descripcion
        val dato= hashMapOf(
            "titulo" to titulo,
            "precio" to precio,
            "image" to image,
            "descripcion" to descripcion,
        )
        database.collection("compras")
            .document(titulo)
            .set(dato)
            .addOnSuccessListener {
                Toast.makeText(context,"El producto fue añadido a tu canasta", Toast.LENGTH_SHORT).show()
            }

    }


}

