package com.example.myapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {

        fun create(context: Context): GithubDatabase {

            return Room.databaseBuilder(
                context,
                GithubDatabase::class.java,
                "github_repos"
            ).build()
        }
    }
}