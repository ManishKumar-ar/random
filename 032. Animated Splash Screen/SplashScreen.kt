package com.example.navigation24

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.alpha

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {

    // here we use the alpa value to animated our text, like partially visible to fully visible.
    val alpha = remember {
        Animatable(0f)
    }


// whatever we write in the launched effect then composition it, execute automatically
    
    LaunchedEffect(
        key1 = true
    ) {
        alpha.animateTo(
            1f,
            animationSpec = tween(2500)
        )
        delay(3000)
        navController.popBackStack()
        navController.navigate("Onboarding")

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoaderAnimation(
            modifier = Modifier.size(400.dp),
            anim = R.raw.mobile_app

        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Let's make an App",
            modifier = Modifier.alpha(alpha.value),
            fontSize = 32.sp
        )


    }
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )

}

@Preview
@Composable
private fun xyz() {

    val navController = rememberNavController()
    SplashScreen(navController = navController)
}
