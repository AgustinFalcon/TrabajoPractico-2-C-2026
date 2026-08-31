package com.ifts4.kotlinpractice.interfaces


class Cassete(val name: String) : Grabadora {

    override fun playRecorder() {
        println("Encendio la grabadora para :$name")
    }

    override fun stopRecorder() {
        println("Detuvo la grabadora de $name")
    }
}