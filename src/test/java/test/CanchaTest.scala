package test
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import traits._
import classes._
import scala.collection.mutable._


@RunWith(classOf[JUnitRunner])
class CanchaTest extends FlatSpec with ShouldMatchers {
  

				val listaDeR =  Map[Int,ArrayBuffer[Int]]()
				val canchaFutbol = new Futbol("futbol1",listaDeR) with Iluminado with ConTecho with conTribuna
	            val club = new Club("El grillo")
				club.canchas += canchaFutbol
				//club.reservar("titular", 8, 20, "futbol1")
				//val reserva = club.reservas find {a => a.titular.equals("titular")}
				club.reservar("titular", 8, 20, "futbol1")

	    
		    "reservar from futbol1" should "be 1056" in {
			val reserva = club.reservas find {a => a.titular.equals("titular")}
			println(reserva.get.costo)
		    reserva.get.costo should equal(1056.0)
		}

	
}