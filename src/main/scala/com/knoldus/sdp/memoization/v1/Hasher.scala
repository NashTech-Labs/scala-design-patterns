package com.knoldus.sdp.memoization.v1

import java.util.Base64

import scala.collection.mutable

/**
  * Created by Harmeet Singh(Taara) on 28/3/17.
  */
class Hasher extends Memoizer {

  val memoMd5 = memo(md5)

  private def md5(input: String) = {
    println(s"Calling md5 for $input")
    new String(Base64.getEncoder.encode(input.getBytes()))
  }
}

trait Memoizer {

  def memo[X, Y](f: X => Y): X => Y = {
    val cache = mutable.Map[X, Y]()
    (x: X) => cache.getOrElseUpdate(x, f(x))
  }
}