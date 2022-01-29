package com.abdul.mvvmroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class is a model or POJO - plain old java object, VO[one value]

@Entity(tableName = "word_table")
data class Word(@PrimaryKey (autoGenerate = true) val id: Int,
                @ColumnInfo(name = "word")        val word: String)