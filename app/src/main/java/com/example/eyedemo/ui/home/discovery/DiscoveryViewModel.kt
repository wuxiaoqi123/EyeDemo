package com.example.eyedemo.ui.home.discovery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.eyedemo.logic.MainPageRepository
import com.example.eyedemo.logic.model.Discovery
import com.example.eyedemo.logic.network.api.MainPageService

class DiscoveryViewModel(repository: MainPageRepository) : ViewModel() {

    var dataList = ArrayList<Discovery.Item>()

    private var requestParamLiveData = MutableLiveData<String>()

    var nextPageUrl: String? = null

    val dataListLiveData = Transformations.switchMap(requestParamLiveData) { url ->
        liveData {
            val result = try {
                val discovery = repository.refreshDiscovery(url)
                Result.success(discovery)
            } catch (e: Exception) {
                Result.failure<Discovery>(e)
            }
            emit(result)
        }
    }

    fun onRefresh() {
        requestParamLiveData.value = MainPageService.DISCOVERY_URL
    }

    fun onLoadMore() {
        requestParamLiveData.value = nextPageUrl ?: ""
    }
}