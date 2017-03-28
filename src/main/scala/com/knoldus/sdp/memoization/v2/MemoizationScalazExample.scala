package com.knoldus.sdp.memoization.v2


/**
  * Created by Harmeet Singh(Taara) on 28/3/17.
  */
object MemoizationScalazExample extends App {

  val hasher = new Hasher

  println(s"Encode for 'hello' is '${hasher.memoMd5Scalaz("hello")}'")
  println(s"Encode for 'bye' is '${hasher.memoMd5Scalaz("bye")}'")
  println(s"Encode for 'hello1' is '${hasher.memoMd5Scalaz("hello1")}'")
  println(s"Encode for 'hello' is '${hasher.memoMd5Scalaz("hello")}'")
  println(s"Encode for 'bye' is '${hasher.memoMd5Scalaz("bye")}'")
}
