Descripción corta del problema:Interacción con Imágenes.
 autor:Diego Alvarez Cruz
 fecha:15/09/24
 fecha última modificación: fecha:15/09/24

override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt("spinnerSelection", spinner.selectedItemPosition)
}

override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    super.onRestoreInstanceState(savedInstanceState)
    val spinnerPosition = savedInstanceState.getInt("spinnerSelection", 0)
    spinner.setSelection(spinnerPosition)
}
