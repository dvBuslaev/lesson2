package com.example.lesson2.presentation.authFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson2.data.UseCaseRepositoryImp
import com.example.lesson2.domain.CheckLoginUseCase
import com.example.lesson2.domain.CheckPasswordUseCase

class AuthViewModel : ViewModel() {
    private val repository = UseCaseRepositoryImp
    private val checkLoginUseCase= CheckLoginUseCase(repository)
    private val checkPasswordUseCase= CheckPasswordUseCase(repository)

    private val _isloginCorrect = MutableLiveData<Boolean>()
    val isloginCorrect: LiveData<Boolean>
        get() = _isloginCorrect


    private val _ispasswordCorrect = MutableLiveData<Boolean>()
    val ispasswordCorrect: LiveData<Boolean>
        get() = _ispasswordCorrect



    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    suspend fun checkLogin(username: String){
        if (checkLoginUseCase.checklogin(username)){
            _isloginCorrect.value = true
        }
    }
    suspend fun checkPassword(username: String,password:String){
        if (checkPasswordUseCase.checkPasswordUseCase(username,password)){
            _ispasswordCorrect.value = true
        }
    }



}