package com.example.lesson2.domain

class CheckLoginUseCase(private val repository: useCaseRepository){
    suspend fun checklogin(username:String):Boolean{
      return  repository.checkLogin(username)

    }
}