package model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    interface JokeRandomAPIService{
        fun getRandomJoke()
    }

    companion object{
        private const val BASE_URL = "https://v2.jokeapi.dev/"
    }
}