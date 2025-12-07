package com.example.usersapiconsume.domain.repository

import com.example.usersapiconsume.data.api.RandomUsersApiService
import com.example.usersapiconsume.data.model.ResultModel
import javax.inject.Inject

class RandomUserRepository @Inject constructor(
    private val apiService: RandomUsersApiService
) {
    suspend fun getRandomUsers(results:Int = 5):List<ResultModel?>? {
       val response =  apiService.getRandomUsers(results = results)
        return if(response.isSuccessful){
            response.body()?.results.orEmpty()
        }else{
            throw Exception("API Error: ${response.code()}")
        }

    }
}