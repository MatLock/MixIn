/**
 * @author: MatLock
 */
package test
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import traits._
import classes._
import scala.collection.mutable._
import excepciones._


@RunWith(classOf[JUnitRunner])
class CanchaTest extends FlatSpec with ShouldMatchers {
  
				/**  SET UP!     */
				val listaDeRf1 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRf2 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRf3 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRf4 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRf5 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRf6 =  Map[Int,ArrayBuffer[Int]]()
				
				val listaDeRt =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRt1 =  Map[Int,ArrayBuffer[Int]]()
                val listaDeRt2 =  Map[Int,ArrayBuffer[Int]]()
				val listaDeRt3 =  Map[Int,ArrayBuffer[Int]]()
                val listaDeRt4 =  Map[Int,ArrayBuffer[Int]]()
                val listaDeRt5 =  Map[Int,ArrayBuffer[Int]]()
   				
				 
				//CANCHAS DE FUTBOL
				
				val canchaFutbol = new Futbol("futbol1",listaDeRf1) with Iluminado with ConTecho with conTribuna
				val canchaFutbol2 = new Futbol("futbol2",listaDeRf2) with Iluminado with ConTecho
				val canchaFutbol3 = new Futbol("futbol3",listaDeRf3)
				val canchaFutbol4 = new Futbol("futbol4",listaDeRf4) with ConTecho
				val canchaFutbol5 = new Futbol("futbol5",listaDeRf5) with conTribuna
				val canchaFutbol6 = new Futbol("futbol6",listaDeRf6) with ConTecho with conTribuna
				/* tiene que retornar error Excepcion! son las 22 horas" */
				
	            
	            
	            //CANCHAS DE TENIS
	            val canchaTenis = new Tenis("tenis1",listaDeRt)
	            val canchaTenis1 = new Tenis("tenis2",listaDeRt1) with ConTecho
	            val canchaTenis2 = new Tenis("tenis3",listaDeRt2) with conTribuna
	            val canchaTenis3 = new Tenis("tenis4",listaDeRt3) with conTribuna with ConTecho 
	            val canchaTenis4 = new Tenis("tenis5",listaDeRt4) with conTribuna with ConTecho with Iluminado
	            val canchaTenis5 = new Tenis("tenis6",listaDeRt5) with conTribuna with ConTecho with Iluminado
	      
	            
	            val club = new Club("El grillo")
				
				club.canchas += canchaFutbol
				club.canchas += canchaFutbol2
				club.canchas += canchaFutbol3
				club.canchas += canchaFutbol4
				club.canchas += canchaFutbol5
				club.canchas += canchaFutbol6		
				
				
				club.canchas += canchaTenis
				club.canchas += canchaTenis1
				club.canchas += canchaTenis2
				club.canchas += canchaTenis3
				club.canchas += canchaTenis4
				club.canchas += canchaTenis5
	    
				
	     	 /** Test!!  Precio **/
		        "El costo de futbol1 " should "ser  1056" in {
				club.reservar("titular", 8, 20, "futbol1")
				val reserva = club.reservas find {a => a.titular.equals("titular")}
		    	reserva.get.costo should equal(1056.0)
			}

	
			/** Test!!  Precio **/		
				"El costo de futbol2" should "be 528" in {
			    club.reservar("titular1", 8, 21, "futbol2")
		  		val reserva = club.reservas find {a => a.titular.equals("titular1")}
		  		reserva.get.costo should equal(528.0)
		 	}		
		
			/** Test!!  Precio **/		
				"El costo de futbol3" should "be 400" in {
				club.reservar("titular2", 8, 6, "futbol3")
		  		val reserva = club.reservas find {a => a.titular.equals("titular2")}
		  		reserva.get.costo should equal(400.0)
		 }
		 
		 
		 	/** Test!!  Precio **/		
				"El costo de futbol4" should "be 400" in {
				club.reservar("titular3", 8, 6, "futbol4")
		  		val reserva = club.reservas find {a => a.titular.equals("titular3")}
		  		reserva.get.costo should equal(440.00000000000006)
		 	}
		 	
		 	/** Test!!  Precio **/		
				"El costo de futbol5" should "be 800" in {
				club.reservar("titular4", 8, 6, "futbol5")		
		  		val reserva = club.reservas find {a => a.titular.equals("titular4")}
		  		reserva.get.costo should equal(800.0)
		 	}		 	
		 		 	
		 	
		 	/** Test!!  Precio **/	
				"El costo de tenis" should "be 150" in{
				club.reservar("titular6",14,10,"tenis1")
		 		val reserva = club.reservas find {a => a.titular.equals("titular6")}
		  		reserva.get.costo should equal(150.0)
		  	}		 	
		 	
		 	/** Test!!  Precio **/	
				"El costo de tenis2" should "be 165" in{
				club.reservar("titular7",14,10,"tenis2")
		 		val reserva = club.reservas find {a => a.titular.equals("titular7")}
		  		reserva.get.costo should equal(165.0)
		  	}		     
		
			/** Test!!  Precio **/	
				"El costo de tenis3" should "be 300" in{
				club.reservar("titular8",14,10,"tenis3")
		 		val reserva = club.reservas find {a => a.titular.equals("titular8")}
		  		reserva.get.costo should equal(300.0)
		  	}	     
		  
		   /** Test!!  Precio **/	
				"El costo de tenis4" should "be 330" in{
				club.reservar("titular9", 14, 10, "tenis4") //El dia 14 llueve
		 		val reserva = club.reservas find {a => a.titular.equals("titular9")}
		  		reserva.get.costo should equal(330.0)
		  	}
		  	
		  	/** Test!!  Precio **/	
				"El costo de tenis4 SinLluvia" should "be 150" in{
				club.reservar("titular10", 13, 10, "tenis4") //El dia 13 no llueve
		 		val reserva = club.reservas find {a => a.titular.equals("titular10")}
		  		reserva.get.costo should equal(150.0)
		  	}
				
			/** Test!!  Precio **/	
				"El costo de tenis5" should "be 396" in{
				club.reservar("titular11", 14, 23, "tenis5") //Con iluminacion lluvia y finde  
		 		val reserva = club.reservas find {a => a.titular.equals("titular11")}
		  		reserva.get.costo should equal(396.0)
		  	}
		  		    
			/** Testeo de Excepciones **/
				
			intercept[CanchaSinIluminacionException]{
		    club.reservar("titular5",10,22,"futbol6")
			}
			
			intercept[HorarioYaSeleccionadoException]{
			club.reservar("titular10", 1, 1, "tenis5")
			club.reservar("titular10", 1, 1, "tenis5")
			}
		
}
	
