package com.example.menus_listas_nav

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menus_listas_nav.data.obtenerListaDeLibros
import com.example.menus_listas_nav.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Usa el ArrayAdapter por defecto
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, // Layout predefinido para elementos de la lista
            obtenerListaDeLibros()
        )

        binding.list.adapter = adapter



        Log.d("DEBUG", "Lista de libros: ${obtenerListaDeLibros()}")


        binding.appBarMain.toolbar.setNavigationOnClickListener {
            binding.main.open()
        }

        binding.appBarMain.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.account -> {
                    Toast.makeText(this, "Cuenta", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Más", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.version -> {
                    Toast.makeText(this, "Versión", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            if(menuItem.itemId == R.id.search_item){
                Toast.makeText(this," Search Title", Toast.LENGTH_SHORT).show()
            }
            binding.main.close()
            true
        }

    }
}