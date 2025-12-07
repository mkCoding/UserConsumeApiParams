package com.example.usersapiconsume.presentation

import com.example.usersapiconsume.data.model.NameModel
import com.example.usersapiconsume.data.model.PictureModel
import com.example.usersapiconsume.data.model.ResultModel

object PreviewData {

    private val fakeName = NameModel(title = "Ms", first = "Emma", last = "Watson")
    private val fakePicture = PictureModel(
        large = "https://randomuser.me/api/portraits/women/44.jpg",
        medium = "https://randomuser.me/api/portraits/med/women/44.jpg",
        thumbnail = "https://randomuser.me/api/portraits/thumb/women/44.jpg"
    )

    private val fakeUser = ResultModel(
        name = fakeName,
        email = "emma.watson@example.com",
        phone = "(555) 123-4567",
        picture = fakePicture,
        gender = "female"
    )

    val users: List<ResultModel> = listOf(
        fakeUser,
        fakeUser.copy(name = fakeUser.name?.copy(first = "Liam", last = "Neeson"), email = "liam@example.com"),
        fakeUser.copy(name = fakeUser.name?.copy(first = "Sophia", last = "Miller"), gender = "female"),
        fakeUser.copy(name = fakeUser.name?.copy(first = "Noah", last = "Brown"), gender = "male"),
        fakeUser.copy(name = fakeUser.name?.copy(first = "Olivia", last = "Davis"), gender = "female"),
        )

        // For sealed class previews
    val loadingState = RandomUserState.Loading
    val successState = RandomUserState.Success(users)
    val errorState = RandomUserState.Error("No internet connection")
}