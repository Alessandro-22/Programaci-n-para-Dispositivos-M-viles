//Diseña una clase Producto que tenga un precio y un descuento aplicable.
//Autor: Diego Alvarez
//fecha: 31/08/24
//ultima modificacion: 01/09/24

class Producto(private var precio: Double, private var descuento: Double) {
    fun getPrecio(): Double {
        return precio
    }

    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo")
        }
    }
    fun getDescuento(): Double {
        return descuento
    }

    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El descuento esta entre 0 y 100.")
        }
    }

    fun calcularPrecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}

fun main() {
    val producto = Producto(1000.0, 15.0)

    println("Precio inicial: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final despues del descento: ${producto.calcularPrecioFinal()}")

    producto.setPrecio(1200.0)
    producto.setDescuento(20.0)

    println("Nuevo precio: ${producto.getPrecio()}")
    println("Nuevo descuento: ${producto.getDescuento()}%")
    println("Precio final despues del descuento: ${producto.calcularPrecioFinal()}")
}
