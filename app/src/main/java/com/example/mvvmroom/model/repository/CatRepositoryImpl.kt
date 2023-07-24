package com.example.mvvmroom.model.repository

import com.example.mvvmroom.model.retrofit.MyApi
import com.example.mvvmroom.model.room.Cat
import com.example.mvvmroom.model.room.DAO

interface CatRepository {
    suspend fun insertAll(cats: List<Cat>?)
    fun getAllDatas(): List<Cat>
    suspend fun doNetworkCall(): List<Cat>?
}


class CatRepositoryImpl(private val dao: DAO, private val api: MyApi) : CatRepository {

    override suspend fun insertAll(cats: List<Cat>?) {
        dao.insertAll(cats)
    }

    override fun getAllDatas(): List<Cat> {
        return dao.getAllDatas()
    }


    override suspend fun doNetworkCall(): List<Cat>? {
        try {
            val response = api.callApi()
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    return data.data
                }
                return null
            }
            return null
        } catch (e: Exception) {
            throw Exception("Network call failed: ${e.message}")
        }
    }
}