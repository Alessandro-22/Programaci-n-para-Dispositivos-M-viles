import kotlin.random.Random

class AdivinaNumero {
    private val numeroAlea = Random.nextInt(1, 31)
    private var intentos = 5

    fun jugar() {
        println("Adivina el número (1-30). Tienes $intentos intentos.")

        while (intentos > 0) {
            print("Elige un numero: ")
            val posibleNum = readLine()?.toIntOrNull()

            if (posibleNum == null) {
                println("ingresa un número valido")
                continue
            }

            if (posibleNum < numeroAlea) {
                println("El número es mayor.")
            } else if (posibleNum > numeroAlea) {
                println("El número es menor.")
            } else {
                println("¡Excelente! Adivinaste el numero.")
                return
            }

            intentos--
            println("Te quedan $intentos intentos.")
        }

        println("Game Over, el número era $numeroAlea.")
    }
}

fun main() {
    val juego = AdivinaNumero()
    juego.jugar()
}
