/**
 * @author matlock
 */
package classes

class Pronosticador {

  
  def getClima(fecha : Int):String ={
    if (fecha % 2 == 0){
      return "Lluvia"
    }
    return "Soleado"
  }
  
  def dia(fecha :Int):String ={
    if(fecha == 7 || fecha==8 || fecha==14 || fecha==15 || fecha == 22){
      return "FinDeSemana"
    }
    return "Semana"
  }
}