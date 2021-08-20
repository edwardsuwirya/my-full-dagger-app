package com.enigmacamp.myfulldaggerapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enigmacamp.myfulldaggerapp.data.entity.Customer


@Database(entities = [Customer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}