package com.example.myapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    suspend fun insert(obj: List<com.example.myapplication.data.db.Entity>)

    @Query("SELECT * from github_repos")
    suspend fun getLists(): List<com.example.myapplication.data.db.Entity>

    @Query("DELETE from github_repos")
    suspend fun deleteAll()

}