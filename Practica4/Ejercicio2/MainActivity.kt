Fecha de inicio: 21/09/24
fecha ultima version: 26/09/24
package com.example.spotifai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar MainFragment al iniciar la actividad
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commit()
        }
    }

    // Método llamado al seleccionar una canción en MainFragment
    fun onSongSelected(index: Int) {
        val playerFragment = PlayerFragment()
        playerFragment.setSongIndex(index) // Establecer el índice de la canción seleccionada

        // Navegar al PlayerFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, playerFragment)
            .addToBackStack(null) // Agregar a la pila de retroceso
            .commit()
    }

    // Método para volver al fragmento principal
    fun goBackToMain() {
        supportFragmentManager.popBackStack() // Volver al fragmento anterior
    }
}
