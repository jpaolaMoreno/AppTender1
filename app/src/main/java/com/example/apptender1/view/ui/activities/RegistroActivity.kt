package com.example.apptender1.view.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.apptender1.R

class RegistroActivity : AppCompatActivity() {

    lateinit var registrarbutton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        registrarbutton = findViewById(R.id.BRegistrar)

        registrarbutton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

}