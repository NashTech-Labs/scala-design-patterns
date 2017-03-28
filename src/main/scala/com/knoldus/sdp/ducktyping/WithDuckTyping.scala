package com.knoldus.sdp.ducktyping

/**
  * Created by Harmeet Singh(Taara) on 28/3/17.
  */
object WithDuckTyping {

  def printSentenceParser(sentence: String,
                          parser: {def parse(sentence: String): Array[String]}) = {
    parser.parse(sentence).foreach(println)
  }

  def main(args: Array[String]): Unit = {
    val tokenizerParser = new SentenceParserTokenize
    val splitParser = new SentenceParserSplit

    val sentence = "This is the sentence we will be splitting"

    println("Using the tokenizer parser ... ")
    printSentenceParser(sentence, tokenizerParser)

    println("Using the split parser ... ")
    printSentenceParser(sentence, splitParser)
  }
}
