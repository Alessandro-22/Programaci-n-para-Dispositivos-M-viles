//Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
//Autor: Diego Alvarez
//fecha: 31/08/24
//ultima modificacion: 31/08/24
class CuentaBancaria(private var saldo: Double, private val limiteRetiro: Double) {
    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    
    fun retirar(cantidad: Double): Boolean {
        return if (cantidad <= saldo && cantidad <= limiteRetiro) {
            saldo -= cantidad
            true
        } else {
            println("Retiro fallido. Verifique el saldo o el límite de retiro.")
            false
        }
    }

 
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }
}

// Ejemplo de uso
fun main() {
    val cuenta = CuentaBancaria(1000.0, 200.0)

    println("Saldo inicial: ${cuenta.getSaldo()}")

    cuenta.retirar(150.0)
    println("Saldo después del retiro: ${cuenta.getSaldo()}")

    cuenta.setSaldo(500.0)
    println("Saldo actualizado: ${cuenta.getSaldo()}")

    cuenta.retirar(600.0)  // Intento de retiro fallido
}
