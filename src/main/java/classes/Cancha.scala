package classes
import scala.collection.mutable._
import excepciones.HorarioYaSeleccionadoException

 abstract class Cancha(id :String,contecho :Boolean, ilum :Boolean, map :Map[Int,ArrayBuffer[Int]]) {
   
  var identificador = id
  var techada = contecho
  var iluminada = ilum
  var listaDeReservacion  =  map
  
  def costo():Int 
  
  
  private def agregarSiNoExisteDia(dia :Int){
    if (! this.listaDeReservacion.contains(dia)){
    	this.listaDeReservacion += dia -> new ArrayBuffer[Int]
    }
  }
  
  def agregarReservacion(dia :Int, hora :Int){
	  this.agregarSiNoExisteDia(dia)
	  var lista = this.listaDeReservacion.get(dia).get
	  if (lista.contains(hora)){
	    throw new HorarioYaSeleccionadoException("la cancha  "+"'"+this.identificador+"'"+" ya fue reservada")
	  }else{
		  lista += (hora)
	  }
  }
  
  def estaReservada(dia :Int, hora:Int) :Boolean ={
    return this.listaDeReservacion.get(dia).get.contains(hora)
  }
  
}

                     /** clases concretas **/

class Futbol (id :String,contecho :Boolean, ilum :Boolean,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,contecho,ilum,map){ 
  
  def costo(): Int = {
    return 40 * 10
  }
  
}

class Tenis (id :String,contecho :Boolean, ilum :Boolean,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,contecho,ilum,map){
       
  def costo(): Int = {
    return 150
  } 
}

class Paddle (id :String,contecho :Boolean, ilum :Boolean,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,contecho,ilum,map){
  
  def costo(): Int = {
    return 100
  }
}