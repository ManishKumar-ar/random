package com.example.navigation24

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun manish() {

    val pagerState = rememberPagerState(pageCount = 10)
    val scope = rememberCoroutineScope()

    val data = listOf("manish ", "vishal", "kajal", "reeema")

    Box(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        HorizontalPager(state = pagerState, modifier = Modifier.align(Alignment.Center)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = data[it], fontSize = 30.sp)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage -1)

                    }
                }) {
                    Text(text = "Back")

                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)

                    }
                }) {
                    Text(text = "Next")

                }
            }



            Row {
                repeat(data.size) {
                    Indicators(isSelected = pagerState.currentPage == it)
                }
            }
        }


    }

}

@Composable
fun Indicators(
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(color = if (isSelected) Color.Red else Color.Gray, shape = CircleShape)
            .size(10.dp)
    )


}

@Preview(showSystemUi = true)
@Composable
private fun xyz() {
    manish()
}