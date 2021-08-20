package com.enigmacamp.myfulldaggerapp.di.app

import android.app.Application
import com.enigmacamp.myfulldaggerapp.BaseApplication
import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationModule
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerModule
import com.enigmacamp.myfulldaggerapp.di.presentation.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        CustomerModule::class,
        AuthenticationModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}