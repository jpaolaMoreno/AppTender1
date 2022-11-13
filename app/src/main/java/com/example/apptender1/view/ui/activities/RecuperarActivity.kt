package com.example.apptender1.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.apptender1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecuperarActivity : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var recuperar1button: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)
        firebaseAuth=Firebase.auth
        recuperar1button = findViewById(R.id.BRecuEmail)

        val correo=findViewById<EditText>(R.id.RecuperarCorreo)

        recuperar1button.setOnClickListener {
            cambiocontrasena(correo.text.toString())
        }

    }
        private fun cambiocontrasena(correo:String){

            firebaseAuth.sendPasswordResetEmail(correo)
                .addOnCompleteListener(this){
                    task->if(task.isSuccessful){
                    Toast.makeText(baseContext, "correo de cambio de contraseña enviado", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java ))
                }else{
                    Toast.makeText(baseContext, "Error correo no existente", Toast.LENGTH_SHORT).show()
                }
        }
}
}