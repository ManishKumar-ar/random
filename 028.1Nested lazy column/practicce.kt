package com.example.navigation24

enum class Metal(val symbol : String){
    IRON("fe"),
    GOLD("au"),
    SILVER("ag")

}

fun main(){

   for(metal in Metal.values()) {
       println("Symbol : ${metal.symbol}, Name: ${metal.name}, Ordinal : ${metal.ordinal}")
   }
  println(Metal.IRON)
}

fun printMetal(metal: Metal){
    println(metal.name)
}

//output
//Symbol : fe, Name: IRON, Ordinal : 0
//Symbol : au, Name: GOLD, Ordinal : 1
//Symbol : ag, Name: SILVER, Ordinal : 2
//IRON

