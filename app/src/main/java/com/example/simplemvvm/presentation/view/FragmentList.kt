package com.example.simplemvvm.presentation.view

import android.os.Bundle
import com.example.simplemvvm.MyApplication
import com.example.simplemvvm.R
import com.example.simplemvvm.databinding.ListFragmentBinding
import com.example.simplemvvm.di.DaggerAppComponent
import com.example.simplemvvm.presentation.viewmodel.MyViewModel
import com.example.simplemvvm.util.addFragment
import com.google.gson.Gson

class FragmentList : BaseFragment<ListFragmentBinding, MyViewModel>() {
    override fun getLayoutResource(): Int = R.layout.list_fragment

    override fun initDagger() {
        DaggerAppComponent.builder().coreComponent(MyApplication.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun getViewModel(): Class<MyViewModel> = MyViewModel::class.java
    override fun initComponents() {
        super.initComponents()
        binding.apply {
            viewModel = vM
            executePendingBindings()
        }
        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        vM.clickableItemLiveData.observe(this) {
            val modelData = Gson().toJson(it)
            val args = Bundle()
            args.putString("model_key", modelData)
            requireActivity().addFragment(
                R.id.container_id,
                requireContext(),
                DetailsFragment.newInstance(args),
                DetailsFragment().tag.toString(),
                true
            )
        }
    }

    companion object {
        fun newInstance(): FragmentList = FragmentList()
    }
}