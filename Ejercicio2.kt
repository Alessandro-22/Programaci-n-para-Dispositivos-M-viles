import kotlin.random.Random

class Juego {
    private val opciones = arrayOf("Piedra", "Papel", "Tijera")

    fun jugar() {
        val eleccionPC = opciones[Random.nextInt(3)]

        println("Elige: Piedra, Papel o Tijera")
        val eleccionUsuario = readLine()

        when {
            eleccionUsuario == eleccionPC -> println("Empataste")
            (eleccionUsuario == "Piedra" && eleccionPC == "Tijera") ||
                    (eleccionUsuario == "Papel" && eleccionPC == "Piedra") ||
                    (eleccionUsuario == "Tijera" && eleccionPC == "Papel") -> println("Ganaste")
            else -> println("Perdiste")
        }
    }
}

fun main() {
    val juego = Juego()
    juego.jugar()
}
