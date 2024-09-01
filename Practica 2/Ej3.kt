//Cree una clase abstracta “shape” la cual contenga las propiedades area, perimetro
//Autor: Diego Alvarez Cruz
//fecha: 01/09/24
//ultima modificacion: 01/09/24

// Clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    fun mostrarArea() {
        println("Area: $area")
    }

    fun mostrarPerimetro() {
        println("Perimetro: $perimetro")
    }
}

// Subclase Cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override val area: Double
        get() = lado * lado

    override val perimetro: Double
        get() = 4 * lado
}

// Subclase Círculo
class Circulo(val radio: Double) : Shape() {
    override val area: Double
        get() = Math.PI * radio * radio

    override val perimetro: Double
        get() = 2 * Math.PI * radio
}

// Subclase Rectángulo
class Rectangulo(val largo: Double, val ancho: Double) : Shape() {
    override val area: Double
        get() = largo * ancho

    override val perimetro: Double
        get() = 2 * (largo + ancho)
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 6.0)

    println("Los resultados del Cuadrado:")
    cuadrado.mostrarArea()
    cuadrado.mostrarPerimetro()

    println("\nLos resultados del Círculo:")
    circulo.mostrarArea()
    circulo.mostrarPerimetro()

    println("\nLos resultados del Rectángulo:")
    rectangulo.mostrarArea()
    rectangulo.mostrarPerimetro()
}
