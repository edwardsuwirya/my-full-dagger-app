package com.enigmacamp.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enigmacamp.core.data.entity.Customer


@Database(entities = [Customer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}