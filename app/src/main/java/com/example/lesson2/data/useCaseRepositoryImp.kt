package com.example.lesson2.data

import com.example.lesson2.domain.useCaseRepository
import kotlinx.coroutines.delay

object UseCaseRepositoryImp : useCaseRepository {
    private val persons = mutableListOf<Person>()

    override suspend fun checkLogin(username: String): Boolean {
        delay(1000L)
        return persons.any { it.login == username }
    }

    override suspend fun checkPassword(username: String, password: String): Boolean {
        delay(1000L)
        return persons.any { it.login == username && it.password == password }
    }


    private fun createPerson() {
        for (i in 1..10) {
            val person = Person(login = "username$i", password = "password$i")
            persons.add(person)
        }

    }

}