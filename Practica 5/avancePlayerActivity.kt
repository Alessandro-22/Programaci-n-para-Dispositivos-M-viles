// Método para actualizar la información de la canción actual
    private fun updateSongInfo() {
        songImageView.setImageResource(songImages[currentSongIndex]) // Cambia la imagen de la canción
        songTitleTextView.text = songTitles[currentSongIndex] // Muestra el título de la canción
        songDurationTextView.text = "Duration: ${songDurations[currentSongIndex]}" // Muestra la duración de la canción
    }

    // Método para reproducir la canción seleccionada
    private fun playSong() {
        mediaPlayer?.release() // Libera el recurso actual de MediaPlayer si existe
        mediaPlayer = MediaPlayer.create(this, songResources[currentSongIndex]) // Crea un nuevo MediaPlayer con la canción seleccionada
        mediaPlayer?.start() // Inicia la reproducción
        playPauseButton.text = "Pause" // Cambia el texto del botón a "Pause"
    }

    // Método para pausar la canción
    private fun pauseSong() {
        mediaPlayer?.pause() // Pausa la reproducción
        playPauseButton.text = "Play" // Cambia el texto del botón a "Play"
    }
