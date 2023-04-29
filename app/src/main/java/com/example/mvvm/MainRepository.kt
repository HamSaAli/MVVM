package com.example.mvvm

class MainRepository {
    private val api = FakeAPIService()
    private val database = FakeDataBase()

    fun getCurrentUser() = database.getCurrentUser()
    fun getRandomWisdom() = api.getRandomWisdom()

}