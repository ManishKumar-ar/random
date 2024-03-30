package com.example.navigation24.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation24.R


@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size

        items(itemCount) {
            ColumnItem(
                modifier,
                painter = imageId,
                title = names,
                ingredients = ingredients,
                itemIndex = it,
                navController = navController
            )
        }
    }

}





@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController

) {


    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth().height(140.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp),
                contentScale = ContentScale.Crop


            )
            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = ingredients[itemIndex], fontSize = 18.sp)

            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun TopScreen2() {

    val imageId = arrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6
    )

    val names = arrayOf(
        "Peperoni",
        "Vegan",
        "FourCheese",
        "Margaritta",
        "American",
        "Mexican"
    )

    val ingredients = arrayOf(
        "Tomato sos, cheese, oregano, peperoni",
        "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
        "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
        "Tomato sos, cheese, oregano, bazillion",
        "Tomato sos, cheese, oregano, green paprika, red beans",
        "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
    )

    val navController = rememberNavController()
    NavHost(navController =navController , startDestination ="MainScreen" ) {

        composable(route ="MainScreen"){
            MainScreen(imageId, names , ingredients ,navController )
        }

        composable(route ="DetailScreen"){

        }


    }


}