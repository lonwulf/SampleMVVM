package com.example.simplemvvm.domain.repository

import com.example.simplemvvm.domain.entity.SampleModel

interface SampleRepository {
    fun generateSampleData():List<SampleModel>
}