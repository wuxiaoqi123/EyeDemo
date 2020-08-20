package com.example.eyedemo.ui.notification.push

import androidx.lifecycle.ViewModelProvider
import com.example.eyedemo.ui.common.ui.BaseFragment
import com.example.eyedemo.util.InjectorUtil

class PushFragment : BaseFragment() {

    companion object {
        fun newInstance() = PushFragment()
    }

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            InjectorUtil.getPushViewModelFactory()
        ).get(PushViewModel::class.java)
    }
}