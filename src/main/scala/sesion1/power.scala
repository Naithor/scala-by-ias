package sesion1

import scala.annotation.tailrec
import scala.io.StdIn

object power extends App {
  println("Ingrese un numero")
  val number = StdIn.readInt()
  println("Ingrese el exponente")
  val exponent = StdIn.readInt()

  println(s"La potencia ${number} a la ${exponent} es igual a ${power(number, exponent)}")

  def power(number: Int, exponent: Int): Int = {
    @tailrec
    def recursionPower(power: Int, exponentReduced: Int): Int =
      exponentReduced match {
        case 0 => power
        case _ => recursionPower(power * number, exponentReduced - 1)
      }

    recursionPower(1, exponent)
  }
}
