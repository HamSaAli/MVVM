package data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import model.Jokes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User>
        get() = _currentUser

    private val _randomWisdom = MutableLiveData<Wisdom>()
    val randomWisdom: LiveData<Wisdom>
        get() = _randomWisdom

    private val _randomJoke = MutableLiveData<Jokes>()
    val randomJoke: LiveData<Jokes>
        get() = _randomJoke

    init {
        getRandomJoke()
        getRandomWisdom()
    }

    private fun getRandomJoke() {
        APIservice.apiService.getRandomJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccessJokes, this::onError)
    }

    private fun onSuccessJokes(joke: Jokes){
        _randomJoke.postValue(joke)
    }
    private fun onError(throwable: Throwable){

    }
    fun getUserInfo() {
        _currentUser.postValue(repository.getCurrentUser())
    }

    private fun getRandomWisdom() {
        _randomWisdom.postValue(repository.getRandomWisdom())
    }
}