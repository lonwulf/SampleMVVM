package com.example.simplemvvm.data

import com.example.simplemvvm.domain.entity.SampleModel
import com.example.simplemvvm.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(): SampleRepository {
    override fun generateSampleData(): List<SampleModel> {
        return listOf(
            SampleModel(
                id = 0,
                title = "Title 1",
                body = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
            ),
            SampleModel(
                id = 1,
                title = "Title 2",
                body = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
            ),
            SampleModel(
                id = 2,
                title = "Title 3",
                body = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
            ),
            SampleModel(id = 3, title = "Title 4", body = "Tired of generating this.")
        )
    }

}