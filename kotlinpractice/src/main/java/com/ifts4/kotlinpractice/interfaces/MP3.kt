package com.ifts4.kotlinpractice.interfaces


class MP3(val disk: String) : Reproductor {

    override fun play() {
        println("Puso play el disco: $disk")
    }

    override fun stop() {
        println("Puso stop al disco $disk")
    }
}