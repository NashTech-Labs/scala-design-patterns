package com.knoldus.sdp.typeclass.v2

import simulacrum.{op, typeclass}

/**
  * Created by Harmeet Singh(Taara) on 27/3/17.
  */
@typeclass trait Number[T] {

  @op("+") def plus(t1: T, t2: T): T
  @op("-") def minus(t1: T, t2: T): T
  @op("/") def divide(t1: T, t2: Int): T
  @op("*") def multiply(t1: T, t2: T): T
  @op("^") def sqrt(t1: T): T
}

object Number {
  implicit object DoubleNumber extends Number[Double] {
    override def plus(t1: Double, t2: Double): Double = t1 + t2
    override def minus(t1: Double, t2: Double): Double = t1 - t2
    override def divide(t1: Double, t2: Int): Double = t1 / t2
    override def multiply(t1: Double, t2: Double): Double = t1 * t2
    override def sqrt(t1: Double): Double = Math.sqrt(t1)
  }

  implicit object IntNumber extends Number[Int] {
    override def plus(t1: Int, t2: Int): Int = t1 + t2
    override def minus(t1: Int, t2: Int): Int = t1 - t2
    override def divide(t1: Int, t2: Int): Int = t1 / t2
    override def multiply(t1: Int, t2: Int): Int = t1 * t2
    override def sqrt(t1: Int): Int = Math.sqrt(t1).toInt
  }
}