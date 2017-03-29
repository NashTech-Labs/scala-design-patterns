package com.knoldus.sdp.aop

/**
  * Created by harmeet on 29/3/17.
  */
case class Person (name: String)

trait PersonDAO {
  def readDataFromDatabase: List[Person]
}

class PersonDAOImplWithoutAOP extends PersonDAO{

  def readDataFromDatabase: List[Person] = {
    println("In PersonDAOImplWithoutAOP ... ")

    val starttime = System.currentTimeMillis()
    println("Start reading data from database ..... ")
    Thread.sleep(3000)
    println("End reading data from database ..... ")
    val totalTime = System.currentTimeMillis() - starttime
    println(s"It tooks $totalTime milliseconds ... ")

    List(Person("Knoldus"), Person("James"), Person("Taara"))
  }
}

class PersonDAOImplWithAOP extends PersonDAO{

  def readDataFromDatabase: List[Person] = {
    println("In PersonDAOImplWithAOP ... ")

    println("Start reading data from database ..... ")
    Thread.sleep(3000)

    List(Person("Knoldus"), Person("James"), Person("Taara"))
  }
}

object WithoutAOPExample extends App {

  new PersonDAOImplWithoutAOP().readDataFromDatabase
  println()
  val string =
    """
      |  /$$$$$$   /$$$$$$  /$$$$$$$
      | /$$__  $$ /$$__  $$| $$__  $$
      || $$  \ $$| $$  \ $$| $$  \ $$
      || $$$$$$$$| $$  | $$| $$$$$$$/
      || $$__  $$| $$  | $$| $$____/
      || $$  | $$| $$  | $$| $$
      || $$  | $$|  $$$$$$/| $$
      ||__/  |__/ \______/ |__/
    """.stripMargin
  println(string)
  println()
  (new PersonDAOImplWithAOP with LoggingPersonDAOReader).readDataFromDatabase
}
