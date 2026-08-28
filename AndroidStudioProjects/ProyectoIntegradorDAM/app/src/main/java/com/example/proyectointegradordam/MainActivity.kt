package com.example.ProyectoIntegradorDAM

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectointegradordam.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombre = findViewById<EditText>(R.id.etNombreAlumno)
        val etNota = findViewById<EditText>(R.id.etNotaAlumno)
        val btnEvaluar = findViewById<Button>(R.id.btnEvaluar)

        btnEvaluar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val notaTexto = etNota.text.toString()

            // Repaso de Null Safety y validación
            if (nombre.isNotBlank() && notaTexto.isNotBlank()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("EXTRA_NOMBRE", nombre)
                intent.putExtra("EXTRA_NOTA", notaTexto.toDoubleOrNull() ?: 0.0)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
