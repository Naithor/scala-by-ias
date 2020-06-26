package sesion1

import scala.annotation.tailrec
import scala.io.StdIn

object multiplication extends App {
  println("Ingrersa un numero")
  val number = StdIn.readInt()

  multiplication(number)

  def multiplication(number: Int): Unit = {
    val INCREMENTER_BY = 1

    @tailrec
    def recursionMultiplication(incrementer: Int): Unit = {
      if (incrementer <= 12) {
        println(s"$number x $incrementer = ${number * incrementer}")
        recursionMultiplication(incrementer + INCREMENTER_BY)
      }
    }

    recursionMultiplication(INCREMENTER_BY)
  }
}
