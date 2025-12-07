package com.example.usersapiconsume.data.model

data class ResultModel(
    val cell: String? = "",
    val dob: DobModel? = DobModel(),
    val email: String? = "",
    val gender: String? = "",
    val id: IdModel? = IdModel(),
    val location: LocationModel? = LocationModel(),
    val login: LoginModel? = LoginModel(),
    val name: NameModel? = NameModel(),
    val nat: String? = "",
    val phone: String? = "",
    val picture: PictureModel? = PictureModel(),
    val registered: RegisteredModel? = RegisteredModel()
)