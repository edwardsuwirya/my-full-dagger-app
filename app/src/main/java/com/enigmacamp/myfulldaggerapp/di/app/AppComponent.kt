package com.enigmacamp.myfulldaggerapp.di.app

import android.app.Application
import com.enigmacamp.myfulldaggerapp.BaseApplication
import com.enigmacamp.myfulldaggerapp.di.annotation.AppScope
import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationComponent
import com.enigmacamp.myfulldaggerapp.di.authentication.AuthenticationRepoModule
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerComponent
import com.enigmacamp.myfulldaggerapp.di.customer.CustomerRepoModule
import com.enigmacamp.myfulldaggerapp.di.data.DataComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class],
    dependencies = [CustomerComponent::class, AuthenticationComponent::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

}