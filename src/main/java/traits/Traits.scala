package traits
import classes._

trait ConTecho extends Cancha {
  
 override def precio(dia :Int, hora :Int) :Double ={
   if(new Pronosticador().getClima(dia).equals("Lluvia")){
	   return super.precio(dia,hora) * 1.1
   };return super.precio(dia,hora)
 }
 
 override def chequearHorario(hora :Int){}
}


trait Iluminado extends Cancha{
  
 override def precio(dia :Int, hora :Int):Double = {
    if(hora > 18){
    	return super.precio(dia,hora) * 1.2
    }
    return super.precio(dia,hora)
 }
}
 
 
trait conTribuna extends Cancha{
  
   override def precio(dia :Int, hora :Int):Double ={
     if (new Pronosticador().dia(dia).equals("FinDeSemana")){
       return super.precio(dia,hora)* 2
     }
     return super.precio(dia,hora)
   }
 }
  
 
 