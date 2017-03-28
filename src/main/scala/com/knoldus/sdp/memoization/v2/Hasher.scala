package com.knoldus.sdp.memoization.v2

import java.util.Base64

import scalaz.Memo

/**
  * Created by Harmeet Singh(Taara) on 28/3/17.
  */
class Hasher {

  val memoMd5Scalaz: String => String = Memo.mutableHashMapMemo(md5)

  private def md5(input: String) = {
    println(s"Calling md5 for $input")
    new String(Base64.getEncoder.encode(input.getBytes()))
  }
}
