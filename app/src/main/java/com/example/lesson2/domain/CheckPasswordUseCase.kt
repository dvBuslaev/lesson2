package com.example.lesson2.domain

class CheckPasswordUseCase(private val repository: useCaseRepository){
    suspend fun checkPasswordUseCase(username: String,password:String):Boolean{
        return repository.checkPassword(username, password)
    }
}