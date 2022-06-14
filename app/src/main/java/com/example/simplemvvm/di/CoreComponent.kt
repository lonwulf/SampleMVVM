package com.example.simplemvvm.di

import android.app.Application
import android.content.Context
import com.example.simplemvvm.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface CoreComponent {
    fun context(): Context

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }
}