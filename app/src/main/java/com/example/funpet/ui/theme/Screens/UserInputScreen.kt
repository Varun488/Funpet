package com.example.funpet.ui.theme.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funpet.R
import com.example.funpet.ui.theme.Screen.UserDataUiEvents
import com.example.funpet.ui.theme.Screen.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel
,showWelcomeScreen: (valuesPair : Pair<String,String>) -> Unit) {
     Surface(
         modifier = Modifier.fillMaxSize()
     ){
         Column (modifier = Modifier
             .fillMaxWidth()
             .padding(18.dp)){
               TopBar(value = "Hi there \uD83D\uDE0A")

             Spacer(modifier = Modifier.size(20.dp))

             TextComponent(
                 value = "Let's learn about you !",
                 textSize = 24.sp
             )
             Spacer(modifier = Modifier.size(20.dp))
             TextComponent(
                 value = "This app will prepare a details page based on input provided by you.",
                 textSize = 18.sp )
             Spacer(modifier = Modifier.size(60.dp))
             TextComponent(value = "Name", textSize = 18.sp )
             Spacer(modifier = Modifier.size(10.dp))
             TextFieldComponent(
                 onTextChanged = {
                     userInputViewModel.onEvent(
                         UserDataUiEvents.userNameEntered(it)
                     )
                 }
             )
             Spacer(modifier = Modifier.size(20.dp))
             TextComponent(value = "What do you like?", textSize = 18.sp)
             Row (
                 modifier = Modifier.fillMaxWidth()
             ){
                 AnimalCard(image = R.drawable.cat, animalSelected = {
                     userInputViewModel.onEvent(
                         UserDataUiEvents.animalSelected(it)
                     )
                 }, selected = userInputViewModel.uiState.value.animalSelected=="Cat")
                 AnimalCard(image = R.drawable.dog,animalSelected = {
                     userInputViewModel.onEvent(
                         UserDataUiEvents.animalSelected(it)
                     )
                 }, selected = userInputViewModel.uiState.value.animalSelected=="Dog")
             }
             Spacer(modifier = Modifier.weight(1f))
             if(!userInputViewModel.uiState.value.animalSelected.isNullOrEmpty() && !userInputViewModel.uiState.value.nameEntered.isNullOrEmpty())
             ButtonComponent(
                 goToDetailsScreen = {

                     showWelcomeScreen(
                         Pair(
                             userInputViewModel.uiState.value.nameEntered,
                             userInputViewModel.uiState.value.animalSelected
                         )
                     )

                 }
             )
         }
     }
}



