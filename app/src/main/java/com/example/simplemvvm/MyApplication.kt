package com.example.simplemvvm

import android.app.Application
import android.content.Context
import com.example.simplemvvm.di.CoreComponent
import com.example.simplemvvm.di.DaggerCoreComponent

class MyApplication :Application() {
    lateinit var coreComponent: CoreComponent

    companion object{
        fun coreComponent(ctx:Context) = (ctx.applicationContext as? MyApplication)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDependencyInjection()
    }

    private fun initCoreDependencyInjection(){
        coreComponent = DaggerCoreComponent.builder().application(this).build()
    }
}