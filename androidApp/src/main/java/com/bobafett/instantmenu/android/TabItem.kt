package com.bobafett.instantmenu.android

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabItem(var icon: ImageVector, var title: String) {
    object Home : TabItem(Icons.Filled.Home, "Home")
    object Vegan : TabItem(Icons.Filled.ShoppingCart, "Vegan")
    object Free : TabItem(Icons.Filled.AccountBox, "Gluten Free")
}
