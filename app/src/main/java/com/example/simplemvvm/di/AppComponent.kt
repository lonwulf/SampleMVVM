package com.example.simplemvvm.di

import com.example.simplemvvm.di.annotations.Featurescope
import com.example.simplemvvm.di.module.RepositoryModule
import com.example.simplemvvm.di.module.ViewModelModule
import com.example.simplemvvm.presentation.view.DetailsFragment
import com.example.simplemvvm.presentation.view.FragmentList
import com.example.simplemvvm.presentation.view.MainActivity
import dagger.Component

@Featurescope
@Component(
    dependencies = [CoreComponent::class],
    modules = [ViewModelModule::class, RepositoryModule::class]
)
interface AppComponent {
    fun inject(fragmentList: FragmentList)
    fun inject(detailActivity: DetailsFragment)
}