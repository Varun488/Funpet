package com.example.funpet.ui.theme.Screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel(){

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents){

        when(event){
            is UserDataUiEvents.userNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.animalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }

    }


}

data class UserInputScreenState(
    var nameEntered : String =  "",
    var animalSelected : String = ""

)

sealed class UserDataUiEvents{
    data class  userNameEntered(val name: String) : UserDataUiEvents()

    data class animalSelected(val animalValue: String) : UserDataUiEvents()
}