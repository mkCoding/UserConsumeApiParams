package com.example.usersapiconsume.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usersapiconsume.data.model.ResultModel
import com.example.usersapiconsume.data.model.UsersModel
import com.example.usersapiconsume.domain.repository.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val repository: RandomUserRepository
): ViewModel(){

    // randomUserState
    private val _userState = MutableStateFlow<RandomUserState>(RandomUserState.Loading)
    val userState: StateFlow<RandomUserState> = _userState

    init {
       // loadRandomUsers()
    }

    fun loadRandomUsers(results: Int = 20) {
        viewModelScope.launch {
            // hold the data
            try {
                val data = repository.getRandomUsers(results = results)
                _userState.value = RandomUserState.Success(data)
            }catch (e:Exception){
                _userState.value = RandomUserState.Error("${e.message}")
            }
        }

    }
}

sealed class RandomUserState{
    object Loading: RandomUserState()
    data class Success(val userData: List<ResultModel?>? ): RandomUserState()
    data class Error(val message:String): RandomUserState()
}



