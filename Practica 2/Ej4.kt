//Sistema de Gestión de Biblioteca
//fecha: 01/09/24
//ultima modificacion: 01/09/24

// Clase base abstracta
abstract class Material(
    val titulo: String,
    val autor: String,
    val añoPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, añoPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $añoPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, añoPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $añoPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        if (materialesDisponibles.contains(material)) {
            // Verifica si el usuario está registrado
            if (usuarios.containsKey(usuario)) {
                materialesDisponibles.remove(material)
                usuarios[usuario]?.add(material) 
                println("Material prestado a ${usuario.nombre} ${usuario.apellido}.")
                return true
            } else {
                println("Usuario no registrado.")
                return false
            }
        }
        println("Material no disponible.")
        return false
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        if (usuarios[usuario]?.remove(material) == true) {
            materialesDisponibles.add(material)
            println("Material devuelto por ${usuario.nombre} ${usuario.apellido}.")
            return true
        }
        println("El usuario no tiene este material.")
        return false
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles.")
        } else {
            materialesDisponibles.forEach { it.mostrarDetalles() }
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuarios[usuario]?.let {
            if (it.isEmpty()) {
                println("No hay materiales reservados.")
            } else {
                it.forEach { material -> material.mostrarDetalles() }
            }
        } ?: println("Usuario no registrado.")
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("Cien años de soledad", "Gabriel García", 1950, "Vanguardista", 320)
    val revista1 = Revista("El peruano", "National Geographic Society", 2024, "0027-9358", 2024, 4, "National Society")

    val usuario1 = Usuario("Juan", "Pérez", 30)
    val usuario2 = Usuario("Diego", "Gómez", 25)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
}
