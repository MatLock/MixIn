package classes

abstract class Cancha {
   
  var identificador :String
  
  def costo() : Int 
}


class Futbol extends Cancha{
  
  def costo(): Int = {
    return 40 * 10
  }
  
}

class Tenis extends Cancha{
  
  def costo(): Int = {
    return 150
  } 
}

class Paddle extends Cancha{
  
  def costo(): Int = {
    return 100
  }
}