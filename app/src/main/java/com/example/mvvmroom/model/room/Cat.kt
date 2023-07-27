package com.example.mvvmroom.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class Cat(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val breed: String,
    val origin: String,
    val pattern: String,

    )