package com.knoldus.sdp.lens

/**
  * Created by harmeet on 26/3/17.
  */
package WithLensPatternV2 {

  import monocle.Lens
  import monocle.macros.GenLens

  case class Country(code: String, name: String)

  case class City(name: String, country: Country)

  case class Address(number: String, street: String, city: City)

  case class Company(name: String, address: Address)

  case class User(name: String, company: Company, address: Address)

  object WithLensPatternV2 extends App {

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
    val userCompany: Lens[User, Company] = GenLens[User](_.company)
    val userAddress = GenLens[User](_.address)
    val companyAddress = GenLens[Company](_.address)
    val addressCity = GenLens[Address](_.city)
    val cityCountry = GenLens[City](_.country)
    val countryCode = GenLens[Country](_.code)
    val countryName = GenLens[Country](_.name)

    val userCompanyCountryCode = userCompany composeLens companyAddress composeLens addressCity composeLens cityCountry composeLens countryCode
    val userCompanyCountryName = userCompany composeLens companyAddress composeLens addressCity composeLens cityCountry composeLens countryName

    val moveHarmeetCode = userCompanyCountryCode.set("CA")(harmeet)
    val moveHarmeetName = userCompanyCountryName.set("Canada")(moveHarmeetCode)

    println(moveHarmeetName)
  }

}