package com.abdul.mvvmroom.ui.main

import androidx.lifecycle.*
import com.abdul.mvvmroom.data.Word
import com.abdul.mvvmroom.data.source.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository): ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()


    fun insert(word: Word) = viewModelScope.launch { //launch is a fire and forget coroutine[thread]
        repository.insert(word)
    }

    //factory produces/creates an object how its getting created is hidden and you just have to order what kind of object you want it will produce and give it
    class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return WordViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}