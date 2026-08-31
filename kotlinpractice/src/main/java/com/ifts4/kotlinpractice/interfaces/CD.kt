package com.ifts4.kotlinpractice.interfaces

import com.ifts4.kotlinpractice.herencia.Animal


class CD (val name: String, val author: String) : Reproductor, Grabadora {

    override fun play() {
        println("Puso a reproducir al cd: $name - $author")
    }

    override fun stop() {
        println("Detuvo el cd $name")
    }

    override fun playRecorder() {
        println("Puso a grabar $name de $author")
    }

    override fun stopRecorder() {
        println("Detuvo la grabacion de $name")
    }
}