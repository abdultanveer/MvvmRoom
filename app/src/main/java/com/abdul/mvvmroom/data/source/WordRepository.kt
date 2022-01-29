package com.abdul.mvvmroom.data.source

import androidx.annotation.WorkerThread
import com.abdul.mvvmroom.data.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {


    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}