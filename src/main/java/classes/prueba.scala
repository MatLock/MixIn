/**
 * @author matlock
 */

package classes
import classes._
import scala.collection.mutable._
import traits._

object prueba extends App{
  /*
	val listaDeR : Map[Int,ArrayBuffer[Int]] =  Map()

    
    val listaDeReservacion : Map[Int,ArrayBuffer[Int]] =  Map()
    val listaDeReservacion2 : Map[Int,ArrayBuffer[Int]] =  Map()
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
    
    
    val o = List(1,2,3)
    println ( o find{a => a == 3})
    
    */
    val listaDeR =  Map[Int,ArrayBuffer[Int]]()
	val canchaFutbol = new Tenis("tenis5",listaDeR) with conTribuna with ConTecho with Iluminado
    val club = new Club("pepito")
    club.canchas += canchaFutbol
    club.reservar("titular", 14, 23, "tenis5")
    val reserva = club.reservas find {a => a.titular.equals("titular")}
    println (reserva.get.costo)
    
    
     for( a <- 1 to 10){
         println( "Value of a: " + a );
      }
    
    
}