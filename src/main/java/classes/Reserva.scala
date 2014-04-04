package classes

import traits._

class Reserva(undia:Int ,unhorario:Int,unHorarioDeFinalizacion :Int, untitular:String, unacancha:Cancha){

  var dia :Int = undia
  var horario :Int = unhorario
  var horarioFinalizacion :Int = unHorarioDeFinalizacion
  var titular :String = untitular
  val cancha : Cancha = unacancha
  
  
  def costo() : Double = {
    return this.cancha.costo()
  }
  
}