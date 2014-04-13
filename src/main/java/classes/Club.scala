package classes
import scala.collection.mutable._
import excepciones._
import traits._

class Club(name :String) {
  
  var nombre = name
  val canchas = new ArrayBuffer[Cancha]()
  val reservas = new ArrayBuffer[Reserva]()
 
  
  def reservar(titular :String, dia :Int, hora :Int,nombreDeCancha :String){
    var maybecancha =  this.canchas find { a => a.identificador.equals(nombreDeCancha)}
    var cancha = maybecancha.get
    var costo = cancha.precio(dia, hora)
    reservas += new Reserva(dia,hora,titular,cancha,costo)
    cancha.reservar(dia, hora)
  }
  
  
  //2.b
  
  def obtenerTodasLasReservasParaUnDia(dia :Int):ArrayBuffer[Reserva]={
    return reservas filter { a => a.dia.equals(dia) }
  }
  
  // 2.a  
  def obtenerCanchasConReservas(dia :Int):ArrayBuffer[Cancha]={
		  return obtenerTodasLasReservasParaUnDia(dia) map {c => c.cancha}
  }
  
  // 2.c
  def BuscarCanchaLibre(dia:Int , hora :Int):Cancha ={
    val canchas = this.canchas find { a  => a.libreParaDiaYHora(dia, hora)}
    return canchas.get
  }
  
  
  // 2.d
  def obtenerCanchaMasReservada():String={
    var cancha :String = null
    var current = 0
    canchas foreach {c => if(c.obtenerMayorCantidadDeReservas() > current)
    							{ current = c.obtenerMayorCantidadDeReservas
      							  cancha = c.identificador}
                    }
    return cancha
  }

  
  
  //2.d
  def obtenerFacturacionTotal():Double ={
   val precios = this.reservas map { a => a.costo}
   return precios.sum
  }
  
  //2.e
  def totalDeFacturacion():Double={
    var reservasCosto = reservas map {r => r.costo}
    return reservasCosto.sum
  }

}