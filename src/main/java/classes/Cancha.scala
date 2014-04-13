package classes
import scala.collection.mutable._
import excepciones._
 
abstract class Cancha(id :String, map :Map[Int,ArrayBuffer[Int]],precio :Double) {
   
  var identificador = id
  val listaDeReservacion  =  map
  var costo  = precio
  
  def agregarSiNoExisteDia(dia :Int){
    if (! this.listaDeReservacion.contains(dia)){
    	this.listaDeReservacion += dia -> new ArrayBuffer[Int]
    }
  }
  
  def chequearHorario(hora:Int){
	  if (hora > 18){
		  throw new CanchaSinIluminacionException("la cancha  "+"'"+this.identificador+"'"+" no tiene Iluminacion")
	  }
  }
    
  def reservar(dia :Int,hora :Int){
      this.agregarSiNoExisteDia(dia)
	  var lista = this.listaDeReservacion.get(dia).get
	  if(lista.contains(hora)){
	    throw new HorarioYaSeleccionadoException("la cancha"+"'"+this.identificador+"'"+" ya esta reservada")
	  }else{
		  lista += (hora)
	  }
  }
  
  def precio(dia :Int, hora :Int) :Double ={
	this.chequearHorario(hora)
    return costo
  }
  
  def contieneHorario(dia :Int,hora :Int):Boolean={
    return listaDeReservacion.get(dia).get.contains(hora)
  }
  
  def libreParaDiaYHora(dia :Int,hora :Int): Boolean={
    return !listaDeReservacion.contains(dia) || ( listaDeReservacion.contains(dia) && !this.contieneHorario(dia,hora)) 
  }
  
  def obtenerMayorCantidadDeReservas():Int={
   var dias = listaDeReservacion.keys
   var current = 0
   dias foreach { f => var x = listaDeReservacion.get(f).get.length; 
     					if (x > current) { current = x } 
     			}
   return current
  }
  

}






                     /** clases concretas **/

class Futbol (id :String,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,map,400){ 
 
  
}

class Tenis (id :String,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,map,150){
       
}

class Paddle (id :String,map :Map[Int,ArrayBuffer[Int]])
extends Cancha(id,map,100){
  
}
