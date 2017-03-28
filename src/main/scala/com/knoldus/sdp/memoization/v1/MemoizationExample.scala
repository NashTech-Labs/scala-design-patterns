package com.knoldus.sdp.memoization.v1

/**
  * Created by Harmeet Singh(Taara) on 28/3/17.
  */
object MemoizationExample extends App {


  val hasher = new Hasher

  println(s"Encode for 'hello' is '${hasher.memoMd5("hello")}'")
  println(s"Encode for 'bye' is '${hasher.memoMd5("bye")}'")
  println(s"Encode for 'hello1' is '${hasher.memoMd5("hello1")}'")
  println(s"Encode for 'hello' is '${hasher.memoMd5("hello")}'")
  println(s"Encode for 'bye' is '${hasher.memoMd5("bye")}'")

}
