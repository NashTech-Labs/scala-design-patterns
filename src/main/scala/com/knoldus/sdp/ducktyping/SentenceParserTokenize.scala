package com.knoldus.sdp.ducktyping

import java.util.StringTokenizer

/**
  * Created by harmeet on 28/3/17.
  */
class SentenceParserTokenize {

  def parse(sentence: String): Array[String] = {
    val tokenizer = new StringTokenizer(sentence)
    Iterator.continually({
      val hasMore = tokenizer.hasMoreTokens
      if(hasMore) {
        (hasMore, tokenizer.nextToken())
      } else {
        (hasMore, null)
      }
    }).takeWhile(_._1).map(_._2).toArray
  }
}
