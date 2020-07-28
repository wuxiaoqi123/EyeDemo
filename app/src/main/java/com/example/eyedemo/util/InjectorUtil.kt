package com.example.eyedemo.util

import com.example.eyedemo.logic.MainPageRepository
import com.example.eyedemo.logic.dao.EyepetizerDatabase
import com.example.eyedemo.logic.network.EyepetizerNetwork
import com.example.eyedemo.ui.home.discovery.DiscoveryViewModelFactory

object InjectorUtil {

    private fun getMainPageRepository() = MainPageRepository.getInstance(
        EyepetizerDatabase.getMainPageDao(),
        EyepetizerNetwork.getInstance()
    )

    fun getDiscoveryViewModelFactory() = DiscoveryViewModelFactory(getMainPageRepository())

}