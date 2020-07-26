package sesion2

import scala.annotation.tailrec

object dcCombat extends App {
  class Character(val name: String, val healthPoint: Int, val attack: Int, val resistance: Int) {
    def attack(character: Character): Character = {
      new Character(character.name, calculateHealthPoint(character), character.attack, character.resistance)
    }

    def calculateDamage(character: Character): Int = {
      this.attack - character.resistance
    }

    def calculateHealthPoint(character: Character): Int = {
      character.healthPoint - calculateDamage(character)
    }

    override def toString: String = {
      s"Personaje: ${this.name} \nPuntos de vida: ${this.healthPoint} \nAtaque: ${this.attack} \nResistencia: ${this.resistance}"
    }
  }

  def keepFighting(character1: Character, character2: Character): Boolean = {
    character1.healthPoint > 0 && character2.healthPoint > 0
  }

  def attackingMessage(character1: Character, character2: Character, counter: Int): String = {
    s"Round ${counter}: ${character1.name} ataca a ${character2.name}"
  }

  def fight(character1: Character, character2: Character): Unit = {

    @tailrec
    def recursionFight(character1: Character, character2: Character, counter: Int): Unit = {
      println(s"${character1}\n\n${character2}\n")

      if (!keepFighting(character1, character2)) {
        println(s"Vencedor: ${if (character1.healthPoint >= 0) character1.name else character2.name}")
      }
      else {
        if (counter % 2 == 0) {
          println(attackingMessage(character2, character1, counter))
          recursionFight(character2.attack(character1), character2, counter + 1)
        } else {
          println(attackingMessage(character1, character2, counter))
          recursionFight(character1, character1.attack(character2), counter + 1)
        }
      }
    }

    println(s"${character1.name} vs ${character2.name}\n")
    recursionFight(character1, character2, 1)
  }

  val superman = new Character("Superman", 100, 30, 15)
  val batman = new Character("Batman", 100, 25, 13)

  fight(batman, superman)
//  fight(superman, batman)
}
