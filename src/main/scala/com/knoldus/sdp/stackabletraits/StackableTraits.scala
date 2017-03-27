package com.knoldus.sdp.stackabletraits

/**
  * Created by Harmeet Singh(Taara) on 26/3/17.
  */
trait StringWriter {
  def write(str: String): String
}

class BasicWriter extends StringWriter {
  override def write(str: String) = s"Write the following string '${str}'"
}

trait CapitalizingStringLetter extends StringWriter {
  abstract override def write(str: String) = {
    super.write(str.split("\\s+").map(_.capitalize).mkString(" "))
  }
}

trait LowerCaseStringLetter extends StringWriter {
  abstract override def write(str: String) = super.write(str.toLowerCase)
}

trait UpperCaseStringLetter extends StringWriter {
  abstract override def write(str: String) = super.write(str.toUpperCase)
}

object StackableTraits extends App {

  val writer1 = new BasicWriter with UpperCaseStringLetter with CapitalizingStringLetter
  val writer2 = new BasicWriter with CapitalizingStringLetter with LowerCaseStringLetter
  val writer3 = new BasicWriter with UpperCaseStringLetter with LowerCaseStringLetter with CapitalizingStringLetter
  val writer4 = new BasicWriter with LowerCaseStringLetter with CapitalizingStringLetter with UpperCaseStringLetter

  println(s"Writer 1: ${writer1.write("Ticket to Canada .... ")}")
  println(s"Writer 2: ${writer2.write("Ticket to Canada .... ")}")
  println(s"Writer 3: ${writer3.write("Ticket to Canada .... ")}")
  println(s"Writer 4: ${writer4.write("Ticket to Canada .... ")}")
}
