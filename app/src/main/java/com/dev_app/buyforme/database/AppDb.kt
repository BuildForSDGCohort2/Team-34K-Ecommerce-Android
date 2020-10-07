package com.dev_app.buyforme.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev_app.buyforme.models.User


@Database(entities = [User::class], version = 2)
abstract class AppDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}