package com.example.usersapiconsume.data.model

data class UsersModel(
    val info: InfoModel? = InfoModel(),
    val results: List<ResultModel?>? = listOf()
)