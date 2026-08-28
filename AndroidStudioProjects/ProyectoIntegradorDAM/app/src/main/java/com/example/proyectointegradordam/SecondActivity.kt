package com.example.ProyectoIntegradorDAM

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectointegradordam.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvResultadoNombre = findViewById<TextView>(R.id.tvResultadoNombre)
        val tvEstadoNota = findViewById<TextView>(R.id.tvEstadoNota)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        // Recoger datos enviados
        val nombre = intent.getStringExtra("EXTRA_NOMBRE") ?: "Alumno"
        val nota = intent.getDoubleExtra("EXTRA_NOTA", 0.0)

        tvResultadoNombre.text = "Alumno: $nombre"

        // Repaso de la estructura 'when' en Kotlin
        val evaluacion = when (nota) {
            in 9.0..10.0 -> "Sobresaliente 🎉"
            in 7.0..8.9 -> "Notable 👍"
            in 5.0..6.9 -> "Aprobado 📝"
            else -> "Suspenso ❌"
        }

        tvEstadoNota.text = "Nota: $nota -> $evaluacion"

        btnVolver.setOnClickListener {
            finish()
        }
    }
}