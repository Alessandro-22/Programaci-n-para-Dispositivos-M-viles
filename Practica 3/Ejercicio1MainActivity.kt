Descripción corta del problema:Interacción con Imágenes.
 autor:Diego Alvarez Cruz
 fecha:14/09/24
 fecha última modificación: fecha:15/09/24

class MainActivity : AppCompatActivity() {

    // Declarar variables para el Spinner y el boton
    lateinit var spinner: Spinner
    lateinit var buttonNext: Button

    // Crear un array con los nombres de las imágenes
    private val imageNames = arrayOf("Image 1", "Image 2", "Image 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el Spinner y el botón
        spinner = findViewById(R.id.spinner)
        buttonNext = findViewById(R.id.buttonNext)

        // Crear un adaptador para el Spinner con los nombres de las imageenes
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Configurar el botón para pasar a la segunda actividad al hacer clic
        buttonNext.setOnClickListener {
            // Obtener el nombre de la imagen seleccionada en el Spinner
            val selectedImage = spinner.selectedItem.toString()
            // Crear un Intent para pasar a SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            // Pasar el nombre de la imagen seleccionada a la segunda actividad
            intent.putExtra("selectedImage", selectedImage)
            // Iniciar la segunda actividad
            startActivity(intent)
        }
    }

    // Guardar el estado del Spinner al rotar la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardar la posición seleccionada del Spinner
        outState.putInt("spinnerSelection", spinner.selectedItemPosition)
    }

    // Restaurar el estado del Spinner despus de la rotación
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Obtener y establecer la posición del Spinner guardada
        val spinnerPosition = savedInstanceState.getInt("spinnerSelection", 0)
        spinner.setSelection(spinnerPosition)
    }
}
