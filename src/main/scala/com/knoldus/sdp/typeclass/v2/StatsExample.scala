package com.knoldus.sdp.typeclass.v2


/**
  * Created by Harmeet Singh(Taara) on 27/3/17.
  */
class StatsExample {

  import Number.ops._

  def mean[T: Number] (xs: Vector[T]): T = xs.reduce(_ + _) / xs.size

  //assume vector is in sorted order
  def median[T: Number] (xs: Vector[T]): T = xs(xs.size / 2)
}

object StatsExample extends App {


  val intVector = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 21, 22, 23, 24, 25)
  val doubleVector = Vector(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0,
    20.0, 21.0, 22.0, 23.0, 24.0, 25.0)

  val example = new StatsExample
  println(s"Mean (int) ${example.mean(intVector)}")
  println(s"Median (int) ${example.median(intVector)}")

  println(s"Mean (double) ${example.mean(doubleVector)}")
  println(s"Median (double) ${example.median(doubleVector)}")
}
