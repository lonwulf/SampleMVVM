package com.example.simplemvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvm.domain.entity.SampleModel
import com.example.simplemvvm.domain.repository.SampleRepository
import com.example.simplemvvm.presentation.adapter.SampleRvAdapter
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: SampleRepository) : ViewModel() {

    private var _clickableItemLiveData: MutableLiveData<SampleModel> = MutableLiveData()
    private var rvAdapter: SampleRvAdapter = SampleRvAdapter(this)

    fun setSampleRvAdapter(): SampleRvAdapter = rvAdapter

    val clickableItemLiveData: LiveData<SampleModel>
        get() = _clickableItemLiveData

    fun navigateToActivityDetails(model: SampleModel) {
        _clickableItemLiveData.value = model
    }

    init {
        submitDataToAdapter()
    }

    private fun submitDataToAdapter() {
        rvAdapter.submitDataToThisAdapter(repository.generateSampleData())
    }

}