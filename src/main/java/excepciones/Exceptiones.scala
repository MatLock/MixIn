package excepciones

class HorarioYaSeleccionadoException(mensaje :String) extends RuntimeException(mensaje) {
  

}

class CanchaSinIluminacionException(mensaje :String) extends RuntimeException(mensaje){
  
}

class CanchaSinTechoException(mensaje :String) extends RuntimeException(mensaje){
  
}