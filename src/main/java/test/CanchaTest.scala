package test
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable._
import traits._
import classes._



class CanchaTest extends FlatSpec with ShouldMatchers {
  
	def elClub = 
			new{
				val listaDeR =  Map[Int,ArrayBuffer[Int]]()
				val canchaFutbol = new Futbol("futbol1",listaDeR) with Iluminado with ConTecho with conTribuna
	            val club = new Club("El grillo")
				club.canchas += canchaFutbol
				//club.reservar("titular", 8, 20, "futbol1")
				//val reserva = club.reservas find {a => a.titular.equals("titular")}

	  
	  
		}
  
  
		"reservar from futbol1" should "be 1056" in {
			elClub.club.reservar("titular", 8, 20, "futbol1")
			val reserva = elClub.club.reservas find {a => a.titular.equals("titular")}
		    reserva.get.costo should equal(1056.0)
		}
	

	
}