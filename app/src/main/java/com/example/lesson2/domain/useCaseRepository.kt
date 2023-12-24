package com.example.lesson2.domain

interface useCaseRepository {
    suspend fun checkLogin(username:String):Boolean
    suspend fun checkPassword(username: String,password:String):Boolean
}