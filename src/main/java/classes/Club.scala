package classes
import scala.collection.mutable._
import excepciones._
import traits._

class Club(name :String) {
  
  var nombre = name
  val canchas : ArrayBuffer[Cancha] = ArrayBuffer()
  val reservas :ArrayBuffer[Reserva] = ArrayBuffer()
  
  
  def seleccionarCanchaParaHorario(nombreDeCancha :String, hora :Int) :Cancha ={
	  var maybecancha = this.canchas find { a => a.identificador.equals(nombreDeCancha)}
	  val cancha = maybecancha.get
      if (hora > 18 && !cancha.iluminada){
        throw new CanchaSinIluminacionException("La Cancha "+cancha.identificador+" no poseé iluminación" )
      }
      return cancha
  }
  
  def chequearCanchaConClima(cancha:Cancha,fecha :Int):String ={
    var estadoClimatico = new Pronosticador().getClima(fecha)
    if (estadoClimatico.equals("Lluvia") && !cancha.techada){
		  throw new CanchaSinTechoException("La Cancha "+cancha.identificador+" no poseé techo")
    }
    return estadoClimatico
  }
  
  
  def reservarDespuesDeLas18(nombreDeCancha :String, titular :String, fecha :Int, hora :Int){
	  val cancha = this.seleccionarCanchaParaHorario(nombreDeCancha,hora)
	  var estadoClimatico = this.chequearCanchaConClima(cancha, fecha)
	  if (estadoClimatico.equals("Lluvia")){
	    val reserva = new Reserva(fecha,hora,titular,cancha) with Iluminada with Lluvioso
	    this.reservas += reserva
	  }else{
	    val reserva = new Reserva(fecha,hora,titular,cancha) with Iluminada with Soleado
	    this.reservas += reserva
	  }
	  cancha.agregarReservacion(fecha, hora)
  }
  
  def reservarAntesDeLas18(nombreDeCancha :String, titular :String, fecha :Int, hora :Int){
	  val cancha = this.seleccionarCanchaParaHorario(nombreDeCancha, hora)
	  var estadoClimatico = this.chequearCanchaConClima(cancha,fecha)
	  if(estadoClimatico.equals("Lluvia")){
	    val reserva = new Reserva(fecha,hora,titular,cancha) with SinIluminacion with Lluvioso
	    this.reservas += reserva
	    cancha.agregarReservacion(fecha, hora)
	    reserva.setCosto(reserva.costoIluminacion(),reserva.costoPorClima())
	  }else{
	    val reserva = new Reserva (fecha,hora,titular,cancha) with SinIluminacion with Soleado
	    this.reservas += reserva
	    cancha.agregarReservacion(fecha, hora)
	    reserva.setCosto(reserva.costoIluminacion(),reserva.costoPorClima())
	  }
	  cancha.agregarReservacion(fecha, hora)
  }
  
  def reservarCancha(nombreDeCancha :String, titular :String, fecha :Int, hora :Int){
	  if (fecha > 18){
	    this.reservarDespuesDeLas18(nombreDeCancha,titular,fecha,hora)
	  }else{
	    this.reservarAntesDeLas18(nombreDeCancha,titular,fecha,hora)
	  }
  }
  
  def costoDeReserva(titular :String):Double ={
    var maybereserva = this.reservas find { a => a.titular.equals(titular)}
    return maybereserva.get.costo
  }

}