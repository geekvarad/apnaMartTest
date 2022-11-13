package com.example.myapplication.domain

import com.example.myapplication.data.api.Items
import com.example.myapplication.data.db.Entity

fun Items.toDbEntity(): Entity {
    return Entity(
        userName = owner?.login ?: "",
        repName = name ?: "",
        detailLink = htmlUrl ?: "",
        languages = language ?: "",
        stars = owner?.starredUrl ?: "",
        forks = forksCount.toString() ?: "0",
        time = System.currentTimeMillis()
    )
}