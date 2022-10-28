package com.example.apptender1.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import com.example.apptender1.R

class LoginActivity : AppCompatActivity() {

        lateinit var iniciobutton: Button
        lateinit var registrobutton: Button
        lateinit var recuperarbutton: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            iniciobutton = findViewById(R.id.BInicio)
            registrobutton = findViewById(R.id.BRegistro)
            recuperarbutton = findViewById(R.id.BRecuperar)
    }
}

