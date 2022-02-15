package com.bobafett.instantmenu.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bobafett.instantmenu.ItemHighlight
import com.bobafett.instantmenu.android.ui.theme.Instant_MenuTheme
import com.bobafett.instantmenu.android.ui.theme.OfferWhite
import com.bobafett.instantmenu.core.menu.datasource.network.BeerItem
import com.bobafett.instantmenu.core.menu.datasource.network.MenuItem
import com.bobafett.instantmenu.fakes.ItemListFactory.itemMap

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Instant_MenuTheme {
            }
        }
    }
}

@Composable
private fun ItemRow(items: List<MenuItem>) {
    // Lazy Row Background
    Surface {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = items) { item ->
                Item(
                    item,
                    Modifier.width(250.dp)
                )
            }
        }
    }
}

@Composable
private fun ItemColumn(names: List<String> = List(1000) { "$it" }) {
    // Lazy Row Background
    Surface(color = Color.Blue) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(items = names) { name ->
                Item(
                    MenuItem(
                        id = 1,
                        name = "Chicken Pot Pie",
                        description = "tender chicken, butternut squash, yukon gold potatoes,",
                        price = "5.00",
                        imageUrl = "",
                        tags = listOf(ItemHighlight.Spicy, ItemHighlight.Spicy),
                        category = "Sandwich"
                    ),
                    Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.colorPrimaryDark))
                )
            }
        }
    }
}

@Composable
fun Item(item: MenuItem, modifier: Modifier) {
    val highlightIcons = mapOf(
        ItemHighlight.Spicy to R.drawable.ic_spicy
    )
    Surface {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { /* Ignoring onClick */ })
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Box() {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.75f)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.eiliv_sonas_aceron_5nvt9brlaac_unsplash__1_),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.Center
                    )
                    if(item.tags.isNotEmpty()){
                        Card(
                            modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
                            backgroundColor = Color.Red,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(4.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                for (highlight in item.tags) {
                                    highlightIcons[highlight]?.let { icon ->
                                        Image(
                                            modifier = Modifier.size(18.dp, 18.dp),
                                            painter = painterResource(id = icon),
                                            contentDescription = "Spicy"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            item.name,
                            style = MaterialTheme.typography.h5,
                        )
                        Text(
                            item.price,
                            style = MaterialTheme.typography.body1,
                        )
                    }

                    Text(
                        item.description,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}

//@Preview(
//    showBackground = true,
//    widthDp = 320,
//    uiMode = UI_MODE_NIGHT_YES,
//    name = "DefaultPreviewDark"
//)
//@Preview(showBackground = true, widthDp = 640)
//@Composable
//fun DefaultPreview() {
//    Instant_MenuTheme {
//        ItemColumn()
//    }
//}

//@Preview(showBackground = true, widthDp = 640)
//@Composable
//fun ColumnPreview() {
//    Instant_MenuTheme {
//        ItemRow(500.dp)
//    }
//}


//@Preview(showBackground = true, widthDp = 400)
//@Composable
//fun ItemPreview() {
//    Instant_MenuTheme {
//        Item(
//            "Chicken Pot Pie",
//            "tender chicken, butternut squash, yukon gold potatoes, sweet peas, carrots, onions & herbs simmered in a velvety sauce, flaky pastry top",
//            "- 5.00",
//            Modifier.width(200.dp)
//        )
//    }
//}

@Composable
fun DividerButton(label: String) {
    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { /* Ignoring onClick */ })
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium)
            )
            Icon(
                Icons.Filled.ArrowForward,
                contentDescription = "",
            )
        }
    }
}


@Composable
fun DrinkItem(beerItem: BeerItem) {
    Surface() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.nb_logo),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(12.dp)
                    .wrapContentHeight()
                    .aspectRatio(1f)
                    .weight(.2f),
            )
            Column(
                modifier = Modifier
                    .weight(.4f)
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        fontSize = 20.sp,
                        text = beerItem.beerName,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(beerItem.abv)
                    Text(beerItem.beerType)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(beerItem.servingGlass)
                    Text(beerItem.price)
                }
            }
            Column(
                modifier = Modifier
                    .weight(.3f)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(beerItem.brewerName)
                Text(beerItem.brewerLocation)
            }
        }
    }
}


@Composable
fun HomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            IconTab()
            LazyColumn(
                contentPadding = PaddingValues(vertical = 0.dp),
            ) {
                item {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Card(
                            backgroundColor = OfferWhite,
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                contentDescription = "",
                                painter = painterResource(id = R.drawable.banner),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(2f)
                                    .padding(16.dp)
                            )
                        }
                    }
                }

                items(items = itemMap.keys.toList()) { category ->
                    DividerButton(category)
                    ItemRow(itemMap.getValue(category))
                }
            }
        }
    }
}

@Composable
fun DrinkScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 0.dp),
        ) {

            item {
                Text(
                    text = "What's On Tap"
                )
            }

            items(20) {
                DrinkItem(
                    BeerItem(
                        id = 2,
                        beerName = "Fat Tire",
                        abv = "5.2% ABV",
                        price = "$7.00",
                        beerType = "Amber Ale",
                        brewerLocation = "Fort Collins, CO",
                        brewerName = "New Belgium",
                        servingGlass = "Pint"
                    )
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun LayoutsCodelab() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("TopAppBar") }) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Food.route) {
        composable(NavigationItem.Food.route) {
            HomeScreen()
        }
        composable(NavigationItem.Drinks.route) {
            DrinkScreen()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun LayoutsCodelabPreview() {
    Instant_MenuTheme {
        LayoutsCodelab()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
fun DrinkPreview() {
    Instant_MenuTheme {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 0.dp),
        ) {
            items(5) {
                DrinkItem(
                    BeerItem(
                        id = 2,
                        beerName = "Fat Tire",
                        abv = "5.2% ABV",
                        price = "$7.00",
                        beerType = "Amber Ale",
                        brewerLocation = "Fort Collins, CO",
                        brewerName = "New Belgium",
                        servingGlass = "Pint"
                    )
                )
            }
        }
    }
}

@Preview()
@Composable
fun TabPreview() {
    Instant_MenuTheme {
        IconTab()
    }
}

@Composable
fun IconTab(items: List<TabItem> = listOf(TabItem.Home, TabItem.Vegan, TabItem.Free)) {
    var tabIndex by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = tabIndex) {
        items.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = pair.title)
            }
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Food,
        NavigationItem.Drinks
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

