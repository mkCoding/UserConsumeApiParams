package com.example.usersapiconsume.data.api

import android.os.UserManager
import com.example.usersapiconsume.data.model.ResultModel
import com.example.usersapiconsume.data.model.UsersModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUsersApiService {
    @GET(RandomUsersApiDetails.ENDPOINT_USERS)
    suspend fun getRandomUsers(
        @Query(RandomUsersApiDetails.Params.RESULTS) results: Int = 20,
    ): Response<UsersModel>
}
