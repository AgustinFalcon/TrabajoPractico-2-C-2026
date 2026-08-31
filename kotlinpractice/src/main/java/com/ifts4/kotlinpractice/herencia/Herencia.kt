package com.ifts4.kotlinpractice.herencia

fun main() {
    //val perro = Perro(nombre = "Firulais", edad = 15, raza = Raza.SALCHICHA)
    //perro.hacerSonido()

    //val gato = Gato(nombre = "Michifus", edad = 20, catColor = CatColors.YELLOW)
    //gato.hacerSonido()

    var cualquierAnimal: Animal = Perro(nombre = "Firulais", edad = 15, raza = Raza.SALCHICHA)

    val constructores = ExampleConstructores()
    println(constructores.toString())


}


open class Animal(val nombre: String, val edad: Int) {
    open fun hacerSonido() {
        println("Tu mascota: $nombre, $edad años esta haciendo un sondo")
    }
}

class Perro(nombre: String, edad: Int, val raza: Raza): Animal(nombre = nombre, edad = edad) {
    override fun hacerSonido() {
        println("Tu $nombre de raza: $raza esta haciendo un sonido")
    }
}

class Gato(nombre: String, edad: Int, val catColor: CatColors) : Animal(nombre = nombre, edad = edad) {
    override fun hacerSonido() {
        var nameColor = when (catColor) {
            CatColors.RED -> "rojo"
            CatColors.BLUE -> "blue"
            CatColors.GREEN -> "verde"
            CatColors.WHITE -> "blanco"
            CatColors.YELLOW -> "naranjoso"
        }

        val myList: List<CatColors> = CatColors.entries
        println("$nombre de color: $nameColor esta maullando")
    }
}



class ExampleConstructores {

    var port= ""
    var typeDb = ""


    init {
        port = "8080"
        typeDb = "Postgressql"
    }

    /*override fun toString(): String {
        return "Puerto: $port, typedb: $typeDb"
    }*/
}
