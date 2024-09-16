class SecondActivity : AppCompatActivity() {

    // Declarar variables para el ImageView y el boton de volver
    lateinit var imageView: ImageView
    lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Inicializar el ImageView y el boton de volver
        imageView = findViewById(R.id.imageView)
        buttonBack = findViewById(R.id.buttonBack)

        // Obtener el nombre de la imagen que se pasó desde la MainActivity
        val selectedImage = intent.getStringExtra("selectedImage")

        // Asignar la imagen correspondiente en función de la selección
        val imageResId = when (selectedImage) {
            "Image 1" -> R.drawable.image1
            "Image 2" -> R.drawable.image2
            "Image 3" -> R.drawable.image3
            else -> R.drawable.default_image
        }
        // Establecer la imagen en el ImageView
        imageView.setImageResource(imageResId)

        // Configurar el boton para volver a la actividad anterior
        buttonBack.setOnClickListener {
            // Finalizar la actividad actual para volver a MainActivity
            finish()
        }
    }
}
