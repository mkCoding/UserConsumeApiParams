package com.example.usersapiconsume.data.model

data class LoginModel(
    val md5: String? = "",
    val password: String? = "",
    val salt: String? = "",
    val sha1: String? = "",
    val sha256: String? = "",
    val username: String? = "",
    val uuid: String? = ""
)