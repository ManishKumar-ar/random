package com.example.navigation24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    private val namesList = names.map {
        Category(
            name = it.key.toString(),
            items = it.value
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Home") {

                composable(route ="Home"){
                    FirstApp( namesList=namesList, navController = navController)

                }
                composable(route ="DetailScreen"){
                    DetailScreen(navController)
                }

//            FirstApp( namesList=namesList)

        }
    }
}

data class Category(
    val name : String,
    val items: List<String>
)

@Composable
fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}
@Composable
fun CategoryItem(
    text: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .clickable {
                navController.navigate(route = "DetailScreen")
            }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorizedLazyColumn(
    categories: List<Category>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn (modifier){
        categories.forEach{category ->
            stickyHeader {
                CategoryHeader(category.name)
            }
            items(category.items){text ->
                CategoryItem(text, navController=navController)

            }

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstApp(
    modifier: Modifier = Modifier,namesList: List<Category>,navController: NavController
) {


    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier
//                    .padding(10.dp)
                    .clip(RoundedCornerShape(topEnd = 2.dp, topStart = 2.dp)),
                containerColor = Color(0xFFFF9800)
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    IconButton(onClick = {
                        navController.navigate("DetailScreen")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "edit"
                        )
                    }

                    FloatingActionButton(
                        onClick = { },
                        containerColor = Color(0xFFFFEB38)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "ADD"
                        )

                    }
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete"
                        )
                    }
                }

            }
        },
    ) { contentPadding ->
        CategorizedLazyColumn(
            categories = namesList,
            modifier = modifier,
            navController = navController,
        )
    }

    }}



