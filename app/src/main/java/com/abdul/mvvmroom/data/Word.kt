package com.abdul.mvvmroom.data

import androidx.room.Entity

//data class is a model or POJO - plain old java object, VO[one value]

@Entity(tableName = "word_table")
data class Word(val word: String)