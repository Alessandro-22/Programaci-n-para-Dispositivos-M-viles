Fecha de inicio: 20/09
Fecha final: 26/09
package com.example.spotifai

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlayerFragment : Fragment() {
    private lateinit var songImageView: ImageView // Imagen de la canción
    private lateinit var songTitleTextView: TextView // Título de la canción
    private lateinit var playPauseButton: Button // Botón de play/pause
    private lateinit var previousButton: Button // Botón de canción anterior
    private lateinit var nextButton: Button // Botón de siguiente canción
    private lateinit var backButton: Button // Botón de volver al menú principal
    private var mediaPlayer: MediaPlayer? = null // MediaPlayer para reproducir la canción
    private var currentSongIndex: Int = 0 // Índice de la canción actual

    // Títulos, imágenes y recursos de las canciones
    private val songTitles = arrayOf(
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

    private val songImages = intArrayOf(
        R.drawable.zapato,
        R.drawable.mostaza,
        R.drawable.tears,
        R.drawable.goober,
        R.drawable.scatman,
        R.drawable.quaoar,
        R.drawable.hey,
        R.drawable.vitas,
        R.drawable.mora,
        R.drawable.some
    )

    private val songResources = intArrayOf(
        R.raw.zapato,
        R.raw.mostaza,
        R.raw.tears,
        R.raw.goober,
        R.raw.scatman,
        R.raw.quaoar,
        R.raw.hey,
        R.raw.vitas,
        R.raw.mora,
        R.raw.some
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_player, container, false)

        // Referencias a los elementos del layout
        songImageView = view.findViewById(R.id.songImageView)
        songTitleTextView = view.findViewById(R.id.songTitleTextView)
        playPauseButton = view.findViewById(R.id.playPauseButton)
        previousButton = view.findViewById(R.id.previousButton)
        nextButton = view.findViewById(R.id.nextButton)
        backButton = view.findViewById(R.id.backButton)

        // Actualizar información de la canción al cargar
        updateSongInfo()

        // Evento al hacer clic en el botón de play/pause
        playPauseButton.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                pauseSong() // Pausar si está reproduciendo
            } else {
                playSong() // Reproducir si está pausado
            }
        }

        // Eventos para los botones de anterior y siguiente
        previousButton.setOnClickListener {
            playPreviousSong()
        }

        nextButton.setOnClickListener {
            playNextSong()
        }

        // Evento para volver al fragmento principal
        backButton.setOnClickListener {
            (activity as MainActivity).goBackToMain()
        }

        return view // Devolver la vista inflada
    }

    // Método para establecer el índice de la canción
    fun setSongIndex(index: Int) {
        currentSongIndex = index
        updateSongInfo() // Actualizar la información de la canción
    }

    // Actualizar la imagen y título de la canción actual
    private fun updateSongInfo() {
        songImageView.setImageResource(songImages[currentSongIndex])
        songTitleTextView.text = songTitles[currentSongIndex]
    }

    // Método para reproducir la canción
    private fun playSong() {
        mediaPlayer?.release() // Liberar recursos anteriores
        mediaPlayer = MediaPlayer.create(requireContext(), songResources[currentSongIndex]) // Crear MediaPlayer
        mediaPlayer?.start() // Iniciar reproducción
        playPauseButton.text = "Pause" // Cambiar texto del botón
    }

    // Método para pausar la canción
    private fun pauseSong() {
        mediaPlayer?.pause()
        playPauseButton.text = "Play" // Cambiar texto del botón
    }

    // Método para reproducir la canción anterior
    private fun playPreviousSong() {
        currentSongIndex = (currentSongIndex - 1 + songTitles.size) % songTitles.size // Calcular índice
        updateSongInfo() // Actualizar información de la canción
        playSong() // Reproducir canción
    }

    // Método para reproducir la siguiente canción
    private fun playNextSong() {
        currentSongIndex = (currentSongIndex + 1) % songTitles.size // Calcular índice
        updateSongInfo() // Actualizar información de la canción
        playSong() // Reproducir canción
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Liberar recursos del MediaPlayer al destruir el fragmento
        mediaPlayer = null
    }
}
