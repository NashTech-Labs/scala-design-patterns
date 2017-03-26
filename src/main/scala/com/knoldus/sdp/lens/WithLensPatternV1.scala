package com.knoldus.sdp.lens

/**
  * Created by harmeet on 26/3/17.
  */

package WithLensPatternV1 {

  import scalaz.Lens

  case class Country(code: String, name: String)

  case class City(name: String, country: Country)

  case class Address(number: String, street: String, city: City)

  case class Company(name: String, address: Address)

  case class User(name: String, company: Company, address: Address)

  object WithLensPatternV1 extends App {
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
    val userCompany = Lens.lensu[User, Company](
      (u, company) => u.copy(company = company), _.company
    )

    val userAddress = Lens.lensu[User, Address](
      (u, address) => u.copy(address = address), _.address
    )

    val companyAddress = Lens.lensu[Company, Address](
      (c, address) => c.copy(address = address), _.address
    )

    val addressCity = Lens.lensu[Address, City](
      (a, city) => a.copy(city = city), _.city
    )

    val cityCountry = Lens.lensu[City, Country](
      (c, country) => c.copy(country = country), _.country
    )

    val countryName = Lens.lensu[Country, String](
      (c, name) => c.copy(name = name), _.name
    )

    val countryCode = Lens.lensu[Country, String](
      (c, code) => c.copy(code = code), _.code
    )

    val userCompanyCountryCode = userCompany >=> companyAddress >=> addressCity >=> cityCountry >=> countryCode
    val userCompanyCountryName = userCompany >=> companyAddress >=> addressCity >=> cityCountry >=> countryName

    val moveHarmeetCode = userCompanyCountryCode.set(harmeet, "CA")
    val moveHarmeetName = userCompanyCountryName.set(moveHarmeetCode, "Canada")

    println(moveHarmeetName)
  }

}
