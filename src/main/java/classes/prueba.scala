package classes
import classes._
import scala.collection.mutable._

object prueba extends App{

	var listaDeR : Map[Int,ArrayBuffer[Int]] =  Map()
    val tenis =  new Tenis("tenis",false,false,listaDeR)
    println(tenis.costo())
    println(tenis.identificador)
    
    var listaDeReservacion : Map[Int,ArrayBuffer[Int]] =  Map()
    var listaDeReservacion2 : Map[Int,ArrayBuffer[Int]] =  Map()
    val l2 = ArrayBuffer
    val l=  ArrayBuffer(1,2,3)
    listaDeReservacion += 3 -> l
    println(listaDeReservacion.get(3))
    
    
    
    println("aaaaaaaaaa")
    val lista = listaDeReservacion.get(3).get
    println(lista)
    lista += 5
    println(lista)
    println(lista.contains(5))
    println(listaDeReservacion)
    println (listaDeReservacion2)
    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    println(tenis.listaDeReservacion)
    tenis.agregarReservacion(2, 17)
    println(tenis.listaDeReservacion)
    println(tenis.estaReservada(2,17))
    
}