package com.abdul.mvvmroom.data.source.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdul.mvvmroom.data.source.WordDao


//how to make a class singleton -- ie only one object of the class should exist
//make the constructor for the class as private and have a static method -getInstance return the same instance
abstract class WordRoomDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object { //companion is like static in java
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase { //method name is getDatabase, this method takes a param called context and it returns an object of type WordRoomDatabase
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
        }

}