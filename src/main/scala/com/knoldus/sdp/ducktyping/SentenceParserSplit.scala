package com.knoldus.sdp.ducktyping

/**
  * Created by harmeet on 28/3/17.
  */
class SentenceParserSplit {

  def parse(sentence: String): Array[String] = sentence.split("\\s+")
}
