package com.example.simplemvvm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemvvm.BR
import com.example.simplemvvm.databinding.RecyclerviewItemBinding
import com.example.simplemvvm.domain.entity.SampleModel
import com.example.simplemvvm.presentation.viewmodel.MyViewModel

class SampleRvAdapter(private val viewModel: MyViewModel) :
    RecyclerView.Adapter<SampleRvAdapter.GenericViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<SampleModel>() {
        override fun areItemsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SampleModel, newItem: SampleModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitDataToThisAdapter(modelList: List<SampleModel>) {
        differ.submitList(modelList)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemBinding.inflate(inflater, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        when (holder) {
            is GenericViewHolder -> {
                if (position < itemCount) {
                    holder.bind(differ.currentList[position], viewModel)
                }
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class GenericViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sampleModel: SampleModel, viewModel: MyViewModel) = with(binding.root) {
            binding.apply {
                setVariable(BR.viewModel, viewModel)
                setVariable(BR.model, sampleModel)
                executePendingBindings()
            }
        }
    }
}