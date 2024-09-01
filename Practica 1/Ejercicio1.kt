class EvaluacionEmpl(private val salarioMensual: Double,
                     private val puntuacion: Int) {


    fun Rendimiento(): String {
        return when (puntuacion) {
            in 0..3 -> "Inaceptable"
            in 4..6 -> "Aceptable"
            in 7..10 -> "Meritorio"
            else -> "Fuera de rango"
        }
    }

    fun DineroRecibido(): Double {
        return salarioMensual * (puntuacion / 10.0)
    }

    fun Resultado() {
        val nivelRendi = Rendimiento()
        val dineroRecibido = DineroRecibido()
        println("Resultado: Nivel de Rendimiento $nivelRendi, Cantidad de Dinero Recibido" +
                " $${dineroRecibido.toInt()}")
    }
}

fun main() {
    print("Ingresa tu salario mensual: ")
    val salarioMensual = readLine()?.toDoubleOrNull() ?: return
    print("Ingresa tu puntuación: ")
    val puntuacion = readLine()?.toIntOrNull() ?: return

    val evaluacion = EvaluacionEmpl(salarioMensual, puntuacion)
    evaluacion.Resultado()
}
