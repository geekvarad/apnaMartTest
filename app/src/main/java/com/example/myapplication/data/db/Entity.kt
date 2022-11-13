package com.example.myapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_repos")
data class Entity(
    @PrimaryKey(autoGenerate = false) val userName: String,
    val repName: String,
    val detailLink: String,
    val languages: String,
    val stars: String,
    val forks: String,
    val time: Long
)