
data class Contacto(val nombre: String, val telefono: String, val correo: String)

class AgendaContactos {
    private val listaDeContactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        listaDeContactos.add(contacto)
        println("Contacto agregado con éxito.")
    }

    fun mostrarContactos() {
        if (listaDeContactos.isEmpty()) {
            println("La lista de contactos está vacía.")
        } else {
            println("Lista de contactos:")
            listaDeContactos.forEachIndexed { index, contacto ->
                println("${index + 1}. Nombre: ${contacto.nombre}, Teléfono: ${contacto.telefono}, Correo: ${contacto.correo}")
            }
        }
    }

    fun buscarContactoPorNombre(nombreABuscar: String) {
        val contactosEncontrados = listaDeContactos.filter { it.nombre.contains(nombreABuscar, ignoreCase = true) }
        if (contactosEncontrados.isNotEmpty()) {
            println("Contactos encontrados:")
            contactosEncontrados.forEachIndexed { index, contacto ->
                println("${index + 1}. Nombre: ${contacto.nombre}, Teléfono: ${contacto.telefono}, Correo: ${contacto.correo}")
            }
        } else {
            println("No se encontraron contactos con ese nombre.")
        }
    }

    fun eliminarContactoPorNombre(nombreAEliminar: String) {
        val contactosAEliminar = listaDeContactos.filter { it.nombre.equals(nombreAEliminar, ignoreCase = true) }
        if (contactosAEliminar.isNotEmpty()) {
            listaDeContactos.removeAll(contactosAEliminar)
            println("Contacto(s) eliminado(s) con éxito.")
        } else {
            println("No se encontraron contactos con ese nombre para eliminar.")
        }
    }
}

fun main() {
    val agenda = AgendaContactos()

    while (true) {
        println("Selecciona una opción:")
        println("1. Agregar un nuevo contacto")
        println("2. Mostrar la lista de contactos")
        println("3. Buscar un contacto por nombre")
        println("4. Eliminar un contacto por nombre")
        println("5. Salir del programa")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Ingresa el nombre del contacto:")
                val nombre = readLine() ?: ""
                println("Ingresa el número de teléfono:")
                val telefono = readLine() ?: ""
                println("Ingresa el correo electrónico:")
                val correo = readLine() ?: ""

                val contacto = Contacto(nombre, telefono, correo)
                agenda.agregarContacto(contacto)
            }
            2 -> agenda.mostrarContactos()
            3 -> {
                println("Ingresa el nombre del contacto a buscar:")
                val nombreABuscar = readLine() ?: ""
                agenda.buscarContactoPorNombre(nombreABuscar)
            }
            4 -> {
                println("Ingresa el nombre del contacto a eliminar:")
                val nombreAEliminar = readLine() ?: ""
                agenda.eliminarContactoPorNombre(nombreAEliminar)
            }
            5 -> {
                println("¡Hasta luego!")
                break
            }
            else -> {
                println("Opción no válida. Por favor, selecciona una opción válida.")
            }
        }
    }
}