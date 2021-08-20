package com.enigmacamp.myfulldaggerapp.di.presentation

import com.enigmacamp.myfulldaggerapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}