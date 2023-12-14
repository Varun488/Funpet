package com.example.funpet.ui.theme.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ){
            TopBar(value = "Welcome ${username} \uD83D\uDE0D")

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                value = "Thankyou for sharing your data",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
            val finalText = if(animalSelected=="Cat") "You are a Cat lover\uD83D\uDC36" else "You are a Dog lover\uD83D\uDE0D"
            TextWithShadow(value = finalText)
            FactComposable(value = "Here is first fact")
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "Cat")
}