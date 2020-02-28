package com.kotlincodes.roomdatabasekotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kotlincodes.roomdatabasekotlin.model.UserModel

@Dao
interface UserDao {

    @Insert
    fun insert(user:UserModel)

    @Update
    fun update(user:UserModel)

    @Update
    fun delete(user:UserModel)

    @Query("SELECT * FROM USERS")
    fun getAllUsers():List<UserModel>

    @Query("SELECT * FROM USERS WHERE id==:id")
    fun getUserWithId(id:Int):UserModel
}
