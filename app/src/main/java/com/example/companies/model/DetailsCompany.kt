package com.example.companies.model

//"id", "name","img","description","lat","lon","www","phone"
data class DetailsCompany(
    val id: String,
    val name: String,
    val img: String,
    val description: String,
    val lat: Double, //Latitude
    val lon: Double, //Longitude
    val www: String, //Website
    val phone: String //Phone
)
