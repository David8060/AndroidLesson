package com.example.mvvmroom.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class Cat(

    val breed: String,
    val origin: String,
    val pattern: String,
    val coat: String,
    val country: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null


}