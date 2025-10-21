package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textMessage: TextView
    private val TAG = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textMessage = findViewById<TextView>(R.id.txt_message)
        editText = findViewById<EditText>(R.id.edit_text)
        button = findViewById<Button>(R.id.bttn_next)



            // Obtener un String extra
            // El segundo argumento es un valor por defecto si la clave no se encuentra
            val message=intent.getStringExtra("mensaje")
                textMessage.text=message // Asume que tienes un TextView

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("mensaje",editText.text)
            startActivity(intent)
        }
    }
}