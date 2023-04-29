package data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    private val _currentUser = MutableLiveData<User>()
    val currentUser : LiveData<User>
    get() = _currentUser

    private val _randomWisdom = MutableLiveData<Wisdom>()
    val randomWisdom : LiveData<Wisdom>
    get() = _randomWisdom

    init {
        getRandomWisdom()
    }

    fun getUserInfo(){
        _currentUser.postValue(repository.getCurrentUser())
    }

    private fun getRandomWisdom(){
        _randomWisdom.postValue(repository.getRandomWisdom())
    }
}