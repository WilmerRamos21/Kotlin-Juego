package com.epn.gravitygame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button

class MenuActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hacer la pantalla completa sin barra de título
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_menu)

        val btnStart = findViewById<Button>(R.id.btnStart)

        // Al pulsar el botón, vamos a la MainActivity del juego
        btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Opcional: finish() si no quieres que el usuario vuelva al menú al pulsar "Atrás"
        }
    }
}