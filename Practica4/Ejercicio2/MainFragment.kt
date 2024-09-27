package com.example.spotifai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // Referencia a los elementos del layout
        val songSpinner: Spinner = view.findViewById(R.id.songSpinner)
        val playButton: Button = view.findViewById(R.id.playButton)

        // Lista de canciones
        val songs = arrayOf(
            "Mike Laure - El Zapato",
            "Granito de Mostaza - Amén",
            "Save your tears - The Weeknd",
            "I'm a goofy goober - SpongeBob",
            "Scatman (ski-ba-bop-ba-dop-bop) - Scatman John",
            "Quaoar - Camelia",
            "He Man sings - 4 Non Blondes",
            "Vitas - The 7th Element",
            "Morat - Cuando nadie ve",
            "Somewhere over the Rainbow - Israel Kamakawiwo"
        )

        // Adaptador para el Spinner
        val songAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, songs)
        songAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        songSpinner.adapter = songAdapter

        // Evento al hacer clic en el botón de reproducir
        playButton.setOnClickListener {
            // Obtener la posición de la canción seleccionada
            val selectedPosition = songSpinner.selectedItemPosition
            // Llamar al método en MainActivity para manejar la selección de la canción
            (activity as MainActivity).onSongSelected(selectedPosition)
        }

        return view // Devolver la vista inflada
    }
}
