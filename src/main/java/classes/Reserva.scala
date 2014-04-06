/**
 * @author matlock
 */

package classes

import traits._

class Reserva(undia:Int ,unhorario:Int, untitular:String, unacancha:Cancha){

  var dia :Int = undia
  var horario :Int = unhorario
  var titular :String = untitular
  val cancha : Cancha = unacancha
  var costo :Double = 0
 
  def costoDeCancha():Int ={
    return this.cancha.costo()
  }
  
  def setCosto(cc :Double,ci :Double){
    this.costo = this.costoDeCancha + this.costoDeCancha()* cc + this.costoDeCancha() * ci
  }
  
}