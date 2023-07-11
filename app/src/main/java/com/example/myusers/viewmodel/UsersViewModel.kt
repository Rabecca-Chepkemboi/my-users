package com.example.myusers.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myusers.models.User
import com.example.myusers.repository.UsersRepository
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {
    val usersRepo= UsersRepository()
    var usersLiveData=MutableLiveData<List<User>>()
    var errorLiveData=MutableLiveData<String>()
    fun fetchUsers(){
        viewModelScope.launch {
            val response =usersRepo.getUsers()
            if(response.isSuccessful){
                usersLiveData.postValue(response.body()?.users)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}