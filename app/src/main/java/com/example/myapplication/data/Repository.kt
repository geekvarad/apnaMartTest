package com.example.myapplication.data

import com.example.myapplication.utility.Utils
import com.example.myapplication.data.db.Dao
import com.example.myapplication.data.db.Entity
import com.example.myapplication.domain.toDbEntity

class Repository(val dao: Dao) {


    suspend fun getdata(): List<Entity> {

        var repo_lists = dao.getLists()

        return if (repo_lists.isEmpty() || repo_lists == null || ((System.currentTimeMillis() - repo_lists[0].time) >= 2 * 60 * 60 * 1000)) {
            if (repo_lists != null)
                deleteAll()
            fetchData()
            repo_lists = dao.getLists()
            repo_lists
        } else
            repo_lists


    }

    private suspend fun fetchData() {

        val result = Utils.getRetrofitInstance().getRepositories("stars")
        if (result.isSuccessful && result != null && result.body() != null) {
            updatedb(result.body()!!.items.map { it.toDbEntity() })
        }

    }

    suspend fun updatedb(body: List<Entity>) = dao.insert(body)
    suspend fun deleteAll() = dao.deleteAll()
}
