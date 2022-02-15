package com.bobafett.instantmenu.fakes

import com.bobafett.instantmenu.ItemHighlight
import com.bobafett.instantmenu.core.menu.datasource.network.MenuItem

object ItemListFactory {
    val items = listOf(
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(ItemHighlight.Spicy),
            category = "Hand Crafted Sandwiches"
        ),
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(),
            category = "Hand Crafted Sandwiches"
        ),
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(),
            category = "Best Burgers"
        ),
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(),
            category = "Best Burgers"
        ),
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(ItemHighlight.Spicy, ItemHighlight.Spicy),
            category = "Speciality Plates"
        ),
        MenuItem(
            id = 1,
            name = "Chicken Pot Pie",
            description = "tender chicken, butternut squash, yukon gold potatoes,",
            price = "5.00",
            imageUrl = "",
            tags = listOf(ItemHighlight.Spicy, ItemHighlight.Spicy),
            category = "Speciality Plates"
        )
    )

    val itemMap : Map<String, List<MenuItem>> = items.groupBy { it.category }
}