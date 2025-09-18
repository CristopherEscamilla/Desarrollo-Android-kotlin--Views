package com.example.life_cicle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
/*
 * Ciclo de Vida
 */
class MainActivity : AppCompatActivity() {

    //String, Int, Double, Float, y Boolean
    private var count: Int = 0
    private val TAG = "MyActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonCount = findViewById<Button>(R.id.button_count)
        val textView = findViewById<TextView>(R.id.text_count)
        /**
        if (savedInstanceState != null) {
            // Restaurar el estado desde savedInstanceState
            count = savedInstanceState.getInt("myKey", 0) // Proporciona un valor predeterminado
            textView.text = count.toString()
            Log.d(TAG, "Estado restaurado en onCreate(). count: $count")
        } else {
            // Inicializar el estado por primera vez si no hay estado guardado
            Log.d(TAG, "Inicializando estado por primera vez en onCreate(). count: $count")
        }
       */

        Log.w(TAG, "count1: ${count }")
        buttonToast.setOnClickListener {
            Toast.makeText(this, "Hola soy un Toast", Toast.LENGTH_SHORT).show()
        }
        buttonCount.setOnClickListener {
            textView.text = count.toString()
            count++
        }
    }

    fun showCount(): Unit {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() llamado")
        // La actividad está a punto de volverse visible
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() llamado")
        // La actividad tiene el foco y es interactiva
        // Inicia animaciones, adquiere recursos exclusivos
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() llamado")
        // La actividad está a punto de perder el foco
        // Libera recursos, guarda estado persistente crítico
        // ¡Hazlo rápido!
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() llamado")
        // La actividad ya no es visible
        // Realiza operaciones de cierre más intensivas
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() llamado")
        // La actividad está siendo reiniciada después de estar detenida
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() llamado")
        // La actividad está siendo destruida
        // Limpieza final de recursos}
    }

    // También es importante para guardar el estado de la UI antes de que la actividad sea destruida
    // por un cambio de configuración o por el sistema.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState() llamado")
        // Guarda aquí el estado dinámico de la UI
        outState.putInt("myKey", count)
    }

     // Y para restaurar el estado en onCreate o onRestoreInstanceState
     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
         super.onRestoreInstanceState(savedInstanceState)
         Log.d(TAG, "onRestoreInstanceState() llamado")
         // Restaura aquí el estado dinámico de la UI
        // val myValue = savedInstanceState.getString("myKey")
         // savedInstanceState aquí nunca será null
         count = savedInstanceState.getInt("myKey")
         findViewById<TextView>(R.id.text_count).text = count.toString()
         Log.d(TAG, "Estado restaurado en onRestoreInstanceState(). count: $count")
     }
}