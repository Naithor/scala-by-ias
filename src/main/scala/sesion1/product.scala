package sesion1

import scala.annotation.tailrec
import scala.io.StdIn

object product extends App {
  println("Ingrese un numero")
  val number = StdIn.readInt()

  product(number)

  def product(number: Int): Unit = {
    val INCREMENTER_BY = 1

    @tailrec
    def recursionProduct(incrementer: Int, product: Int): Unit = {
      if (incrementer <= 12) {
        println(f"${number} x ${incrementer}%-2s = ${product}%2d")
        recursionProduct(incrementer + INCREMENTER_BY, product + number)
      }
    }

    recursionProduct(INCREMENTER_BY, number)
  }
}
