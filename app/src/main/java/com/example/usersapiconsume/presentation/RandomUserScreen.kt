package com.example.usersapiconsume.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.usersapiconsume.data.model.NameModel
import com.example.usersapiconsume.data.model.ResultModel

@Composable
fun RandomUserScreen(
    userState: RandomUserState,
    viewModel: RandomUserViewModel = hiltViewModel()
) {

    var results = 7
    LaunchedEffect(results) {
        viewModel.loadRandomUsers(results)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))
        Text("All Users", fontSize = 50.sp, modifier = Modifier.padding(16.dp))

        when (userState) {
            is RandomUserState.Loading -> {
                CircularProgressIndicator()
            }
            is RandomUserState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    val randomUserList = userState.userData.orEmpty()
                    items(randomUserList) { item ->
                        Text("${item?.name?.first}")
                    }
                }
            }
            is RandomUserState.Error -> {
                Text(text = "${userState.message}")
            }
            else -> {}
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RandomUserScreePreview() {
    RandomUserScreen(
        userState = RandomUserState.Success(
            userData = listOf(
                ResultModel(
                    email = "johns@gmail.com",
                    gender = "male",
                    name = NameModel("John", "Smith", "Mr")
                )
            )
        )
    )
}