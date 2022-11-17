package com.example.apptender1.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.apptender1.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    lateinit var registrarbutton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        firebaseAuth= Firebase.auth
        registrarbutton = findViewById(R.id.BRegistrar)
        val correo=findViewById<EditText>(R.id.registreEmail)
        val contrasena=findViewById<EditText>(R.id.registreContraseña)
        val telefono=findViewById<EditText>(R.id.registreNumero)
        val nombre=findViewById<EditText>(R.id.registreNombre)

        registrarbutton.setOnClickListener {
            crearcuenta(correo.text.toString(), contrasena.text.toString())
        }

        }
        private fun crearcuenta(correo:String, contrasena:String){

            firebaseAuth.createUserWithEmailAndPassword(correo,contrasena)
                .addOnCompleteListener(this) {
                    Task-> if(Task.isSuccessful){
                        Toast.makeText(baseContext,"Cuenta Creada", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, HomeActivity::class.java))
                }else{
                    Toast.makeText(baseContext, "Error creación", Toast.LENGTH_SHORT).show()
                }
        }

    }

}