package com.example.simplemvvm.di.module

import com.example.simplemvvm.data.SampleRepositoryImpl
import com.example.simplemvvm.domain.repository.SampleRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindSampleRepository(sampleRepositoryImpl: SampleRepositoryImpl): SampleRepository
}