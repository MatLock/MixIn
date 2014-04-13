/**
 * @author matlock
 */

package classes

import traits._

class Reserva(undia:Int ,unhorario:Int, untitular:String , unacancha :Cancha, uncosto :Double){

  var dia  = undia
  var horario = unhorario
  var titular  = untitular
  var costo = uncosto
  val cancha = unacancha
}