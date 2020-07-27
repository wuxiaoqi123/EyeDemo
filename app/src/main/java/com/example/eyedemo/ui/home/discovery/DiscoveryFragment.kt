package com.example.eyedemo.ui.home.discovery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eyedemo.R
import com.example.eyedemo.ui.common.ui.BaseFragment

class DiscoveryFragment : BaseFragment() {

    companion object {

        fun newInstance() = DiscoveryFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(
            inflater.inflate(
                R.layout.fragment_refresh_layout,
                container,
                false
            )
        )
    }
}