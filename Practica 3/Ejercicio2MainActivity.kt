class MainActivity : AppCompatActivity() {

    // Declarar las variables del Spinner y el boton
    lateinit var spinnerAudio: Spinner
    lateinit var buttonSeleccionar: Button

    // Lista con los nombres de los audios que aparecerán en el Spinner
    private val audioNames = arrayOf("Audio 1", "Audio 2", "Audio 3", "Audio 4", "Audio 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincular el layout de la actividad con la vista
        setContentView(R.layout.activity_main)

        // Inicializar el Spinner del audio
        spinnerAudio = findViewById(R.id.spinnerAudio)
        // Inicializar el botón "Seleccionar"
        buttonSeleccionar = findViewById(R.id.buttonSeleccionar)

        // Crear un adaptador para el Spinner con los nombres de los audios
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audioNames)
        // Establecer el diseño desplegable para el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asignar el adaptador al Spinner
        spinnerAudio.adapter = adapter

        // Configurar el botón para pasar a la actividad de reproducción de audio al hacer clic
        buttonSeleccionar.setOnClickListener {
            // Obtener el índice del audio seleccionado en el Spinner
            val selectedAudio = spinnerAudio.selectedItemPosition
            // Crear un Intent para pasar a la segunda actividad (AudioPlayerActivity)
            val intent = Intent(this, AudioPlayerActivity::class.java)
            // Pasar el índice del audio seleccionado a la segunda actividad
            intent.putExtra("audioIndex", selectedAudio)
            // Iniciar la segunda actividad
            startActivity(intent)
        }
    }
}
