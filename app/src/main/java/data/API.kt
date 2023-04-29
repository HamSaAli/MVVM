package data

import io.reactivex.rxjava3.core.Single
import model.Jokes
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeRandomAPIService{
    @GET("joke/any")
    fun getRandomJoke(): Single<Jokes>

}

object APIservice{
    const val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService = retrofit.create(JokeRandomAPIService::class.java)
}