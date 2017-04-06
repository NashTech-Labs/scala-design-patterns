package com.knoldus.sdp.aop

/**
  * Created by Harmeet Singh(Taara) on 30/3/17.
  */
trait LoggingPersonDAOReader extends PersonDAO {

  override abstract def readDataFromDatabase: List[Person] = {
    val starttime = System.currentTimeMillis()
    val result = super.readDataFromDatabase
    val totalTime = System.currentTimeMillis() - starttime
    println(s"It tooks $totalTime milliseconds ... ")
    result
  }
}
