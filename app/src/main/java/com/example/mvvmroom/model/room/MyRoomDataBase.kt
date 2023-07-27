package com.example.mvvmroom.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Cat::class],
    version = 7,
    exportSchema = false
)
abstract class MyRoomDataBase : RoomDatabase() {

    abstract fun getDAO(): DAO


}