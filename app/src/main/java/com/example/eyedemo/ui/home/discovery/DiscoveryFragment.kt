package com.example.eyedemo.ui.home.discovery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eyedemo.R
import com.example.eyedemo.ui.common.ui.BaseFragment
import com.example.eyedemo.util.InjectorUtil
import kotlinx.android.synthetic.main.fragment_refresh_layout.*

class DiscoveryFragment : BaseFragment() {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            InjectorUtil.getDiscoveryViewModelFactory()
        ).get(DiscoveryViewModel::class.java)
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = null
        refreshLayout.setOnRefreshListener { viewModel.onRefresh() }
        refreshLayout.setOnLoadMoreListener { viewModel.onLoadMore() }
    }
}