package data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Jokes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    private val _currentUser = MutableLiveData<User>()
    val currentUser : LiveData<User>
    get() = _currentUser

    private val _randomWisdom = MutableLiveData<Wisdom>()
    val randomWisdom : LiveData<Wisdom>
    get() = _randomWisdom

    init {
        getRandomJoke()
        //getRandomWisdom()
    }

    private fun getRandomJoke() {
        APIservice.apiService.getRandomJoke().enqueue(object : Callback<Jokes>{
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {

            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {

            }

        })
    }

    fun getUserInfo(){
        _currentUser.postValue(repository.getCurrentUser())
    }

    private fun getRandomWisdom(){
        _randomWisdom.postValue(repository.getRandomWisdom())
    }
}