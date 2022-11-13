package com.example.apptender1.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.apptender1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

        lateinit var iniciobutton: Button
        lateinit var registrobutton: Button
        lateinit var recuperarbutton: TextView

        private lateinit var firebaseAuth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            firebaseAuth= Firebase.auth

            iniciobutton = findViewById(R.id.BInicio)
            registrobutton = findViewById(R.id.BRegistro)
            recuperarbutton = findViewById(R.id.BRecuperar)

            val correo=findViewById<EditText>(R.id.LoginCorreo)
            val contrasena=findViewById<EditText>(R.id.LoginContrasena)

            iniciobutton.setOnClickListener {
                login(correo.text.toString(), contrasena.text.toString())

            }

            registrobutton.setOnClickListener {
                startActivity(Intent( this, RegistroActivity::class.java))
            }

            recuperarbutton.setOnClickListener{
                startActivity(Intent(this, RecuperarActivity::class.java))
            }
        }

        private fun login(correo:String, contrasena:String){
            firebaseAuth.signInWithEmailAndPassword(correo, contrasena)
                .addOnCompleteListener(this){
                        task-> if(task.isSuccessful){
                            val user=firebaseAuth.currentUser
                            Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,HomeActivity::class.java))
                        }else{
                            Toast.makeText(baseContext, "Error en registro de datos", Toast.LENGTH_SHORT).show()
                        }
                }
        }
}

