package com.ifts4.kotlinpractice.interfaces.comunicacion_entre_clases

fun main() {

    val claseA = ClaseA()
    claseA.iniciarComunicacion()
    claseA.borrarMensaje()
    claseA.iniciarComunicacion()
}

class ClaseA : Comunicador {

    override fun enviarMensaje(mensaje: String) {
        println("Desde ClaseA recibimos el mensaje que es: $mensaje")
    }

    override fun borrar() {
        println("Usted borro el mensaje")
    }

    fun iniciarComunicacion() {
        val claseb = ClaseB(comunicador = this)
        claseb.realizarAccion()
    }

    fun borrarMensaje() {
        val claseb = ClaseB(comunicador = this)
        claseb.borrarMensaje()
    }
}

class ClaseB(private val comunicador: Comunicador) {

    private var message = ""

    fun realizarAccion() {
        message = "¡ESTA ACCION FUE REALIZADA DESDE CLASE B!"
        comunicador.enviarMensaje(mensaje = message)
    }

    fun borrarMensaje() {
        message = ""
        comunicador.borrar()
    }

}



interface Comunicador {
    fun enviarMensaje(mensaje: String)
    fun borrar()
}