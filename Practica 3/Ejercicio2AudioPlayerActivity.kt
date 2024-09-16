class AudioPlayerActivity : AppCompatActivity() {

    // Declarar las variables para los elementos de la interfaz-> ImageView, TextView y los botones
    lateinit var imageView: ImageView
    lateinit var textViewAudioName: TextView
    lateinit var buttonPlay: Button
    lateinit var buttonPause: Button
    lateinit var buttonStop: Button
    // Declarar el objeto MediaPlayer para manejar la reproducción de audio
    lateinit var mediaPlayer: MediaPlayer
    // Variable para rastrear si el audio está en reproducción
    private var isPlaying = false

    // Lista de los archivod de audio en la carpeta raw
    private val audioFiles = arrayOf(R.raw.audio1, R.raw.audio2, R.raw.audio3, R.raw.audio4, R.raw.audio5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincular el layout de la actividad con la vista
        setContentView(R.layout.activity_audio_player)

        // Inicializar el ImageView para mostrar una imagen
        imageView = findViewById(R.id.imageView)
        // Inicializar el TextView para mostrar el nombre del audio seleccionado
        textViewAudioName = findViewById(R.id.textViewAudioName)
        // Inicializar los botones de reproducir, pausar y detener
        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonStop = findViewById(R.id.buttonStop)

        // Obtener el undice del audio seleccionado pasado desde la primera actividad
        val audioIndex = intent.getIntExtra("audioIndex", 0)

        // Configurar el nombre del audio en el TextView según el audio seleccionado
        textViewAudioName.text = "Reproduciendo: Audio ${audioIndex + 1}"

        // Crear el MediaPlayer con el archivo de audio seleccionado
        mediaPlayer = MediaPlayer.create(this, audioFiles[audioIndex])

        // Configurar el botón para reproducir el audio al hacer clic
        buttonPlay.setOnClickListener {
            // Verificar si el audio no se está reproduciendo
            if (!isPlaying) {
                // Iniciar la reproducción del audio
                mediaPlayer.start()
                // Marcar que el audio está en reproducción
                isPlaying = true
            }
        }

        // Configurar el botpn para pausar el audio al hacer clic
        buttonPause.setOnClickListener {
            // Verificar si el audio está en reproducción
            if (isPlaying) {
                // Pausar la reproducción del audio
                mediaPlayer.pause()
                // Marcar que el audio no está en reproducción
                isPlaying = false
            }
        }

        // Configurar el botón para detener el audio al hacer clic
        buttonStop.setOnClickListener {
            // Verificar si el audio está en reproducción
            if (isPlaying) {
                // Detener la reproducción del audio
                mediaPlayer.stop()
                // Preparar el MediaPlayer nuevamente para que esté listo para reproducir de nuevo
                mediaPlayer.prepare()
                // Marcar que el audio no está en reproducción
                isPlaying = false
            }
        }
    }

    // Sobrescribir el meodo onDestroy para liberar recursos cuando la actividad se destruya
    override fun onDestroy() {
        super.onDestroy()
        // Verificar si el audio está en reproducción antes de detenerlo
        if (mediaPlayer.isPlaying) {
            // Detener el audio si está en reproducción
            mediaPlayer.stop()
        }
        // Liberar los recursos del MediaPlayer
        mediaPlayer.release()
    }
}
