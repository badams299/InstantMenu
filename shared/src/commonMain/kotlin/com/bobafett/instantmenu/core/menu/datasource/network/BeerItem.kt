package com.bobafett.instantmenu.core.menu.datasource.network

import kotlinx.serialization.Serializable

@Serializable
data class BeerItem(
    val id: Int,
    val beerName: String,
    val beerType: String,
    val abv : String,
    val price : String,
    val servingGlass : String,
    val brewerName : String,
    val brewerLocation : String
)