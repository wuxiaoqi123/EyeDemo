package com.example.eyedemo.ui.home.commend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.eyedemo.logic.MainPageRepository
import com.example.eyedemo.logic.model.HomePageRecommend
import com.example.eyedemo.logic.network.api.MainPageService

class CommendViewModel(val repository: MainPageRepository) : ViewModel() {

    var dataList = ArrayList<HomePageRecommend.Item>()

    private var requestParamLiveData = MutableLiveData<String>()

    var nextPageUrl: String? = null

    val dataListLiveData = Transformations.switchMap(requestParamLiveData) { url ->
        liveData {
            val result = try {
                val recommend = repository.refreshHomePageRecommend(url)
                Result.success(recommend)
            } catch (e: Exception) {
                Result.failure<HomePageRecommend>(e)
            }
            emit(result)
        }
    }

    fun onRefresh() {
        requestParamLiveData.value = MainPageService.HOMEPAGE_RECOMMEND_URL
    }

    fun onLoadMore() {
        requestParamLiveData.value = nextPageUrl ?: ""
    }
}