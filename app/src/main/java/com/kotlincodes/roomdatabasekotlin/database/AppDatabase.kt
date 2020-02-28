package com.kotlincodes.roomdatabasekotlin.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlincodes.roomdatabasekotlin.model.UserModel


@Database(entities = [UserModel::class], version =1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun users():UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "room-kotlin-database"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}