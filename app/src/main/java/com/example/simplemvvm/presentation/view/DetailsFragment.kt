package com.example.simplemvvm.presentation.view

import android.os.Bundle
import com.example.simplemvvm.MyApplication
import com.example.simplemvvm.R
import com.example.simplemvvm.databinding.FragmentDetailsBinding
import com.example.simplemvvm.di.DaggerAppComponent
import com.example.simplemvvm.domain.entity.SampleModel
import com.example.simplemvvm.presentation.viewmodel.MyViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DetailsFragment : BaseFragment<FragmentDetailsBinding, MyViewModel>() {
    private val objType by lazy {
        object : TypeToken<SampleModel>() {}.type
    }
    lateinit var sampleModel: SampleModel
    override fun getLayoutResource(): Int = R.layout.fragment_details

    override fun initDagger() {
        DaggerAppComponent.builder().coreComponent(MyApplication.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun getViewModel(): Class<MyViewModel> = MyViewModel::class.java

    override fun initComponents() {
        super.initComponents()
        val stringExtra = requireArguments().getString("model_key") ?: ""
        if (stringExtra.isNotEmpty()) {
            sampleModel = Gson().fromJson(stringExtra, objType)
            binding.apply {
                model = sampleModel
            }
        }
    }

    companion object{
        fun newInstance(args: Bundle):DetailsFragment{
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}