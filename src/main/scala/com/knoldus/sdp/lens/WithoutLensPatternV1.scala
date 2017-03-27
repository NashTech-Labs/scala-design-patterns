package com.knoldus.sdp.lens

/**
  * Created by Harmeet Singh(Taara) on 26/3/17.
  */
package WithoutLensPatternV1 {

  case class Country(code: String, name: String)

  case class City(name: String, country: Country)

  case class Address(number: String, street: String, city: City)

  case class Company(name: String, address: Address)

  case class User(name: String, company: Company, address: Address)


  object WithoutLensPatternV1 extends App {

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
    val moveHarmeet = harmeet.copy(
      company = harmeet.company.copy(
        address = harmeet.company.address.copy(
          city = harmeet.company.address.city.copy(
            country = harmeet.company.address.city.country.copy(
              name = "Canada", code = "CA"
            )
          )
        )
      )
    )

    println(moveHarmeet)
  }
}