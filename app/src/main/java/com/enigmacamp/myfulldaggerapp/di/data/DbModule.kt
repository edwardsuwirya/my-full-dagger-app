package com.enigmacamp.myfulldaggerapp.di.app

import android.app.Application
import androidx.room.Room
import com.enigmacamp.myfulldaggerapp.data.db.AppDatabase
import com.enigmacamp.myfulldaggerapp.data.db.CustomerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "enigma_database"
        ).build()
    }

    @Provides
    fun provideCustomerDao(db: AppDatabase): CustomerDao {
        return db.customerDao()
    }
}