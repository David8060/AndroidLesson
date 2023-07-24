package com.example.mvvmroom.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cats: List<Cat>?)

    @Query("SELECT * FROM cat_table")
    fun getAllDatas(): List<Cat>

}