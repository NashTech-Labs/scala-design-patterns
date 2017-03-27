package com.knoldus.sdp.lens

/**
  * Created by Harmeet Singh(Taara) on 26/3/17.
  */
package WithoutLensPatternV2 {


  case class Country(var code: String, var name: String)

  case class City(var name: String, var country: Country)

  case class Address(var number: String, var street: String, var city: City)

  case class Company(var name: String, var address: Address)

  case class User(var name: String, var company: Company, var address: Address)

  object WithoutLensPatternV2 extends App {
    val uk = Country("United Kingdom", "UK")
    val london = City("London", uk)
    val buckinghamPalace = Address("1", "Buckingham Place Road", london)
    val company = Company("Knoldus", buckinghamPalace)

    val canada = Country("Canada", "CA")
    val toronto = City("Toronto", canada)
    val mcMurray = Address("2", "610 McMurray Rd", toronto)
    val harmeet = User("Harmeet Singh", company, mcMurray)

    println("************ Before Move ************")
    println(harmeet)

    println("************ Move to Canada ************")
    val moveHarmeet = harmeet
    moveHarmeet.company.address.city.country.code = "CA"
    moveHarmeet.company.address.city.country.name = "Canada"
    println(moveHarmeet)
  }

}