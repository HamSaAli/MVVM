package data

import model.Jokes
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeRandomAPIService{
    @GET("joke/any")
    fun getRandomJoke(): Call<Jokes>

}

object APIservice{
    const val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(JokeRandomAPIService::class.java)
}