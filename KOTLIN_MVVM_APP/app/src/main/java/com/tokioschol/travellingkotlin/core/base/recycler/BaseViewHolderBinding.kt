package com.tokioschol.travellingkotlin.core.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tokioschol.travellingkotlin.BR
import com.tokioschol.travellingkotlin.core.base.BaseViewModel


class BaseViewHolderBinding(val viewmodel: BaseViewModel?, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Any?){
        binding.setVariable(BR.viewModel,viewmodel)
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}