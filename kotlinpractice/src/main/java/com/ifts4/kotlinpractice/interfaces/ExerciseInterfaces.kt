package com.ifts4.kotlinpractice.interfaces

fun main() {

    val cd = CD("Camisa negra", "Juanes")
    cd.play()
    cd.playRecorder()
    println("----------")
    cd.stop()
    cd.stopRecorder()
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")

    val cassete = Cassete("Compilado")
    cassete.playRecorder()
    println("----------")
    cassete.stopRecorder()
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")
    println("----------")


    val mp3 = MP3("Vida")
    mp3.play()
    println("-----------")
    mp3.stop()
}