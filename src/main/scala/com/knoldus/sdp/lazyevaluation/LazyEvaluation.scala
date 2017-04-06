package com.knoldus.sdp.lazyevaluation

/**
  * Created by Harmeet Singh(Taara) on 29/3/17.
  */
case class Person(name: String)
class PersonService {
  def getFromDatabase: List[Person] = {
    println("Start fetching data .... ")
    Thread.sleep(3000)
    List(Person("Knoldus"), Person("James"), Person("Taara"))
  }

  def withoutLazyEvaluation(persons: => List[Person]) = {
    println(s"Evaluate Without Lazy First Time ${persons}")
    println(s"Evaluate Without Lazy Second Time ${persons}")
  }

  def withLazyEvaluation(persons: => List[Person]) = {
    lazy val personsCopy = persons
    println(s"Evaluate With Lazy First Time ${personsCopy}")
    println(s"Evaluate With Lazy Second Time ${personsCopy}")
  }
}
object LazyEvaluation extends App {

  val service = new PersonService()
  service.withoutLazyEvaluation(service.getFromDatabase)
  service.withLazyEvaluation(service.getFromDatabase)
}
