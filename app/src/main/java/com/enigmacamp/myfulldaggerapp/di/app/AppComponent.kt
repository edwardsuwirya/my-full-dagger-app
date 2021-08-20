package com.enigmacamp.myfulldaggerapp.di.app

import android.app.Application
import com.enigmacamp.myfulldaggerapp.BaseApplication
import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationRepoModule
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerRepoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        DbModule::class,
        SharedPrefModule::class,
        CustomerRepoModule::class,
        AuthenticationRepoModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}