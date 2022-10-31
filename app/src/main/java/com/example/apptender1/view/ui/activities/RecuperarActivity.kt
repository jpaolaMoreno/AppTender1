package com.example.apptender1.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.apptender1.R

class RecuperarActivity : AppCompatActivity() {

    lateinit var recuperar1button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar)

        recuperar1button = findViewById(R.id.BRecuEmail)

        recuperar1button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java ))
    }
}
}