package traits


trait Lluvioso{

  def costoPorClima():Double = {
    return 1.1
  }
}

 trait Soleado{
    def costoPorClima():Double = {
     return 1
   }
 }
 
 // ILUMINACION //
 
 trait Iluminada{
  def costoIluminacion():Double ={
     return 1.2
   }
 }
 
 trait SinIluminacion{
   def costoIluminacion():Double ={
     return 1
   }
 }