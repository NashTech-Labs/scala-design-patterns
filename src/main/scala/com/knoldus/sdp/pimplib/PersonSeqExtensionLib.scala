package com.knoldus.sdp.pimplib

/**
  * Created by harmeet on 26/3/17.
  */
case class Person(name: String)

package object seqlib {
  implicit class PersonSeqExtension(val seq: Iterable[Person]) extends AnyVal {
    def saveAll: Unit = {
      seq foreach { person =>
        println(s"${person} saved succcessfully ... ")
      }
    }
  }
}

object PersonSeqExtensionLib extends App {

  import seqlib._

  val personsList = List(Person("James"), Person("Taara"), Person("Harmeet"))
  val personSet = Set(Person("Knoldus"), Person("Vikas"), Person("Scala"))

  personsList.saveAll
  personSet.saveAll
}
