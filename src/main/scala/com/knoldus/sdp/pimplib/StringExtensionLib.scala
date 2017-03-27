package com.knoldus.sdp.pimplib

/**
  * Created by Harmeet Singh(Taara) on 26/3/17.
  */
package object pimplib {

  implicit class StringExtension(val string: String) extends AnyVal {
    def isAllUperCase: Boolean = {
      (0 to string.size - 1 ) find {
        case index => !string.charAt(index).isUpper
      }
    }.isEmpty
  }
}
object StringExtensionLib extends App {

  import pimplib._

  var string = "test"
  println(s"${string} is all upper ${string.isAllUperCase}")
  string = "Test"
  println(s"${string} is all upper ${string.isAllUperCase}")
  string = "TESt"
  println(s"${string} is all upper ${string.isAllUperCase}")
  string = "TEST"
  println(s"${string} is all upper ${string.isAllUperCase}")
}
