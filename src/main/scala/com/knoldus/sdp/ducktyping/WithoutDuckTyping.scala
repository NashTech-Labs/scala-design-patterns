package com.knoldus.sdp.ducktyping

/**
  * Created by harmeet on 28/3/17.
  */
object WithoutDuckTyping extends App {

  val tokenizerParser = new SentenceParserTokenize
  val splitParser = new SentenceParserSplit

  val sentence = "This is the sentence we will be splitting"

  println("Using the tokenizer parser ... ")
  tokenizerParser.parse(sentence).foreach(println)

  println("Using the split parser ... ")
  splitParser.parse(sentence).foreach(println)
}
