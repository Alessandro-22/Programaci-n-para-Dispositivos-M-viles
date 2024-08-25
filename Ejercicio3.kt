class Calculadora {
    fun Menu() {
        while (true) {
            println("==== Menú ====")
            println("1. Suma")
            println("2. Resta")
            println("3. Multiplicación")
            println("4. División")
            println("5. Salir")
            print("Elige una opción: ")

            when (readLine()?.toString()) {
                "Suma"              -> realizarOperacion("suma")
                "Resta"             -> realizarOperacion("resta")
                "Multiplicación"    -> realizarOperacion("multiplicación")
                "División"          -> realizarOperacion("división")
                "Salir"             -> {
                    println("Saliendo de la calculadora")
                    return
                }
                else -> println("Opción no válida")
            }
        }
    }

    private fun realizarOperacion(tipo: String) {
        print("Ingrese el numero 1: ")
        val num1 = readLine()?.toDoubleOrNull() ?: return
        print("Ingrese el numero 2: ")
        val num2 = readLine()?.toDoubleOrNull() ?: return

        val resultado = when (tipo) {
            "suma" -> num1 + num2
            "resta" -> num1 - num2
            "multiplicación" -> num1 * num2
            "división" -> if (num2 != 0.0) num1 / num2 else {
                println("Error: División por cero")
                return
            }
            else -> return
        }

        println("Resultado: $resultado")
    }
}

fun main() {
    val calculadora = Calculadora()
    calculadora.Menu()
}
