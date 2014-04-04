package classes

class Pronosticador {

  
  def getClima(fecha : Int):String ={
    if (fecha % 2 == 0){
      return "Lluvia"
    }
    return "Soleado"
  }
}