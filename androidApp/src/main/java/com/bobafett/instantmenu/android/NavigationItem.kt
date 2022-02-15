package com.bobafett.instantmenu.android

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Food : NavigationItem("food", R.drawable.ic_food, "Food")
    object Drinks : NavigationItem("drinks", R.drawable.ic_drink, "Drinks")
}