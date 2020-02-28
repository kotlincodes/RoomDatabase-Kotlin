package com.kotlincodes.roomdatabasekotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int=(1..10000).random(),
    var name:String="",
    var mobile:String=""
)