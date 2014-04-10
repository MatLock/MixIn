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
  

}